package register.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import register.model.Person;

public interface PersonRepository extends JpaRepository<Person, String> {
}
