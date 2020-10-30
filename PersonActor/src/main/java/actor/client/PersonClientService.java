package actor.client;

import actor.model.Person;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonClientService {

    public List<Person> loadAll() {
        PersonClient client = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(Person.class))
                .logLevel(Logger.Level.FULL)
                .target(PersonClient.class, "http://localhost:8080/person");
        return client.findAll();
    }

    public Person register() {
        PersonClient client = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(Person.class))
                .logLevel(Logger.Level.FULL)
                .target(PersonClient.class, "http://localhost:8080/person");
        return client.register();
    }

    public void unregister(String id) {
        PersonClient client = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(Person.class))
                .logLevel(Logger.Level.FULL)
                .target(PersonClient.class, "http://localhost:8080/person");
        client.unregister(id);
    }

}
