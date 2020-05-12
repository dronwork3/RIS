package application.services;

import application.model.User;
import application.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

  //Создаём зону для пользователей
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//Поиск пользователей по id
    public User findById(Long id){
        return userRepository.getOne(id);
    }

//Список пользователей
    public List<User> findAll(){
        return userRepository.findAll();
    }

//Сохранение пользователя
    public User saveUser(User user){
        return userRepository.save(user);
    }

//Удаление пользователя
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

}
