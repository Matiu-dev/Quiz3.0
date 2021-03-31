package pl.mateusz.quiz.projection.repository;


import org.springframework.data.repository.Repository;
import pl.mateusz.quiz.projection.model.User;
import pl.mateusz.quiz.projection.view.UserView;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Repository<User, String> {
     List<UserView> getUserById(String id);

     User findByLogin(String login);

     List<User> findAll();

     //add
     User save(User user);

     //delete
     void deleteById(String id);

     //update
     User findById(String id);
}
