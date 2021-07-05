package pl.mateusz.quiz.projection.repository;

import org.springframework.data.repository.Repository;
import pl.mateusz.quiz.projection.model.Question;

public interface QuestionRepository extends Repository<Question, String> {

    //add
    Question save(Question question);
}
