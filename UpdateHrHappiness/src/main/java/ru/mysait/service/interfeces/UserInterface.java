package ru.mysait.service.interfeces;

import ru.mysait.model.useInformation.User;

import java.util.List;
import java.util.Set;

public interface UserInterface {

    String findByIdUser(Long id);

    String findAllUsers();

    User addUser(User user);

    String showErrorByString(String str);
}
