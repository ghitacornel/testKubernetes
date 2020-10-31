package register.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import register.model.Person;
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

    @GetMapping(path = "/{id}")
    public Person findById(@PathVariable("id") String id) {
        log.info("find by id " + id);
        return personService.findById(id);
    }

    @PutMapping
    public Person register(@RequestBody Person person) {
        log.info("register " + person);
        return personService.register(person);
    }

    @DeleteMapping(path = "/{id}")
    public void unregister(@PathVariable("id") String id) {
        log.info("unregister person with id " + id);
        personService.unregister(id);
    }

}
