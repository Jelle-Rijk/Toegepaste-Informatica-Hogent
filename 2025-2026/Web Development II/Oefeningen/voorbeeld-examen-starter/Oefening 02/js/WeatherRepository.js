import WeatherData from "./WeatherData.js";

export default class WeatherRepository {
  #weatherData = [];

  addWeatherData(jsonData) {
    //TODO
    for (const element of jsonData) {
      const weatherData = new WeatherData(
        element.city,
        element.current,
        element.daily,
      );
      this.#weatherData.push(weatherData);
    }
  }

  #getWeatherDataByCity(cityName) {
    return this.#weatherData.filter((d) => d.city === cityName)[0];
  }

  getCurrentWeather(cityName) {
    return this.#getWeatherDataByCity(cityName).current;
  }

  getDailyForecast(cityName) {
    return this.#getWeatherDataByCity(cityName).daily;
  }

  getStatistics(cityName) {
    const dailyForecast = this.getDailyForecast(cityName);
    //TODO
    console.log(dailyForecast);
    const minTemp = Math.min(...dailyForecast.map((el) => el.minTemp));
    console.log(minTemp);
    const maxTemp = Math.max(...dailyForecast.map((el) => el.maxTemp));
    const averageHumidity =
      dailyForecast.reduce((prev, curr) => prev + curr.humidity, 0) /
      dailyForecast.length;
    return { minTemp, maxTemp, averageHumidity };
  }
}
