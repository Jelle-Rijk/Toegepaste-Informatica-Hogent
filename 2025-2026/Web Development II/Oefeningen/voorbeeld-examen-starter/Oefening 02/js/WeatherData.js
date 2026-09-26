export default class WeatherData {
  #city;
  #current;
  #daily;

  constructor(city, current, daily) {
    this.#city = city;

    this.#current = {
      datetime: new Date(current.dt * 1000),
      temperature: current.temp,
      humidity: current.humidity,
      //TODO haal description en icon op
      description: current.weather[0].description,
      icon: current.weather[0].icon,
    };

    this.#daily = daily.map((day) => ({
      date: new Date(day.dt * 1000),
      minTemp: day.temp.min,
      maxTemp: day.temp.max,
      humidity: day.humidity,
    }));
  }

  get city() {
    return this.#city;
  }

  get current() {
    return this.#current;
  }

  get daily() {
    return this.#daily;
  }
}
