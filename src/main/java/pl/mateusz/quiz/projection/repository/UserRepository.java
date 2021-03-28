package pl.mateusz.quiz.projection.repository;


import org.springframework.data.repository.Repository;
import pl.mateusz.quiz.projection.model.User;
import pl.mateusz.quiz.projection.model.UserDto;
import pl.mateusz.quiz.projection.view.UserView;

import java.util.List;

public interface UserRepository extends Repository<User, String> {
     List<UserView> getUserById(String id);

     UserDto findByLogin(String login);
}
