package pl.mateusz.quiz.projection.repository;


import org.springframework.data.repository.Repository;
import pl.mateusz.quiz.projection.model.User;

import java.util.List;

public interface UserRepository extends Repository<User, String> {

     User findByLogin(String login);

     List<User> findAll();

     //add
     User save(User user);

     //delete
     void deleteById(String id);

     //update
     User findById(String id);
}
