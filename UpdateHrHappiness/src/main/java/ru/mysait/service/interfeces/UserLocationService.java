package ru.mysait.service.interfeces;

import ru.mysait.dto.UserLocationDto;
import ru.mysait.model.User;

import java.util.List;
import java.util.Optional;

public interface UserLocationService {

    List<UserLocationDto> getAllUserLocationDto();

    UserLocationDto convertEntityToDto(User user);
}
