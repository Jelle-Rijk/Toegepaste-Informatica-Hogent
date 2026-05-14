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

<abbr title='y met dakje = schatting voor y, &beta;0 = intercept (snijpunt met y-as), &beta;1 = slope (richtingscoëfficient)'>Je krijgt een rechte $\hat{y} = \beta_0 + \beta_1 x.$</abbr>

In Python:

```python
# Numpy polyfit, deg=1 - makkelijkst
slope, intercept =  np.polyfit(var1, var2, deg=1)

# Scipy linregress - niet vaak gebruikt
slope, intercept, r_value, p_value, std_err, intercept_std_err = stats.linregress(var1, var2)

# scikit-learn - vooral bij machine learning
from sklearn.linear_model import LinearRegression
weight_model = LinearRegression.fit(var1, var2)
slope = weight_model.coef_[0]
intercept = weight_mode.intercept

```

# Sterkte van de relatie uitdrukken

## Covariantie

<abbr title='~x = mean, summation gaat alle waarden optellen'>Covariantie voor een sample = $Cov(X, Y) = \frac{1}{n-1} \sum(x - \overline{x})(y - \overline{y})$</abbr>

-> Als je de covariantie van een population neemt, moet je de noemer vervangen door n i.p.v. n-1

Covariantie geeft de richting van de relatie aan:

- Cov > 0: stijgende rechte
- Cov = 0: geen relatie (benadering van 0)
- Cov < 0: dalende rechte

```python
cov = np.cov(var1, var2, ddof=1)[0][1] # resultaat van np.cov() is een matrix, de waarde voor cov(var1, var2) bevindt zich op rij 0, kolom 1
```

Covariantie wordt niet vaak gebruikt, omdat de grootte van het getal niets zegt over de relatie (is afhankelijk van de grootte van de getallen in de variabelen)

## Correlatiecoëfficient (R)

Formule (voor de volledigheid - uitrekenen met python)

$$R = \frac{\mathrm{Cov}(X,Y)}{\sigma_x \sigma_y} = \frac{\sum(x_i - \overline{x})(y_i - \overline{y})}{\sqrt{\sum{(x_i-\overline{x})^2}} \sqrt{\sum{(y_i - \overline{y})^2}}}$$

Voordeel t.o.v. covariantie -> niet beïnvloed door de grootte van de eenheden binnen de variabelen.

Waarden liggen altijd tussen -1 (perfect dalende rechte) en 1 (perfect stijgende rechte), 0 betekent dat er geen verband is.

> Let op!
>
> R zegt niets over hoe sterk de stijgende of dalende correlatie is, enkel dat de waarden dichter / verder van de lijn verspreid liggen.

```python
np.corrcoef(var1, var2)[0][1] # returnt een matrix gelijkaardig aan np.cov()
```

## Coefficient of determination (R<sup>2</sup>)

= Het percentage van de variantie in de afhankelijke variabele die kan verklaard worden door de variantie in de onafhankelijke variabele

In python bereken je eerst [R](#correlatiecoëfficient-r) en dan doe je `R ** 2`

Je kan dit ook berekenen met scikit-learn

```python
model = LinearRegression().fit(var1, var2)
r2 = model.score(var1, var2)
```

Als R<sup>2</sup> 0.45 is, kan je concluderen dat 45% van de variantie in de observaties toegeschreven kan worden aan de lineaire relatie.

## R en R<sup>2</sup> interpreteren

Je moet de absolute waarde van R gebruiken.

| abs(R)   | R<sup>2</sup> | Explained variance | Sterkte lineaire relatie |
| -------- | ------------- | ------------------ | ------------------------ |
| <.3      | < .1          | < 10%              | very weak                |
| .3 - .5  | .1 - .25      | 10%-25%            | weak                     |
| .5 - .7  | .25 - .5      | 25%-50%            | moderate                 |
| .7 - .85 | .5 - .75      | 50%-75%            | strong                   |
| .85 - 95 | .75 - .9      | 75%-90%            | very strong              |
| > .95    | > .9          | > 90%              | exceptionally strong     |

Hoge R-waarde zegt niet dat iets een 'sterk stijgende lineaire relatie' heeft, wel dat er een 'sterke EN stijgende lineaire relatie' is.

# Belangrijke opmerkingen

- De correlatiecoëfficient bewijst niet dat er een causaal verband is, enkel dat er een correlatie is.
- R test enkel de lineaire relatie, er bestaan nog andere soorten relaties
- R<sup>2</sup> toont duidelijker de sterkte van de relatie aan dan R
