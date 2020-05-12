package application.controllers;

import application.models.fibbonachiCount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class StringController {

//Обработка метода запроса типа Get
    @GetMapping("/")
  //Получаем данные объекта
    public String greeting(Model model) {
    //Добавляем атрибут
        model.addAttribute("name");
        return "greeting";
    }

//Обработка метода запроса типа Post
    @PostMapping("/")
  //извлечение параметров запроса
    public String countFibbonachi(@RequestParam Integer startDigit, Model model)
    {
        fibbonachiCount fibbonachiCount = new fibbonachiCount(startDigit);
        ArrayList arrayList = fibbonachiCount.count(startDigit);
        model.addAttribute("fibbonachiArea",arrayList);
        return "greeting";
    }

}
