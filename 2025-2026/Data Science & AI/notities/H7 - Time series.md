<h1>Tijdsreeksen</h1>

# Termen

Trend: Stijging / daling over lange termijn.

Cyclical: Terugkomende stijging / daling over een aantal jaren heen

Seasonal: Terugkomende stijging / daling binnen een jaar (vb. verkoopcijfers in de kerstperiode)

Random noise: Willekeurig fluctuaties

# Mean absolute error en mean squared error

Worden gebruikt om te beoordelen hoe goed een model werkt.

Mean absolute error: Je neemt de absolute waarde van het verschil tussen de voorspelde waarden en de gemeten waarden. Dat deel je door het aantal waarden.

Mean squared error: Je neemt de som van de kwadraten van de gemeten en voorspelde waarden. Dat deel je door het aantal waarden.

MSE merkt outliers sneller op dan MAE. MAE is makkelijker te interpreteren.

In deze cursus wordt de MAE gebruikt.

## Train en test-data

De dataset wordt meestal onderverdeeld in twee delen:

- Het train-gedeelte wordt gebruikt om het model te trainen.
- Het test-gedeelte wordt niet in de trainingsdata gestoken. Je laat het model deze waarden voorspellen en kan dan de <abbr title='Mean absolute error'>MAE</abbr> of <abbr title='Mean squared error'>MSE</abbr> berekenen

Bij tijdsreeksen is de testset meestal de laatste 20% van de gemeten waarden.

# Toekomstige waarden voorspellen

## Constant model

$$X_1 = b + e_t$$

-> Het model bekijkt de data als een constante ($b$) met willekeurige fluctuaties ($e_t$). Meestal wordt $b$ gedefinieerd als het gemiddelde van eerdere observaties.

**Voordeel**: Je kan een grove inschatting maken van een 'normale' waarde.

**Nadeel**: Te eenvoudig, houdt geen rekening met trends, seasons, cycli of fluctuaties.

## Linear trend model

$$X_1 = b_0 + b_1 * t + e_t$$

-> Dit is lineaire regressie + random fluctuaties ($b_0$ = intercept, $b_1$ = slope, $t$ = de x-waarde tijd)

**Voordeel**: Toont trends op de lange termijn. Makkelijk te interpreteren.

**Nadeel**: Seasonality en cyclical component wordt genegeerd. Het model is gevoelig aan outliers.

Let op!

```python
y = test_data.values
x = np.arange(len(y)) # polyfit en scikit learn LinearRegression werken niet met datums, dus moet je indices creëren

# Waarde uitrekenen zoals bij lineaire regressie (hieronder polyfit, maar kan ook met sklearn)
b1, b0 = np.polyfit(x=x, y=y, deg=1)
```

## Simple moving average

Je neemt telkens het gemiddelde van de laatste paar waarden.

Hoe kleiner het aantal waarden, hoe gevoeliger de SMA is voor fluctuaties.

$$SMA(t) = \frac{1}{m} \sum_{i=k}^{t} x_i$$

- m = aantal waarden die in rekening gebracht worden
- k = tijd - m + 1

In python vind je dit met: `data[kolom].rolling(aantal_waarden).mean().shift(1)`

**Voordeel**: Werkt goed als de data geen duidelijke trend heeft. Makkelijk te interpreteren

**Nadeel:** Negeert trends en seasonality en komt altijd een beetje achter. Oudere data is evenwaardig aan nieuwere data. Neemt meer computergeheugen in.

## Simple exponential smoothing

Werkt met levels, ze stellen voorspelde waarden zonder random fluctuations voor. Een level wordt berekend met de formule:
$$L_t = \alpha Y_t + (1 - \alpha)L_t-1$$

- &alpha; = Een waarde die je zelf kiest tussen 0 en 1 (1 = meer gewicht geven aan recente data, 0 = alles hetzelfde gewicht)
- $Y_t$ = Y is de observatie, T is het huidige tijdstip, dus $Y_t$ is de laatste observatie
- $L_{t-1}$ is het level van de vorige observatie. Deze formule is dus recusief. SES houdt rekening met alle observaties.

De voorspelling is dan: <abbr title='F = forecast, k = aantal stappen in de toekomst'>$F_{t+k} = L_t$</abbr> <br> Volgens deze formule is elke waarde in de toekomst dus gelijk aan de laatste berekende level-waarde.

**Voordeel**: Recentere data krijgt meer gewicht dan oude data. Reageert sneller op veranderingen.

**Nadeel**: Houdt geen rekening met de trend of seasonality. Keuze van &alpha; heeft een grote invloed op de resultaten (+ als &alpha; te klein is, reageert de voorspelling minder snel).

## Double exponential smoothing - Holt's method

Deze smoothing houdt rekening met de trend.

Level:  
$L_{t} = \alpha Y_{t} + (1-\alpha)(L_{t-1} +$ <abbr title='T=Trend, T_t-1 = Trend bij vorige observatie'>$T_{t-1})$</abbr>

Trend:  
$T_{t} = \beta(L_{t}-L_{t-1}) + (1-\beta)T_{t-1}$

Forecast:  
$F_{t+k} = L_t + kT_t$

&beta; is een variabele tussen 0 en 1 die vergelijkbaar is met &alpha;, maar het zorgt voor smoothing in de trend.

**Voordeel**: Houdt rekening met trends in de data. Relatief weinig data storage nodig. Voorspellingen zijn accurater dan SES als er een trend aanwezig is.

**Nadeel**: Houdt geen rekening met seasonality. Zowel de keuze voor &alpha; als voor &beta; kunnen een groot effect hebben op het resultaat. Reageert slecht als de trend snel verandert.

In python:

```python
from statsmodels.tsa.api import Holt

data_des = Holt(training_data['data_col']).fit(smoothing_level=alpha, smoothing_trend=beta, optimized=False)

df['DES'] = data_des.level
```

## Triple exponential smoothing - Holt-Winters method

Level:  
$L_{t} = \alpha (Y_{t} - S_{t-m}) + (1-\alpha) (L_{t-1} + T_{t-1})$

Trend:  
$T_{t} = \beta (L_{t} - L_{t-1}) + (1-\beta)T_{t-1}$

Seasonal component:  
$S_{t} = \gamma (Y_{t} - L_{t}) + (1-\gamma)S_{t-m}$

Forecast for $k$ time units after the last observation:  
$F_{t+k} = L_{t} + kT_{t} + S_{t-m+k}$

Variabelen zijn:

- &alpha; = gewicht meest recente observaties (vaak 0.1)
- &beta; = smoothing van de trend (vaak 0.2)
- &gamma; = smoothing van de seasonal component (vaak )
- t = huidig moment in de tijd
- Y = observatie
- m = de lengte van de seasonal cycle (vb. 12 voor een jaar, 4 voor een kwartaal, 7 voor een week, etc.)
