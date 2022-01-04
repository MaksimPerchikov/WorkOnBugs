

package ru.mysait.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import ru.mysait.model.FirstType;
import ru.mysait.model.SecondType;
import ru.mysait.repository.FirstTypeRepository;
import ru.mysait.repository.SecondTypeRepository;

@Controller
public class LoadDataBase {

    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDataBaseFirstType(FirstTypeRepository firstTypeRepository) {
        return args -> {
            log.info("Preloading " + firstTypeRepository
                    .save(new FirstType(1L, "В работе")));
            log.info("Preloading " + firstTypeRepository
                    .save(new FirstType(2L, "Черновик")));
            log.info("Preloading " + firstTypeRepository
                    .save(new FirstType(3L, "Архив")));
        };
    }

    @Bean
    CommandLineRunner initDataBaseSecondType(SecondTypeRepository secondTypeRepository){
        return args -> {
            log.info("Preloading "+ secondTypeRepository
                    .save(new SecondType(1L,"Новый")));
            log.info("Preloading "+ secondTypeRepository
                    .save(new SecondType(2L,"Старый")));
        };
    }
}


