package me.socialid.contactManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import me.socialid.contactManagement.contact.domain.Name;

@Repository
@RepositoryRestResource(collectionResourceRel = "name", path = "name")
public interface NameRepository extends RevisionRepository<Name, Long, Integer>,JpaRepository<Name, Long> {

}
