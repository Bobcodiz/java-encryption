package com.codiz.java_encryption.repository;

import com.codiz.java_encryption.model.ToManaged;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToManage extends JpaRepository<ToManaged,Long> {
}
