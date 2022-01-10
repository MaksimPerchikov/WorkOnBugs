package ru.mysait2.service.Interface;

import ru.mysait2.dto.CarDao;
import ru.mysait2.model.Cars;

import java.util.List;

public interface CarsInterface {

    List<Cars> findAllCarsEnt();
    List<CarDao> findAllCarsDto();

    String addNewCar(CarDao carDao);

    Cars converterDtoToEntity(CarDao carDao);

    CarDao converterEntityToDto(Cars cars);

}
