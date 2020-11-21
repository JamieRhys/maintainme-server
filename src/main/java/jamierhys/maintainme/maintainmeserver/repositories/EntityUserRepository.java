package jamierhys.maintainme.maintainmeserver.repositories;

import org.springframework.data.repository.CrudRepository;

import jamierhys.maintainme.maintainmeserver.entities.EntityUser;

public interface EntityUserRepository extends CrudRepository<EntityUser, Long> {
    EntityUser findByUsername(String username);
}
