package pl.mateusz.quiz;

import com.google.gson.Gson;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.mateusz.quiz.controller.UserController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


@SpringBootTest
class QuizApplicationTests {

	@Autowired
	UserController userController;

	Gson gson = new Gson();

	@Test
	void addUserTest() throws FileNotFoundException, ParseException {

//		String path = System.getProperty("user.dir")+ "/src/test/java/pl/mateusz/quiz/user_example.json";
//		String eventString = loadJsonFile(path);
//		User user = gson.fromJson(eventString, User.class);
//		System.out.println(eventString);
//
//
//		userController.addUser(new HttpEntity<>(eventString));
	}

	private static String loadJsonFile(final String path) {
		StringBuilder stringBuilder = new StringBuilder();
		try (Stream<String> stream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
			stream.forEach(s -> stringBuilder.append(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

}
