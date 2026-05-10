<h1>Bivariate analyse: kwalitatief vs. kwantitatief</h1>

Independent variable = kwalitatief
Dependent variable = kwantitatief

ANOVA -> moet niet gekend zijn.

# Plotting

Zelfde graphs als bij twee kwalitatieve variabelen -> maar groeperen per kwalitatieve variabele

Boxplot -> Als er veel overlap is bij categorieën dan is er een zwakke of geen relatie

```python
sns.boxplot(data=df, x=dependent, y=independent) # omdraaien voor een verticale
```

Violinplot:

```python
sns.violinplot(data=df, x=dependent, y=independent)
```

Density plot:

```python
sns.kdeplot(data=df, hue=independent, x=dependent)
```

Gebruik geen bar charts van groepsgemiddelden -> als je dit doet moet je errorbars gebruikern

```python
sns.barplot(data=df, x=independent, y=dependent, errorbar='sd') # sd toont de standaardafwijking
```

# T-test voor twee independent samples

Stappenplan:

- Formuleer hypotheses
  - H0 = $\mu1 - \mu2$ = 0 ==> zelfde mean in beide groepen
  - H1 = $\mu1 - \mu2 < 0$ ==> &mu;<sub>2</sub> is veel groter dan &mu;<sub>1</sub>
- Kies alfa
- Reken de teststatistiek t uit (`stats.ttest_ind`)
- Reken p uit
- Trek conclusies

<abbr title="~x1 en ~x2 = de sample mean, s1 en s2 = de sample standaardafwijking, n1 en n2 = de sample sizes">Formule voor t:
$$t = \frac{\overline{x_1} - \overline{x_2}}{\sqrt{s_1^2/n_1 + s_2^2/n_2}}.$$
</abbr>

# T-test voor paired samples

-> Gebruiken wanneer twee metingen op eenzelfde element binnen de sample gedaan worden. Je wil weten of er een verschil is bij de eerste of tweede meting.

Basiswerkwijze: Resultaat van de tweede meting - de eerste meting. Dan kijk je hoe ver dit onder nul ligt.

Teststatistiek bereken je in Python met `stats.ttest_rel(meting1, meting2, alternative='less')`

# Cohen's d

Geeft het grootteverschil aan tussen twee groepen. -> De hypothesetest returnt eigenlijk enkel een false of true.

<abbr title="~x1 en ~x2 zijn de sample means, s wordt berekend met de formule hieronder">Cohen's d:</abbr> $d = \frac{\overline{x}_1 - \overline{x}_2}{s}$

$$s = \sqrt{\frac{(n_1-1)s_1^2 + (n_2-1)s_2^2}{n_1+n_2-2}}$$

Wordt vaak gebruikt wanneer je het verschil tussen een controlegroep en testgroep wil meten.

| d-waarde | Betekenis         |
| -------- | ----------------- |
| 0.01     | zeer klein effect |
| 0.2      | klein effect      |
| 0.5      | medium effect     |
| 0.8      | groot effect      |
| 1.2      | zeer groot effect |
| 2.0      | gigantisch effect |

In python bestaat er geen functie, je kan die wel zelf maken:

```python
def cohen_d(a, b):
    na = len(a)
    nb = len(b)
    pooled_sd = np.sqrt( ((na-1) * np.var(a, ddof=1) +
                          (nb-1) * np.var(b, ddof=1)) / (na + nb - 2) )
    return (np.mean(b) - np.mean(a)) / pooled_sd
```
