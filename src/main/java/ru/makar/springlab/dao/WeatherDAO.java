package ru.makar.springlab.dao;

import java.util.List;
import ru.makar.springlab.domain.Forecast;

public interface WeatherDAO {
    List<Forecast> getAllForecasts();
    Forecast getForecastById(int id);
    int addForecast(Forecast forecast);
    boolean editForecast(Forecast forecast);
    boolean removeForecast(Forecast forecast);
}
