package register.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import register.model.Person;
import register.repositories.PersonRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    final PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void register(Person person) {
        personRepository.save(person);
    }

    public void unregister(String id) {
        personRepository.deleteById(id);
    }
}
