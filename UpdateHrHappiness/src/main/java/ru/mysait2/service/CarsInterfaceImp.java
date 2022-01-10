package ru.mysait2.service;

import org.aspectj.asm.IModelFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mysait.model.UserProjectCard;
import ru.mysait2.dto.CarDao;
import ru.mysait2.model.*;
import ru.mysait2.repository.*;
import ru.mysait2.service.Interface.CarsInterface;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarsInterfaceImp implements CarsInterface {

    private final CarsRepository carsRepository;
    private final ModelRepository modelRepository;
    private final EngineTypeRepository engineTypeRepository;
    private final TransmissionRepository transmissionRepository;
    private final GearsRepository gearsRepository;

    @Autowired
    public CarsInterfaceImp(CarsRepository carsRepository,
                            ModelRepository modelRepository,
                            EngineTypeRepository engineTypeRepository,
                            TransmissionRepository transmissionRepository,
                            GearsRepository gearsRepository){
        this.carsRepository = carsRepository;
        this.modelRepository = modelRepository;
        this.engineTypeRepository = engineTypeRepository;
        this.transmissionRepository = transmissionRepository;
        this.gearsRepository = gearsRepository;
    }


    @Override
    public List<Cars> findAllCarsEnt() {
        List<Cars> collect = carsRepository.findAll();
        return collect.stream()
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDao> findAllCarsDto() {
        return null;
    }

    @Override
    public String addNewCar(CarDao carDao) {
        try {
            converterDtoToEntity(carDao);
            String response = "Cars added";
            return  response;
        }catch (Exception e){
            return "Something's wrong!";
        }


    }


    @Override
    public Cars converterDtoToEntity(CarDao carDao) {
        Cars cars = new Cars();
        cars.setColor(carDao.getColor());
        cars.setNumberCar(carDao.getNumberCar());

        Model m = new Model();
        m.setModelName(carDao.getModel());
        modelRepository.save(m);
        cars.setModel(m);

        EngineType engineType = new EngineType();
        engineType.setNameEngine(carDao.getEngineName());
        Gears gears = new Gears();
        gears.setNameGear(carDao.getGearsNameByEngine());
        gearsRepository.save(gears);
        engineType.setGears(gears);
        engineTypeRepository.save(engineType);
        cars.setEngineType(engineType);

        Transmission transmissionObject = new Transmission();
        transmissionObject.setTypeTransmission(carDao.getTransmission());
        transmissionRepository.save(transmissionObject);
        cars.setTransmission(transmissionObject);

        carsRepository.save(cars);

        return cars;

    }

    @Override
    public CarDao converterEntityToDto(Cars cars) {
        return null;
    }
}
