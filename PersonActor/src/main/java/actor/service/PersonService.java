package actor.service;

import actor.client.PersonClientService;
import actor.generator.PersonGenerator;
import actor.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PersonService {

    final private static int THRESHOLD_MIN = 10;
    final private static int THRESHOLD_MAX = 200;

    private final Map<String, Person> map = Collections.synchronizedMap(new HashMap<>());
    final PersonClientService client;
    final PersonGenerator personGenerator;

    public void initialise() {

        // load
        client.loadAll().forEach(person -> map.put(person.getId(), person));

        // ensure THRESHOLD_MIN
        for (int i = map.size(); i < THRESHOLD_MIN; i++) register();

    }

    public void play() {
        Random random = new Random();
        int operation = random.nextInt(3);
        switch (operation) {
            case 0 -> register();
            case 1 -> unregister();
            default -> check();
        }
    }

    private Person getRandomPerson() {
        if (map.isEmpty()) return null;
        Random random = new Random();
        int index = random.nextInt(map.size());
        return map.values().stream().skip(index).findFirst().get();
    }

    private void register() {

        if (map.size() >= THRESHOLD_MAX) return;

        Person person;
        do {
            person = personGenerator.generate();
        } while (map.containsKey(person.getId()));
        client.register(person);
        map.put(person.getId(), person);
        System.out.println("registered " + person);
    }

    private void unregister() {

        if (map.size() <= THRESHOLD_MIN) return;

        Person person = getRandomPerson();
        if (person == null) return;
        client.unregister(person.getId());
        map.remove(person.getId());
        System.out.println("unregistered " + person);
    }

    private void check() {
        Person person = getRandomPerson();
        if (person == null) return;
        client.check(person.getId());
        System.out.println("check " + person);
    }
}
