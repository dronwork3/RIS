package application.repos;

import application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

// используем Интерфейс JpaRepository
public interface UserRepository extends JpaRepository<User,Long> {

}
