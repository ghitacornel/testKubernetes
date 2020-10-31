package actor.client;

import actor.model.Person;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface PersonClient {

    @RequestLine("GET")
    List<Person> findAll();

    @RequestLine("POST")
    void register(Person person);

    @RequestLine("DELETE /{id}")
    void unregister(@Param("id") String id);

}
