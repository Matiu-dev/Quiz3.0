package pl.mateusz.quiz.projection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mateusz.quiz.projection.model.User;
import pl.mateusz.quiz.projection.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    public void updateUser(User userGson) {
        User user = userRepository.findById(userGson.getId());
        user.setLogin(userGson.getLogin());
        user.setPassword(userGson.getPassword());
        saveUser(user);
    }

}
