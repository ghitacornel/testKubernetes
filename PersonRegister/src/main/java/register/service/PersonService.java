package register.service;

import dao.model.Person;
import dao.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import register.generator.PersonGenerator;


import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    final PersonRepository personRepository;
    final PersonGenerator generator;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person register() {
        Person person = generator.generate();
        while (personRepository.findById(person.getId()).isPresent()) {
            person = generator.generate();
        }
        personRepository.save(person);
        return person;
    }

    public void unregister(String id) {
        personRepository.deleteById(id);
    }
}
