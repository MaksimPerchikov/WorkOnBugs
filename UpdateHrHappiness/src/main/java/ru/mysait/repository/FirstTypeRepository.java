package ru.mysait.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mysait.model.FirstType;

@Repository
public interface FirstTypeRepository extends JpaRepository<FirstType,Long> {
}
