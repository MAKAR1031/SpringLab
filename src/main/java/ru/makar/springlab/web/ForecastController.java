package ru.makar.springlab.web;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.makar.springlab.dao.WeatherDAO;
import ru.makar.springlab.domain.Forecast;

@Controller
@RequestMapping("/forecast")
public class ForecastController {

    @Autowired
    private WeatherDAO dao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllForecasts(Model model) {
        model.addAttribute("forecasts", dao.getAllForecasts());
        return "/forecast/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showForecast(@PathVariable("id") int id, Model model) {
        Forecast forecast = dao.getForecastById(id);
        if (forecast == null) {
            throw new NotFoundException();
        }
        model.addAttribute("forecast", forecast);
        return "/forecast/show";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForecast(Model model) {
        model.addAttribute("title", "Добавление нового прогноза");
        model.addAttribute("sendURL", "/forecast/add");
        return "/forecast/form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addForecast(@ModelAttribute Forecast forecast, Model model) {
        dao.addForecast(forecast);
        return "redirect:/forecast/list";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editForecast(@PathVariable("id") int id, Model model) {
        Forecast forecast = dao.getForecastById(id);
        if (forecast == null) {
            throw new NotFoundException();
        }
        model.addAttribute("title", "Редактирование прогноза");
        model.addAttribute("sendURL", "/forecast/editConfirm");
        model.addAttribute("forecast", forecast);
        return "/forecast/form";
    }

    @RequestMapping(value = "/editConfirm", method = RequestMethod.POST)
    public String editForecast(@ModelAttribute Forecast forecast, Model model) {
        if (dao.editForecast(forecast)) {
            return "redirect:/forecast/list";
        } else {
            return "redirect:/fail";
        }
    }

    @RequestMapping(value = "/{id}/remove", method = RequestMethod.GET)
    public String removeForecast(@PathVariable("id") int id, Model model) {
        Forecast forecast =dao.getForecastById(id);
        if (forecast == null) {
            throw new NotFoundException();
        }
        model.addAttribute("forecast", forecast);
        return "/forecast/remove";
    }

    @RequestMapping(value = "/removeConfirm", method = RequestMethod.POST)
    public String removeForecastConfirm(@RequestParam(name = "id", required = true) int id, Model model) {
        if (dao.removeForecast(dao.getForecastById(id))) {
            return "redirect:/forecast/list";
        } else {
            return "redirect:/fail";
        }
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND,
            reason = "Entity with specified id not found")
    public void handleNotFoundException(NotFoundException ex,
            HttpServletResponse response) throws IOException {
    }
}
