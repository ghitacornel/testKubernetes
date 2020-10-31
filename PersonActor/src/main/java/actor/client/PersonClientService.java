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

    public void register(Person person) {
        getClient().post().bodyValue(person);
    }

    public void unregister(String id) {
        getClient().delete().uri("/" + id).retrieve();
    }

}
