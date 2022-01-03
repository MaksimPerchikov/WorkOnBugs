package ru.mysait.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mysait.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
}
