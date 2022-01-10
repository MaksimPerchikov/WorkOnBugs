package ru.mysait2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.mysait2.model.EngineType;
@Repository
public interface EngineTypeRepository extends JpaRepository<EngineType,Long> {
}
