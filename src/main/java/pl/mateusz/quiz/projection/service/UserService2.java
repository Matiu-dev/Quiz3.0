package pl.mateusz.quiz.projection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mateusz.quiz.projection.model.UserDto;
import pl.mateusz.quiz.projection.repository.UserRepository;
import pl.mateusz.quiz.projection.view.UserView;

@Service
public class UserService2 {

    @Autowired
    private UserRepository userRepository2;

    public UserView getUser(String id) {
       return userRepository2.getUserById(id).get(0);
    }

    public UserDto getUserByLogin(String login) {
        UserDto userDto = userRepository2.findByLogin("Jan");
        return userDto;
    }
}
