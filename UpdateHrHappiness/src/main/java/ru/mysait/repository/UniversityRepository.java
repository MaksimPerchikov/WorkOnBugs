package ru.mysait.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mysait.model.useInformation.University;

@Repository
public interface UniversityRepository extends JpaRepository<University,Long> {
}
