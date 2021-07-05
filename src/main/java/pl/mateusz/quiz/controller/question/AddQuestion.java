package pl.mateusz.quiz.controller.question;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.mateusz.quiz.projection.model.Answer;
import pl.mateusz.quiz.projection.model.Question;
import pl.mateusz.quiz.projection.model.User;
import pl.mateusz.quiz.projection.service.QuestionService;
import pl.mateusz.quiz.projection.service.UserService;

import java.util.ArrayList;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@EnableWebMvc
public class AddQuestion {
    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/addQuestion",
            method = POST,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public HttpStatus addQuestion(HttpEntity<String> httpEntity) {

        String json = httpEntity.getBody();
        Gson gson = new Gson();
        Question userGson = gson.fromJson(json, Question.class);
        questionService.saveQuestion(userGson);

//        Question question = new Question();
//        question.setQuestion("Pytanie testowe");
//        Answer a = (Answer) new Answer();
//        question.getAnswers().add(new Answer().setAnswer("Odpowiedz A"));
//        question.getAnswers().add(new Answer().setAnswer("Odpowiedz B"));
//        question.getAnswers().add(new Answer());
//        question.getAnswers().add(new Answer());
//        questionService.saveQuestion(question);


        return HttpStatus.OK;
    }
}
