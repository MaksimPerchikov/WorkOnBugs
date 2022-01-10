package ru.mysait2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
;
import org.springframework.stereotype.Repository;
import ru.mysait2.model.Gears;
@Repository
public interface GearsRepository extends JpaRepository<Gears,Long> {
}
