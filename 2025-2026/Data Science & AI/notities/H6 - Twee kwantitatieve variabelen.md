<h1>Analyse van twee kwantitatieve variabelen</h1>

# Visualisation

Scatterplot:

```python
sns.relplot(data=df, x='variabele1', y='variabele2')

# Je kan ook de kwalitatieve variabelen illustreren via kleuren, stijlen, etc.
sns.relplot(data=df, x='kwantitatief1', y='kwantitatief2', hue='kwalitatief1', style='kwalitatief2', size='kwantitatief3')
```

Scatterplots met regressie

```python
# Met regplot
sns.regplot()

# Met regressie en limieten
sns.lmplot(data=dataframe, x="var1", y="var2")
```

# Lineaire regressie

<abbr title="a=trend / slope, b = intercept / level">Rechte gedefinieerd als</abbr> $y = ax+b$

Verticale afstand tussen lijn en x-as = fitted value <br>
Verticale afstand tussen lijn en punt = residual (positive boven de lijn, negative onder de lijn)

Bij de berekening van de lijn gebruik je de **sum of squared residuals**:

- Neem de vierkantswortel van de residuals
- Neem de som van al die vierkantwortels

In Python:

```python
# Numpy polyfit, deg=1
np.polyfit(var1, var2, deg=1)

# Scipy linregress
slope, intercept, r_value, p_value, std_err, intercept_std_err = stats.linregress(var1, var2)

# scikit-learn

```
