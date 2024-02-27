package com.codiz.encryption.repository;

import com.codiz.encryption.models.ManagedObjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagedObjectsRepository extends JpaRepository<ManagedObjects,Long> {
}
