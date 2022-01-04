package ru.mysait;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.mysait.model.FirstType;
import ru.mysait.model.UserProjectCard;
import ru.mysait.repository.FirstTypeRepository;
import ru.mysait.repository.UserProjectCardRepository;


@SpringBootApplication
public class ApplicationStarter /*implements CommandLineRunner */{
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class);
    }

   /* private final FirstTypeRepository firstTypeRepository;
    private final UserProjectCardRepository userProjectCardRepository;
    @Autowired
    public ApplicationStarter(FirstTypeRepository firstTypeRepository,
                              UserProjectCardRepository userProjectCardRepository) {
        this.firstTypeRepository = firstTypeRepository;
        this.userProjectCardRepository = userProjectCardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        FirstType firstType = new FirstType();
        firstType.setFirstTypeName("Архив");
        firstTypeRepository.save(firstType);

        UserProjectCard userProjectCard = new UserProjectCard();
        userProjectCard.setNameProject("fname");
        userProjectCard.setCustomerName("fcust");
        userProjectCard.setFirstTypeName(firstType);
        userProjectCardRepository.save(userProjectCard);
    }*/
}
