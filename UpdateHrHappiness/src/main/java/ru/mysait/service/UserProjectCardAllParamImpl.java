package ru.mysait.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mysait.dto.UserProjectCardWithAllDto;
import ru.mysait.model.FirstType;
import ru.mysait.model.SecondType;
import ru.mysait.model.UserProjectCard;
import ru.mysait.model.useInformation.Faculty;
import ru.mysait.model.useInformation.University;
import ru.mysait.model.useInformation.User;
import ru.mysait.repository.*;
import ru.mysait.service.interfeces.UserProjectCardAllParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserProjectCardAllParamImpl implements UserProjectCardAllParam {

    private final UserProjectCardRepository userProjectCardRepository;
    private final FirstTypeRepository firstTypeRepository;
    private final SecondTypeRepository secondTypeRepository;
    private final UserRepository userRepository;
    private final UniversityRepository universityRepository;
    private final FacultyRepository facultyRepository;


    @Autowired
    public UserProjectCardAllParamImpl(UserProjectCardRepository userProjectCardRepository,
                                       FirstTypeRepository firstTypeRepository,
                                       SecondTypeRepository secondTypeRepository,
                                       UserRepository userRepository,
                                       UniversityRepository universityRepository,
                                       FacultyRepository facultyRepository) {
        this.userProjectCardRepository = userProjectCardRepository;
        this.firstTypeRepository = firstTypeRepository;
        this.secondTypeRepository = secondTypeRepository;
        this.userRepository = userRepository;
        this.universityRepository = universityRepository;
        this.facultyRepository = facultyRepository;
    }

    //показать введенные дтошки,все
    @Override
    public List<UserProjectCardWithAllDto> getAllUserWithAllDto() {
        return userProjectCardRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    //преобразовать Сущность в дто
    @Override
    public UserProjectCardWithAllDto convertEntityToDto(UserProjectCard userProjectCard) {
        UserProjectCardWithAllDto userWithAllDto = new UserProjectCardWithAllDto();
        userWithAllDto.setNameProject(userProjectCard.getNameProject());
        userWithAllDto.setNameCustomer(userProjectCard.getCustomerName());
        userWithAllDto.setFirstType(userProjectCard.getFirstType().getFirstTypeName());
        userWithAllDto.setSecondType(userProjectCard.getSecondType().getSecondTypeName());
        return userWithAllDto;
    }

    //вывести все карчтоки
    @Override
    public List<UserProjectCard> getAllUserProjectCard() {
        List<UserProjectCard> collect = userProjectCardRepository.findAll();
        return collect.stream()
                .collect(Collectors.toList());
    }

    //создание карточки пользователя
    @Override
    public UserProjectCard converterDtoToEntity(UserProjectCardWithAllDto userProjectCardWithAllDto) {
        UserProjectCard userProjectCard = new UserProjectCard();
        User user = new User();
        University universityObject = new University();
        Faculty facultyObject = new Faculty();
        userProjectCard.setNameProject(userProjectCardWithAllDto.getNameProject());
        userProjectCard.setCustomerName(userProjectCardWithAllDto.getNameCustomer());

            List<FirstType> firstTypeList = firstTypeRepository.findAll();

            Optional<FirstType> firstTypeOptional = firstTypeList.stream()
                    .filter(n -> n.getFirstTypeName().equals(userProjectCardWithAllDto.getFirstType()))
                    .findFirst();

            userProjectCard.setFirstType(firstTypeOptional.get());

            List<SecondType> secondTypeList = secondTypeRepository.findAll();

            Optional<SecondType> secondTypeOptional = secondTypeList.stream()
                            .filter( n -> n.getSecondTypeName().equals(userProjectCardWithAllDto.getSecondType()))
                                    .findFirst();
            userProjectCard.setSecondType(secondTypeOptional.get());

            user.setName(userProjectCardWithAllDto.getUserName());
            user.setSurname(userProjectCardWithAllDto.getSurname());

            universityObject.setUniversityName(userProjectCardWithAllDto.getUniversity());
            universityRepository.save(universityObject);
            user.setUniversity(universityObject);


            facultyObject.setFacultyName(userProjectCardWithAllDto.getFaculty());
            facultyRepository.save(facultyObject);
            user.setFaculty(facultyObject);

            userRepository.save(user);
            userProjectCard.setUser(user);

        userProjectCardRepository.save(userProjectCard);

        return userProjectCard;

    }

    //удалить карточку пользователя по айди
    @Override
    public String deleteById(Long id) {
        try {
            userProjectCardRepository.deleteById(id);
            return "Удаление прошло успешно!";
        }catch (Exception e){
            return "Что-то пошло не так..";
        }


    }

    @Override
    public String deleteAllUserProjectCard() {
        try {
            userProjectCardRepository.deleteAll();
            return "удаление прошло успешно!";
        }catch (Exception e){
            return "Something's wrong..";
        }

    }
}
