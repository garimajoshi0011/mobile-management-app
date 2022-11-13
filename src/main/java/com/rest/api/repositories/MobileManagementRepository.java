package com.rest.api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.entities.MobileManagement;
public interface MobileManagementRepository extends JpaRepository<MobileManagement, Long> {
}