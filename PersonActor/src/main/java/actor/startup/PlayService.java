package actor.startup;

import actor.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
@EnableScheduling
public class PlayService {

    final PersonService personService;

    @PostConstruct
    public void initialise() {
        personService.initialise();
    }

    @Scheduled(fixedDelay = 1000)
    public void play() {
        personService.play();
    }

}
