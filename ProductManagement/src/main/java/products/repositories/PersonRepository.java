package products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import products.model.Person;

public interface PersonRepository extends JpaRepository<Person, String> {
}
