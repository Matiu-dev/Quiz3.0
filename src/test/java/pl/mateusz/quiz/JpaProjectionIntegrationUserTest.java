package pl.mateusz.quiz;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mateusz.quiz.projection.model.User;
import pl.mateusz.quiz.projection.repository.UserRepository;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@DataJpaTest
@RunWith(SpringRunner.class)
@Sql(scripts = "/projection-insert-data-user.sql")
@Sql(scripts = "/projection-clean-up-data-user.sql", executionPhase = AFTER_TEST_METHOD)
public class JpaProjectionIntegrationUserTest {

    @Autowired
    private UserRepository userRepository;

    private Gson gson = new Gson();

    private static final String DELETEUSERID = "1";

    @Test
    void getUserTest() {

        User userDto = userRepository.findByLogin("Jan");
        assertThat(userDto.getPassword()).isEqualTo("pass");
    }

    @Test
    void getUsersTest() {

        List<User> userDto = userRepository.findAll();
        assertThat(userDto.get(1).getLogin()).isEqualTo("Mat");
    }

    @Test
    void createUserTest() {

        String path = System.getProperty("user.dir")+ "/src/test/resources/create_user_example.json";
		String eventString = loadJsonFile(path);
		User userDto = gson.fromJson(eventString, User.class);

		userRepository.save(userDto);

		List<User> listUserDto = userRepository.findAll();
        assertThat(listUserDto.get(2).getLogin()).isEqualTo("add_user");
    }

    @Test
    void deleteUserTest() {
        userRepository.deleteById(DELETEUSERID);
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
