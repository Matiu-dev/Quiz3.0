package pl.mateusz.quiz.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mateusz.quiz.domain.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
