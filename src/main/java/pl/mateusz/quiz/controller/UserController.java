package pl.mateusz.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.mateusz.quiz.projection.model.UserDto;
import pl.mateusz.quiz.projection.repository.UserRepository;
import pl.mateusz.quiz.projection.service.UserService2;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@EnableWebMvc
public class UserController {

//    @Autowired
//    UserService userService;

    @Autowired
    private UserRepository userRepository2;

    @Autowired
    private UserService2 userService2;

    @RequestMapping(value = "/getUser", method = GET, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto addUser() {//HttpEntity<String> httpEntity

//        String json = httpEntity.getBody();
//
//        Gson gson = new Gson();
//        User userGson = gson.fromJson(json, User.class);
//        userService.addUser(userGson);

//        UserView userView = userService2.getUser("1");
//        return userView;
        UserDto userDto = userService2.getUserByLogin("Jan");

        return userDto;
    }
}
