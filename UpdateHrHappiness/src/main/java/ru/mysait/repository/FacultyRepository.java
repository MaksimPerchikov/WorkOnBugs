package ru.mysait.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mysait.model.useInformation.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
}
