package pl.mateusz.quiz.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.mateusz.quiz.domain.dto.User;
import pl.mateusz.quiz.user.UserService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@EnableWebMvc
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/addUser", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public User addUser(HttpEntity<String> httpEntity) {

        String json = httpEntity.getBody();

        Gson gson = new Gson();
        User userGson = gson.fromJson(json, User.class);
        userService.addUser(userGson);


        return userGson;
    }
}
