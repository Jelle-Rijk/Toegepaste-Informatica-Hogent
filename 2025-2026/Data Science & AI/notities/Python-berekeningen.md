# Algemene berekeningen

## Cramér's V

```python
stats.contingency.association(observed_values, method='cramer')
```

Uitkomst:

- 0 = geen associatie
- 0.1 = zwakke associatie
- 0.25 = gemiddelde associatie
- 0.5 = sterke associatie
- 0.75 = zeer sterke associatie
- 1 = complete associatie

## Goodness of fit

Principe is altijd hetzelfde: observed_values en expected_values bereken

```python
chi2, p_value = stats.chisquare(f_obs=observed, f_expected=expected)
```

## Chi2 test of independence

```python
observed
observed_values_crosstab = pd.crosstab(observed.Dependent, observed.Independent)
chi2, p_value, dof, expected = stats.chi2_contingency(observed_values_crosstab)
critical_value = stats.chi2.isf(alpha, df=dof)
```

## Standardized residuals

```python
observed_waarde # bevat de waargenomen waarden
expected_waarde # bevat de waarden die je eigenlijk moest waarnemen
expected_probability # de probabiliteit van de waarde in het verwachte scenario = meestal gegeven (vb. x% van de bevolking)

# Standardized residual
standardized_residual = (observed_waarde - expected_waarde) / np.sqrt(expected_waarde * (1 - expected_probability))

# Als kolom gebaseerd op tabel expected en tabel observed
waarden['Standardized_Residual'] = (waarden['Observed'] - waarden['Expected']) / np.sqrt(waarden['Expected'] * (1 - waarden['Verwachte_Probability']))
```

Als de verwachte probability niet gegeven is -> skippen, behalve bij extra tijd (<a href="../labs-en-code/4-bivariate-qual/4.01-chi-squared.ipynb#Standardised-residuals
">zie voorbeeld standardized residuals</a>)

## T-test voor twee independent samples

```python
# t handmatig berekenen - let op, het zijn sample means -> dus ddof=1 bij mean()
t = (mean1 - mean2) / np.sqrt(std1**2/n1 + std2**2/n2)
```

```python
stats.ttest_ind(a=groep1, b=groep2, alternative='less', equal_var=False)
# equal_var=False betekent dat beide groepen niet per se dezelfde standaardafwijking hebben
# alternative less -> a < b
```

## T-test voor twee paired samples

vb. twee metingen van zelfde element

```python
t_value, p_value, df = stats.ttest_rel(resultaten_eerste_meting, resultaten_tweede_meting, alternative='less')
# less -> eerste metingen liggen lager dan tweede metingen
```

## Cohen's d

Geen functie in libraries, deze toevoegen:

```python
def cohen_d(a, b):
    na = len(a)
    nb = len(b)
    pooled_sd = np.sqrt( ((na-1) * np.var(a, ddof=1) +
                          (nb-1) * np.var(b, ddof=1)) / (na + nb - 2) )
    return (np.mean(b) - np.mean(a)) / pooled_sd
```

# Twee kwantitatieve variabelen

```python
# Covariantie
cov = np.cov(var1, var2, ddof=1)[0][1]

# Pearson's R - correlatiecoëfficient
r = np.corrcoef(var1, var2)[0][1]

# R2 (twee manieren)
r2 = r**2

model = LinearRegression.fit(var1, var2)
r2 = model.score(var1, var2)

```

## Scope en intercept berekenen

```python
scope, intercept = np.polyfit(x=independent, y=dependent, deg=1)
```

# Data cleaning

## Ordinale waarden

```python
datatype = CategoricalDtype(categories=["cat1", "cat2", "cat3"], ordered = True)
dataframe['kolom'] = dataframe['kolom'].astype(datatype)
```

# Gemaakte oefeningen

## Chi2

- <a href="../labs-en-code/4-bivariate-qual/lab-4.03-discrimination.ipynb\">Kijken of één kwalitatieve waarde aan de goodness of fit test voldoet (samenstelling blank-afro binnen een school) + standardized residual berekenen</a>
- <a href="../labs-en-code/4-bivariate-qual/lab-4.05-survey.ipynb">Kijken of twee kwalitatieve waarden independent zijn (Australian survey)</a>
- <a href="../labs-en-code/4-bivariate-qual/lab-4.06-music-wine.ipynb">Crosstab opstellen + plotten van dependent variables</a>
- <a href="../labs-en-code/4-bivariate-qual/lab-4.07-digimeter-sample.ipynb">Goodness of fit test + mergen van categorieën binnen dataframe. (Digimeter)</a>
- <a href="../labs-en-code/4-bivariate-qual/lab-4.08-off-days.ipynb">Lijst van namen omvormen naar namen + counts (en berekenen standardized residuals) (Employee Saturdays off)</a>

## T-test paired

- <a href="../labs-en-code/5-bivariate-qual-quant/lab-5.01-soft-drink-cans.ipynb">Boxplot maken voor paired samples + t-test berekenen (Oude vs nieuwe blikjes)</a>
- - <a href="../labs-en-code/5-bivariate-qual-quant/lab-5.03-computer-training.ipynb">T-test paired samples + Cohen's D (Effect van computer training)</a>

## T-test 2 independent samples

- <a href="../labs-en-code/5-bivariate-qual-quant/lab-5.02-exercise-facilities.ipynb">T-test met 2 independent variabelen berekenen + Cohen's D (Exercise facilities)</a>

## Scatterplots + linear regression

- <a href='../labs-en-code/6-regression-analyis/lab-6.01-cats.ipynb'>Basisoefeningen -> cov, r en r2 bepalen + alles plotten (katten)</a>
- <a href='../labs-en-code/6-regression-analyis/lab-6.02-agriculture.ipynb'>Meer basisoefeningen (landbouw)</a> -<a href='../labs-en-code/6-regression-analyis/lab-6.03-movies.ipynb'>Plots naast elkaar zetten + data cleanen (nan handlen) + outliers verwijderen, limits berekenen (Films)</a>
- <a href='../labs-en-code/6-regression-analyis/lab-6.04-production.ipynb'>Basisoefeningen (productie)</a>
