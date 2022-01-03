package ru.mysait.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mysait.dto.UserLocationDto;
import ru.mysait.model.Location;
import ru.mysait.model.User;
import ru.mysait.repository.LocationRepository;
import ru.mysait.repository.UserRepository;
import ru.mysait.service.interfeces.UserLocationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserLocationServiceImpl implements UserLocationService {

    private final UserRepository userRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public UserLocationServiceImpl(UserRepository userRepository, LocationRepository locationRepository) {
        this.userRepository = userRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<UserLocationDto> getAllUserLocationDto() {
        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserLocationDto convertEntityToDto(User user) {
        UserLocationDto userLocationDto = new UserLocationDto();
        userLocationDto.setUserId(user.getId());
        userLocationDto.setEmail(user.getEmail());
        userLocationDto.setPlace(user.getLocation().getPlace());
        userLocationDto.setD(user.getLocation().getD());
        userLocationDto.setSh(user.getLocation().getSh());
        return userLocationDto;
    }
}
