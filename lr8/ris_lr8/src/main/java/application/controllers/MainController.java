package application.controllers;

import application.model.User;
import application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MainController {

//Фреймворк Spring находит нужный bean и подставит его значение в свойство, которое отмечено.
    @Autowired
    private UserService userService;

//Создаём список пользователей и получаем данные
    @GetMapping("/users")
    public String main( Model model) {
        ArrayList users = (ArrayList) userService.findAll();
        model.addAttribute("users",users);
        return "users-list";
    }

//Используем форму регистрации и запоминаем данные
    @GetMapping("/user-create")
    public String createUserForm(User user)
    {
        return "user-create";
    }

//Отправляем данные и возвращаемся обратно
    @PostMapping("/user-create")
    public String createUser(User user)
    {
        userService.saveUser(user);
        return "redirect:/users";
    }

//Удаляем определённого пользователя из списка и возвращаемся обратно
    @GetMapping("/user-delete/{id}")
    public String deletUser(@PathVariable("id") Long id)
    {
        userService.deleteById(id);
        return "redirect:/users";
    }

//Изменяем данные пользователя на другие которое он ввёл
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

//Отправляем и сохраняем введенные данные
    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

}
