package register.controllers;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import register.interceptors.Logged;
import register.model.Person;
import register.services.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PersonController {

    final PersonService personService;

    @Timed
    @Counted
    @Logged
    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }

    @Timed
    @Counted
    @Logged
    @GetMapping(path = "/{id}")
    public Person findById(@PathVariable("id") String id) {
        return personService.findById(id);
    }

    @Timed
    @Counted
    @Logged
    @PutMapping
    public Person register(@RequestBody Person person) {
        return personService.register(person);
    }

    @Timed
    @Counted
    @Logged
    @DeleteMapping(path = "/{id}")
    public void unregister(@PathVariable("id") String id) {
        personService.unregister(id);
    }

}
