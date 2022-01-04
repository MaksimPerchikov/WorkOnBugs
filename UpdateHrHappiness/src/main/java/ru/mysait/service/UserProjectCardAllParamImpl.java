package ru.mysait.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mysait.dto.UserProjectCardWithAllDto;
import ru.mysait.model.FirstType;
import ru.mysait.model.SecondType;
import ru.mysait.model.UserProjectCard;
import ru.mysait.repository.FirstTypeRepository;
import ru.mysait.repository.SecondTypeRepository;
import ru.mysait.repository.UserProjectCardRepository;
import ru.mysait.service.interfeces.UserProjectCardAllParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserProjectCardAllParamImpl implements UserProjectCardAllParam {

    private final UserProjectCardRepository userProjectCardRepository;
    private final FirstTypeRepository firstTypeRepository;
    private final SecondTypeRepository secondTypeRepository;

    @Autowired
    public UserProjectCardAllParamImpl(UserProjectCardRepository userProjectCardRepository,
                                       FirstTypeRepository firstTypeRepository,
                                       SecondTypeRepository secondTypeRepository) {
        this.userProjectCardRepository = userProjectCardRepository;
        this.firstTypeRepository = firstTypeRepository;
        this.secondTypeRepository = secondTypeRepository;
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
}
