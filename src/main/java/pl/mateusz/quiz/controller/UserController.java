package pl.mateusz.quiz.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.mateusz.quiz.projection.model.User;
import pl.mateusz.quiz.projection.repository.UserRepository;
import pl.mateusz.quiz.projection.service.UserService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@EnableWebMvc
public class UserController {

//    @Autowired
//    UserService userService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUsers",
            method = GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<User> findUsers() {
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/getUser/{login}",
            method = GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public User getUser(@PathVariable("login") String login) {
        return userService.getUserByLogin(login);
    }

    @RequestMapping(value = "/addUser",
            method = POST,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public HttpStatus addUser(HttpEntity<String> httpEntity) {

//        User user = new User();
//        user.setId("2");
//        user.setLogin("Mat");
//        user.setPassword("pass");
//        userService.saveUser(user);

        String json = httpEntity.getBody();
        Gson gson = new Gson();
        User userGson = gson.fromJson(json, User.class);
        userService.saveUser(userGson);

        return HttpStatus.OK;
    }

    @RequestMapping(value = "/deleteUser/{id}",
            method = DELETE,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public HttpStatus deleteById(@PathVariable("id") String id) {

        userService.deleteById(id);

        return HttpStatus.OK;
    }

    @RequestMapping(value = "/updateUser",
            method = PUT,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public HttpStatus updateUser(HttpEntity<String> httpEntity) {

        String json = httpEntity.getBody();
        Gson gson = new Gson();
        User userGson = gson.fromJson(json, User.class);
        userService.updateUser(userGson);


        return HttpStatus.OK;
    }
}
