package actor.client;

import actor.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class PersonClientService {

    private WebClient getClient() {
        return WebClient.create("http://localhost:8080/person/");
    }

    public List<Person> loadAll() {
        return getClient().get().retrieve().bodyToFlux(Person.class).collectList().block();
    }

    public Person check(String id) {
        return getClient().get().uri("/" + id).retrieve().toEntity(Person.class).block().getBody();
    }

    public Person register(Person person) {
        return getClient().put().bodyValue(person).retrieve().toEntity(Person.class).block().getBody();
    }

    public Person unregister(String id) {
        return getClient().delete().uri("/" + id).retrieve().toEntity(Person.class).block().getBody();
    }
}
