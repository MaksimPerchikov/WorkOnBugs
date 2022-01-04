package ru.mysait.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mysait.dto.UserProjectCardWithAllDto;
import ru.mysait.model.FirstType;
import ru.mysait.model.UserProjectCard;
import ru.mysait.repository.FirstTypeRepository;
import ru.mysait.repository.UserProjectCardRepository;
import ru.mysait.service.interfeces.UserProjectCardAllParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserProjectCardAllParamImpl implements UserProjectCardAllParam {

    private final UserProjectCardRepository userRepositoryProjectCardRepository;
    private final FirstTypeRepository firstTypeRepository;

    @Autowired
    public UserProjectCardAllParamImpl(UserProjectCardRepository userRepositoryProjectCardRepository,
                                       FirstTypeRepository firstTypeRepository) {
        this.userRepositoryProjectCardRepository = userRepositoryProjectCardRepository;
        this.firstTypeRepository = firstTypeRepository;
    }

    @Autowired


    @Override
    public List<UserProjectCardWithAllDto> getAllUserWithAllDto() {
        return userRepositoryProjectCardRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }


    @Override
    public UserProjectCardWithAllDto convertEntityToDto(UserProjectCard userProjectCard) {
        UserProjectCardWithAllDto userWithAllDto = new UserProjectCardWithAllDto();
        userWithAllDto.setNameProject(userProjectCard.getNameProject());
        userWithAllDto.setNameCustomer(userProjectCard.getCustomerName());
       // userWithAllDto.setFirstTypeName(userProjectCard.getFirstTypeName().getTypeName());
        return userWithAllDto;
    }


    @Override
    public List<UserProjectCard> getAllUserProjectCard() {
        List<UserProjectCard> collect = userRepositoryProjectCardRepository.findAll();
        return collect.stream()
                .collect(Collectors.toList());
    }

    @Override
    public UserProjectCard converterDtoToEntity(UserProjectCardWithAllDto userProjectCardWithAllDto) {
        UserProjectCard userProjectCard = new UserProjectCard();
        userProjectCard.setNameProject(userProjectCardWithAllDto.getNameProject());
        userProjectCard.setCustomerName(userProjectCardWithAllDto.getNameCustomer());

            List<FirstType> firstTypeList = firstTypeRepository.findAll();
            Optional<FirstType> firstTypeOptional = firstTypeList.stream()
                    .filter(n -> n.getFirstTypeName().equals(userProjectCardWithAllDto.getFirstType()))
                            .findFirst();

            userProjectCard.setFirstTypeName(firstTypeOptional.get());

        userRepositoryProjectCardRepository.save(userProjectCard);
        return userProjectCard;

    }
}
