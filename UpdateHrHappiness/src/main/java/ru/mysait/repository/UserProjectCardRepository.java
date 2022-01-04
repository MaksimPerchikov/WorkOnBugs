package ru.mysait.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mysait.model.UserProjectCard;

@Repository
public interface UserProjectCardRepository extends JpaRepository<UserProjectCard,Long> {
}
