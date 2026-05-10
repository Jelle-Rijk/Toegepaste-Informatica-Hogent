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

# Data cleaning

## Ordinale waarden

```python
datatype = CategoricalDtype(categories=["cat1", "cat2", "cat3"], ordered = True)
dataframe['kolom'] = dataframe['kolom'].astype(datatype)
```

# Gemaakte oefeningen

- <a href="../labs-en-code/4-bivariate-qual/lab-4.03-discrimination.ipynb\">Kijken of één kwalitatieve waarde aan de goodness of fit test voldoet (samenstelling blank-afro binnen een school) + standardized residual berekenen</a>
- <a href="../labs-en-code/4-bivariate-qual/lab-4.05-survey.ipynb">Kijken of twee kwalitatieve waarden independent zijn (Australian survey)</a>
- <a href="../labs-en-code/4-bivariate-qual/lab-4.06-music-wine.ipynb">Crosstab opstellen + plotten van dependent variables</a>
- <a href="../labs-en-code/4-bivariate-qual/lab-4.07-digimeter-sample.ipynb">Goodness of fit test + mergen van categorieën binnen dataframe. (Digimeter)</a>
- <a href="../labs-en-code/4-bivariate-qual/lab-4.08-off-days.ipynb">Lijst van namen omvormen naar namen + counts (en berekenen standardized residuals) (Employee Saturdays off)</a>
