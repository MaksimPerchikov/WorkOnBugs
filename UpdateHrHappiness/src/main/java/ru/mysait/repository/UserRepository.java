package ru.mysait.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mysait.model.useInformation.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
