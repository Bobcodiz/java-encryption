package com.codiz.enc.repository;

import com.codiz.enc.models.ManagedObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagedObjectsRepository extends JpaRepository<ManagedObject,Long> {
}
