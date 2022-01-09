package ru.mysait.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mysait.model.useInformation.User;
import ru.mysait.repository.UserRepository;

import ru.mysait.service.interfeces.UserInterface;

import java.util.List;
import java.util.Set;

@Service
public class UserInterfaceImpl implements UserInterface {

    private final UserRepository userRepository;

    @Autowired
    public UserInterfaceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public String findByIdUser(Long id) {
        try{
            String str = userRepository.findById(id).get().toString();
            return showErrorByString(str);
        }catch (Exception e){
            return showErrorByString("User not found! "+"("+e.toString() +")");
        }
    }

    @Override
    public String findAllUsers() {
        try{
          List<User> userList = userRepository.findAll();
          return userList.toString();
        }catch (Exception e){
         return showErrorByString("Something's wrong! "+"("+e.toString() +")");
        }
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String showErrorByString(String str) {
        return str;
    }
}
