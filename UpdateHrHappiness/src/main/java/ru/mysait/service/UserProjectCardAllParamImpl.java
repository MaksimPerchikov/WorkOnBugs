package ru.mysait.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mysait.dto.UserWithAllDto;
import ru.mysait.model.UserProjectCard;
import ru.mysait.repository.FirstTypeRepository;
import ru.mysait.repository.UserRepository;
import ru.mysait.service.interfeces.UserFirstType;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFirstTypeImpl implements UserFirstType {

    private final UserRepository userRepository;
    private final FirstTypeRepository firstTypeRepository;

    @Autowired
    public UserFirstTypeImpl(UserRepository userRepository, FirstTypeRepository firstTypeRepository) {
        this.userRepository = userRepository;
        this.firstTypeRepository = firstTypeRepository;
    }

    @Override
    public List<UserWithAllDto> getAllUserWithAllDto() {
        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserWithAllDto convertEntityToDto(UserProjectCard user) {
        UserWithAllDto userWithAllDto = new UserWithAllDto();
        userWithAllDto.setUserId(user.getId());
        userWithAllDto.setEmail(user.getEmail());
        userWithAllDto.setFirstType(user.getFirstType().getTypeName());
        return userWithAllDto;
    }

    @Override
    public void converterDtoToEntity(UserWithAllDto userWithAllDto) {
        UserProjectCard user = new UserProjectCard();
        user.setId(userWithAllDto.getUserId());
        user.setEmail(userWithAllDto.getEmail());

        user.getFirstType().setTypeName(userWithAllDto.getFirstType());

        userRepository.save(user);
    }
}
