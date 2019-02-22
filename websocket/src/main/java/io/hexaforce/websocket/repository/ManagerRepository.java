package io.hexaforce.websocket.repository;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hexaforce.websocket.model.Manager;

@RepositoryRestResource(exported = false)
public interface ManagerRepository extends Repository<Manager, Long> {

    Manager save(Manager manager);

    Manager findByName(String name);

}
