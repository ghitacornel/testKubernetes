package actor.generator;

import actor.model.Person;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

@Component
public class PersonGenerator {

    public Person generate() {
        Faker faker = new Faker();
        Person data = new Person();
        data.setId(faker.idNumber().ssnValid());
        data.setFirstName(faker.name().firstName());
        data.setLastName(faker.name().lastName());
        return data;
    }

}
