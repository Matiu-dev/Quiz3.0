package pl.mateusz.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.mateusz.quiz.user.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {UserRepository.class})
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

}
