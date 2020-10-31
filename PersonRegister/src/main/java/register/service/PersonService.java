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

    public Person register(Person person) {
        personRepository.save(person);
        return person;
    }

    public Person unregister(String id) {
        Person person = personRepository.getOne(id);
        personRepository.delete(person);
        return person;
    }

    public Person findById(String id) {
        return personRepository.getOne(id);
    }
}
