package ru.mysait.service.interfeces;

import ru.mysait.dto.UserProjectCardWithAllDto;
import ru.mysait.model.UserProjectCard;

import java.util.List;

public interface UserProjectCardAllParam {

    List<UserProjectCardWithAllDto> getAllUserWithAllDto();

    List<UserProjectCard> getAllUserProjectCard();

    UserProjectCardWithAllDto convertEntityToDto(UserProjectCard user);

    UserProjectCard converterDtoToEntity(UserProjectCardWithAllDto userWithAllDto);

    String deleteById(Long id);

    String deleteAllUserProjectCard();

}
