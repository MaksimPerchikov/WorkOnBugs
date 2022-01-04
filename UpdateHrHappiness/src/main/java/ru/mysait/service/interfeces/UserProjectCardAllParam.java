package ru.mysait.service.interfeces;

import ru.mysait.dto.UserWithAllDto;
import ru.mysait.model.UserProjectCard;

import java.util.List;

public interface UserFirstType {

    List<UserWithAllDto> getAllUserWithAllDto();

    UserWithAllDto convertEntityToDto(UserProjectCard user);

    void converterDtoToEntity(UserWithAllDto userWithAllDto);

}
