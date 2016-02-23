package ru.makar.springlab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.makar.springlab.domain.Forecast;

@Repository
public class WeatherDAOImpl implements WeatherDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Forecast> getAllForecasts() {
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT id_forecast, temp, pressure, city_name, date FROM forecasts";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet results = statement.executeQuery();
            List<Forecast> forecasts = new ArrayList<>();
            while (results.next()) {
                Forecast forecast = new Forecast();
                forecast.setId(results.getInt(1));
                forecast.setTemp(results.getInt(2));
                forecast.setPressure(results.getInt(3));
                forecast.setCityName(results.getString(4));
                forecast.setDate(results.getDate(5));
                forecasts.add(forecast);
            }
            return forecasts;
        } catch (Exception e) {
            throw new RuntimeException("Error: getAllForecasts", e);
        }
    }

    @Override
    public Forecast getForecastById(int id) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT temp, pressure, city_name, date FROM forecasts WHERE id_forecast=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet results = statement.executeQuery();
            if (results.next()) {
                Forecast forecast = new Forecast();
                forecast.setId(id);
                forecast.setTemp(results.getInt(1));
                forecast.setPressure(results.getInt(2));
                forecast.setCityName(results.getString(3));
                forecast.setDate(results.getDate(4));
                return forecast;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("Произошла ошибка во время вызова метода getForecastById", e);
        }
    }

    @Override
    public int addForecast(Forecast forecast) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "INSERT INTO forecasts(temp, pressure, city_name, date) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, forecast.getTemp());
            statement.setInt(2, forecast.getPressure());
            statement.setString(3, forecast.getCityName());
            statement.setDate(4, forecast.getDate());
            statement.execute();
            ResultSet key = statement.getGeneratedKeys();
            if (key.next()) {
                return key.getInt(1);
            } else {
                throw new RuntimeException("Не удалось добавить прогноз в базу данных");
            }
        } catch (Exception e) {
            throw new RuntimeException("Произошла ошибка во время вызова метода addForecast", e);
        }
    }

    @Override
    public boolean editForecast(Forecast forecast) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "UPDATE forecasts SET temp=?, pressure=?, city_name=?, date=? WHERE id_forecast=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, forecast.getTemp());
            statement.setInt(2, forecast.getPressure());
            statement.setString(3, forecast.getCityName());
            statement.setDate(4, forecast.getDate());
            statement.setInt(5, forecast.getId());
            statement.execute();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Произошла ошибка во время вызова метода editForecast", e);
        }
    }

    @Override
    public boolean removeForecast(Forecast forecast) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "DELETE FROM forecasts WHERE id_forecast=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, forecast.getId());
            statement.execute();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Произошла ошибка во время вызова метода removeForecast", e);
        }
    }
}
