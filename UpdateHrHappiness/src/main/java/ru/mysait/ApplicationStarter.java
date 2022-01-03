package ru.mysait;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.mysait.model.Location;
import ru.mysait.model.User;
import ru.mysait.repository.LocationRepository;
import ru.mysait.repository.UserRepository;

@SpringBootApplication
public class ApplicationStarter implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class);
    }

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        Location location = new Location();
        location.setPlace("Nigniy Novgorod");
        location.setD(77.77);
        location.setSh(88.88);
        locationRepository.save(location);

        User user = new User();
        user.setName("Max");
        user.setEmail("max.@mail.com");
        user.setPassword("password");
        user.setLocation(location);
        userRepository.save(user);
    }
}
