package actor.service;

import actor.client.PersonClientService;
import actor.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final Map<String, Person> map = new HashMap<>();
    final PersonClientService client;

    public void initialise() {

        // load
        client.loadAll().forEach(person -> map.put(person.getId(), person));

        // if empty ensure at least some data is present
        if (map.isEmpty()) {
            for (int i = 0; i < 10; i++) register();
        }

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
        Person person = client.register();
        map.put(person.getId(), person);
        System.out.println("registered " + person);
    }

    private void unregister() {
        Person person = getRandomPerson();
        if (person == null) return;
        client.unregister(person.getId());
        map.remove(person.getId());
        System.out.println("unregistered " + person);
    }

    private void check() {
        Person person = getRandomPerson();
        if (person == null) return;
        System.out.println("check " + person);
    }
}
