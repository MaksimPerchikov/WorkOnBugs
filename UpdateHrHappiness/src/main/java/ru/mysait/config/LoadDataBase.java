package ru.mysait.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import ru.mysait.model.FirstType;
import ru.mysait.repository.FirstTypeRepository;

@Controller
public class LoadDataBase {

    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDataBaseStatusProject(FirstTypeRepository firstTypeRepository) {
        return args -> {
            log.info("Preloading " + firstTypeRepository
                    .save(new FirstType(1L, "В работе")));
            log.info("Preloading " + firstTypeRepository
                    .save(new FirstType(2L, "Черновик")));
            log.info("Preloading " + firstTypeRepository
                    .save(new FirstType(3L, "Архив")));
        };
    }
}
