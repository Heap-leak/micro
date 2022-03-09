package com.hipp.databaseservice.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.hipp.databaseservice.domain.entity.NotificationRegistry;

@Repository
public interface NotificationRegistryRepository extends R2dbcRepository<NotificationRegistry, Long> {
}
