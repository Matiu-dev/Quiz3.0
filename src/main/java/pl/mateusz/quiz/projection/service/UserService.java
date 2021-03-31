package pl.mateusz.quiz.projection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.mateusz.quiz.projection.model.User;
import pl.mateusz.quiz.projection.repository.UserRepository;
import pl.mateusz.quiz.projection.view.UserView;

import java.util.List;
import java.util.Optional;

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
