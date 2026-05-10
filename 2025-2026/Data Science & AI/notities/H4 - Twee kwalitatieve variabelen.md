<h1>Twee kwalitatieve variabelen: &chi;<sup>2</sup> en Cramérs V</h1>

# Independent en dependent variable

In een contingency-table / crosstab staat de independent variable bovenaan (kolommen) en de dependent variable op de rijen.

# Visualisatie

We willen een dataset met kolommen Dependent als dependent variable en Independent als independent variable plotten:

Clustered barchart (Seaborn): `sns.catplot(data=dataset, x='Dependent', hue='Independent', kind='count')`

Crosstab met margins (Pandas): `pd.crosstab(dataset.Dependent, dataset.Independent, margins=True)`

Stacked barchart (Pandas):

```python
crosstab = pd.crosstab(dataset.Independent, dataset.Dependent, normalize='index') # let op omgekeerd van gewone crosstab!
# normalize index zorgt ervoor dat de relatieve frequenties beter te zien zijn.
crosstab.plot(kind='barh', stacked=True)
```

Mosaic diagram (MatPlotLib) -> Grootte van de cellen komt overeen met de frequentie van de observaties.

```python
plasma_colors = mpl.colormaps['plasma'] # We kiezen de kleurenverzameling

# key is een tuple van (Dependent, Independent = in dit geval een cijfer)
props = lambda key: {'color' : plasma_colors(int(key[1]/5))} # We delen de independent variable door vijf -> colormaps nemen een kommagetal en zetten dit om naar een kleur

mosaic = mosaic(data=dataset.sort_values(by=['Dependent']), index = ['Independent', 'Dependent', gap=0.01, properties=props])

```

# &Chi;<sup>2</sup> en Cramérs V

Expected value berekenen = $\frac{rowtotal \times columntotal}{total observations}$

De formule voor chi-squared is:

<abbr title="Je berekent van elke observatie de geobserveerde waarde - de verwachte waarde. Je neemt daar het kwadraat van en deelt het kwadraat door de expected waarde. Dan neem je de som van al die berekende waarden.">$\chi^2 = \sum_i \frac{(o_i - e_i)^2}{e_i}$</abbr>

Hoe lager $\chi^2$ hoe zwakker de associatie is tussen de twee variabelen.

Je kan dit met python snel doen:

```python
crosstab = pd.crosstab(dataset.Dependent, dataset.Independent)
row_sums = crosstab.sum(axis=1)
col_sums = crosstab.sum()
n = row_sums.sum # n = totaal aantal observaties

expected = np.outer(row_sums, col_sums) / n # returnt een tweedimensionale array met de expected values.


# Je kan dan snel de chi-squared test uitvoeren
diffs = (expected - crosstab)**2 / expected
chi_squared = diffs.values.sum()

```

Om $\chi^2$ te normaliseren gebruik je Cramér's V (zodat de waarde niet meer afhankelijk is van de hoeveelheid observaties)

n = totaal aantal observaties <br>
k = aantal rijen of kolommen (minimum van de twee) <br>
$V = \sqrt{\frac{\chi^2}{n(k-1)}}$

```python
# In python
cramers_v = np.sqrt(chi_squared / ((min(crosstab.shape) - 1) * n))

# Of je kan alles skippen en het volgende uitvoeren
stats.contingency.association(crosstab, method='cramer')
```

Cramér's V is vaak te optimistisch over de associaties. Daarom wordt een chi-squared test gedaan.

# &Chi;<sup>2</sup>-test

De chi-squared test gebruikt net zoals de t-test een degree of freedom. Je berekent deze met de formule:

$df = (rijen-1) \times (kolommen-1)$

SciPy heeft ook hier weer pdf, cdf, sf en isf functions voor in package `stats.chi2`, je moet telkens de waarde en de df meegeven.

Je kan de p-waarde dan uitrekenen met:
`stats.chi2.sf(waarde, df)` <br> Of de critical value met `stats.chi2.isf(significance_level, df)`

In plaats daarvan kan je ook de chi-squared test direct van de contingency table halen:

```python
# Chi-squared test in Python.
crosstab = pd.crosstab(dataset.Dependent, dataset.Independent)
chi2, p, df, expected = stats.chi2_contingency(crosstab)
```

## Cochran's regel

Om een reliable chi-squared test te doen moeten alle values in de crosstable minstens 1 zijn en mogen maximaal 20% van je waarden kleiner dan 5 zijn.

# Goodness-of-fit test

Is een test waarmee je kan kijken of een sample representatief is.

Je berekent hiervoor $\chi^2$. <br> Dan bereken je $df = (k-1)$. K = aantal categorieën in de sample. <br>
Bereken de <abbr title="Met g = stats.chi2.isf(alpha, df=df)">critical value</abbr> of <abbr title="Met  chi2, p = stats.chisquare(f_obs=observed_crosstab, f_exp=expected_crosstab)">p-waarde</abbr>.

Niet rejecten als p-waarde hoger is dan alfa, of als chi-squared lager is dan de critical value (g)

# Standardised residuals

Hiermee kan je kijken welke waarden het meest afwijken.
