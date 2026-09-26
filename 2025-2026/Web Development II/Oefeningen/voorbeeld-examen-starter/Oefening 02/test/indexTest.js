import WeatherData from '../js/WeatherData.js';
import WeatherRepository from '../js/WeatherRepository.js';
import { hulplijnWeather } from '../js/WeatherComponent.js';

// Bekijk de uitvoer in je console en vergelijk met wat je hier vindt bij de stukjes 'Expected output'
console.log('=============== TEST KLASSE WeatherData ================');
const gent = new WeatherData(
     "Gent",
     {
        "dt": 1750244795,
        "sunrise": 1750217392,
        "sunset": 1750276962,
        "temp": 25.41,
        "feels_like": 25.42,
        "pressure": 1024,
        "humidity": 54,
        "dew_point": 15.43,
        "uvi": 7.78,
        "clouds": 84,
        "visibility": 10000,
        "wind_speed": 2.89,
        "wind_deg": 289,
        "wind_gust": 2.8,
        "weather": [
            {
                "id": 803,
                "main": "Clouds",
                "description": "broken clouds",
                "icon": "04d"
            }
        ]
    },[
        {
            "dt": 1750244400,
            "sunrise": 1750217392,
            "sunset": 1750276962,
            "moonrise": 1750203600,
            "moonset": 1750245480,
            "moon_phase": 0.75,
            "summary": "You can expect partly cloudy in the morning, with clearing in the afternoon",
            "temp": {
                "day": 25.41,
                "min": 13.86,
                "max": 25.73,
                "night": 16.7,
                "eve": 23.62,
                "morn": 16.47
            },
            "feels_like": {
                "day": 25.42,
                "night": 16.38,
                "eve": 23.24,
                "morn": 16.42
            },
            "pressure": 1024,
            "humidity": 54,
            "dew_point": 15.43,
            "wind_speed": 5.71,
            "wind_deg": 328,
            "wind_gust": 6.03,
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "clouds": 84,
            "pop": 0,
            "uvi": 8
        },
        {
            "dt": 1750330800,
            "sunrise": 1750303797,
            "sunset": 1750363382,
            "moonrise": 1750290780,
            "moonset": 1750336860,
            "moon_phase": 0.77,
            "summary": "There will be clear sky today",
            "temp": {
                "day": 25.99,
                "min": 14.24,
                "max": 27.76,
                "night": 20.2,
                "eve": 25.78,
                "morn": 15.63
            },
            "feels_like": {
                "day": 25.99,
                "night": 19.79,
                "eve": 25.54,
                "morn": 15.21
            },
            "pressure": 1026,
            "humidity": 39,
            "dew_point": 10.96,
            "wind_speed": 5.42,
            "wind_deg": 25,
            "wind_gust": 9.7,
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01d"
                }
            ],
            "clouds": 1,
            "pop": 0,
            "uvi": 7.66
        },
        {
            "dt": 1750417200,
            "sunrise": 1750390205,
            "sunset": 1750449799,
            "moonrise": 1750377900,
            "moonset": 1750428360,
            "moon_phase": 0.81,
            "summary": "There will be clear sky until morning, then partly cloudy",
            "temp": {
                "day": 25.22,
                "min": 14.83,
                "max": 27.7,
                "night": 20.72,
                "eve": 26.69,
                "morn": 15.95
            },
            "feels_like": {
                "day": 24.74,
                "night": 19.81,
                "eve": 26.12,
                "morn": 15.43
            },
            "pressure": 1025,
            "humidity": 36,
            "dew_point": 9.03,
            "wind_speed": 5.14,
            "wind_deg": 75,
            "wind_gust": 9.63,
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04d"
                }
            ],
            "clouds": 100,
            "pop": 0,
            "uvi": 6.77
        },
        {
            "dt": 1750503600,
            "sunrise": 1750476616,
            "sunset": 1750536212,
            "moonrise": 1750465200,
            "moonset": 1750520160,
            "moon_phase": 0.85,
            "summary": "The day will start with partly cloudy through the late morning hours, transitioning to clearing",
            "temp": {
                "day": 29.71,
                "min": 15.4,
                "max": 32.1,
                "night": 23.81,
                "eve": 30.55,
                "morn": 16.65
            },
            "feels_like": {
                "day": 28.04,
                "night": 23.21,
                "eve": 28.87,
                "morn": 15.78
            },
            "pressure": 1021,
            "humidity": 21,
            "dew_point": 5.48,
            "wind_speed": 3.88,
            "wind_deg": 130,
            "wind_gust": 9.88,
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01d"
                }
            ],
            "clouds": 1,
            "pop": 0,
            "uvi": 7.92
        },
        {
            "dt": 1750590000,
            "sunrise": 1750563030,
            "sunset": 1750622623,
            "moonrise": 1750552740,
            "moonset": 1750612080,
            "moon_phase": 0.88,
            "summary": "Expect a day of partly cloudy with clear spells",
            "temp": {
                "day": 33.19,
                "min": 18.89,
                "max": 34.61,
                "night": 23.76,
                "eve": 33.07,
                "morn": 22.15
            },
            "feels_like": {
                "day": 31,
                "night": 23.5,
                "eve": 31.26,
                "morn": 21.49
            },
            "pressure": 1015,
            "humidity": 18,
            "dew_point": 5.79,
            "wind_speed": 5.33,
            "wind_deg": 205,
            "wind_gust": 7.58,
            "weather": [
                {
                    "id": 801,
                    "main": "Clouds",
                    "description": "few clouds",
                    "icon": "02d"
                }
            ],
            "clouds": 21,
            "pop": 0,
            "uvi": 7.72
        },
        {
            "dt": 1750676400,
            "sunrise": 1750649446,
            "sunset": 1750709031,
            "moonrise": 1750640760,
            "moonset": 1750703880,
            "moon_phase": 0.92,
            "summary": "Expect a day of partly cloudy with rain",
            "temp": {
                "day": 22.92,
                "min": 17.18,
                "max": 23.93,
                "night": 18.42,
                "eve": 23.93,
                "morn": 18.75
            },
            "feels_like": {
                "day": 22.68,
                "night": 17.99,
                "eve": 23.42,
                "morn": 18.22
            },
            "pressure": 1016,
            "humidity": 54,
            "dew_point": 13.14,
            "wind_speed": 6.68,
            "wind_deg": 274,
            "wind_gust": 10.92,
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "clouds": 52,
            "pop": 0.2,
            "rain": 0.12,
            "uvi": 8
        },
        {
            "dt": 1750762800,
            "sunrise": 1750735866,
            "sunset": 1750795435,
            "moonrise": 1750729500,
            "moonset": 1750795020,
            "moon_phase": 0.96,
            "summary": "There will be partly cloudy until morning, then clearing",
            "temp": {
                "day": 26.08,
                "min": 13.3,
                "max": 26.98,
                "night": 18.44,
                "eve": 25.53,
                "morn": 16.81
            },
            "feels_like": {
                "day": 26.08,
                "night": 17.36,
                "eve": 24.77,
                "morn": 15.96
            },
            "pressure": 1016,
            "humidity": 23,
            "dew_point": 3.41,
            "wind_speed": 4.5,
            "wind_deg": 287,
            "wind_gust": 6.94,
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01d"
                }
            ],
            "clouds": 0,
            "pop": 0,
            "uvi": 8
        },
        {
            "dt": 1750849200,
            "sunrise": 1750822288,
            "sunset": 1750881837,
            "moonrise": 1750819260,
            "moonset": 1750884960,
            "moon_phase": 0,
            "summary": "Expect a day of partly cloudy with clear spells",
            "temp": {
                "day": 30.72,
                "min": 14.15,
                "max": 32.83,
                "night": 22.3,
                "eve": 27.65,
                "morn": 17.64
            },
            "feels_like": {
                "day": 28.74,
                "night": 21.4,
                "eve": 26.59,
                "morn": 16.24
            },
            "pressure": 1013,
            "humidity": 9,
            "dew_point": -4.6,
            "wind_speed": 6.45,
            "wind_deg": 356,
            "wind_gust": 7.18,
            "weather": [
                {
                    "id": 801,
                    "main": "Clouds",
                    "description": "few clouds",
                    "icon": "02d"
                }
            ],
            "clouds": 20,
            "pop": 0,
            "uvi": 8
        }
    ]
);
console.log('Weather gent', gent);



console.log('=============== TEST WeatherREPOSITORY ================');
const weatherRepo = new WeatherRepository();
// VOEGWeatherTOE
weatherRepo.addWeatherData(hulplijnWeather);

console.log(weatherRepo);
console.log(
  'Statistieken Gent', weatherRepo.getStatistics('Gent'))
