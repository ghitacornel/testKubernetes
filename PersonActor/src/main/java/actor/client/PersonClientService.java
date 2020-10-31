package actor.client;

import actor.model.Person;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PersonClientService {

    private PersonClient client;

    @PostConstruct
    public void init() {
        client = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(Person.class))
                .logLevel(Logger.Level.FULL)
                .target(PersonClient.class, "http://localhost:8080/person");
    }

    public List<Person> loadAll() {
        return client.findAll();
    }

    public void register(Person person) {
        client.register(person);
    }

    public void unregister(String id) {
        client.unregister(id);
    }

}
