package register.controller;

import dao.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import register.service.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PersonController {

    final PersonService personService;

    @GetMapping
    public List<Person> findAll() {
        log.info("find all persons");
        return personService.findAll();
    }

    @PostMapping
    public Person register() {
        Person person = personService.register();
        log.info("register " + person);
        return person;
    }

    @DeleteMapping(path = "/{id}")
    public void unregister(@PathVariable("id") String id) {
        personService.unregister(id);
        log.info("unregister person with id " + id);
    }

}
