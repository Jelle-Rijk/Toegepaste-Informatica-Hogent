# Standaardafwijking berekenen

```Python
population_sigma = np.mean(data)
sample_s = np.mean(data, ddof=1)
```

# Overzicht gebruikte testen en plots

| Independent  | Dependent    | Test                            | Plot                                       |
| ------------ | ------------ | ------------------------------- | ------------------------------------------ |
| Qualitative  | Qualitative  | $\chi^2$ en Cramer's $V$        | Grouped/stacked bar chart, mosaic plot     |
| Qualitative  | Quantitative | two-sample t-test / Cohen's $d$ | Grouped boxplot, bar chart with error bars |
| Quantitative | Quantitative | Regression, correlation         | Scatter plot, regression line              |

# Chi-squared

| Soort test      | Nodige functies    |
| --------------- | ------------------ |
| Goodness of fit | `stats.chisquare() |
