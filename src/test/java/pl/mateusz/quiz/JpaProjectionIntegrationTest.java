package pl.mateusz.quiz;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mateusz.quiz.projection.model.UserDto;
import pl.mateusz.quiz.projection.repository.UserRepository;
import pl.mateusz.quiz.projection.view.UserView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@DataJpaTest
@RunWith(SpringRunner.class)
@Sql(scripts = "/projection-insert-data-user.sql")
@Sql(scripts = "/projection-clean-up-data-user.sql", executionPhase = AFTER_TEST_METHOD)
public class JpaProjectionIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        UserView userView = userRepository.getUserById("1").get(0);
        assertThat(userView.getId()).isEqualTo("1");

        UserDto userDto = userRepository.findByLogin("Jan");
        assertThat(userDto.getPassword()).isEqualTo("pass");
    }
}
