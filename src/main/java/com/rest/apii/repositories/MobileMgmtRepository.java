package com.rest.apii.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.apii.entities.MobileMgmt;

public interface MobileMgmtRepository extends JpaRepository<MobileMgmt, Long> {
}