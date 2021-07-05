package pl.mateusz.quiz.projection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mateusz.quiz.projection.model.Question;
import pl.mateusz.quiz.projection.model.User;
import pl.mateusz.quiz.projection.repository.QuestionRepository;
import pl.mateusz.quiz.projection.repository.UserRepository;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }
}
