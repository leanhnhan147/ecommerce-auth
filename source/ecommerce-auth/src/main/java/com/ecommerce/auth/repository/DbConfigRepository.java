package com.ecommerce.auth.repository;


import com.ecommerce.auth.model.DbConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DbConfigRepository extends JpaRepository<DbConfig, Long>, JpaSpecificationExecutor<DbConfig> {
    DbConfig findByName(String name);
    List<DbConfig> findAllByServerProviderId(Long id);
    List<DbConfig> findAllByInitialize(boolean isInit);

    DbConfig findFirstByServiceTenantId(String name);

    @Query("SELECT d" +
            " FROM DbConfig d" +
            " JOIN Service r ON d.service = r" +
            " WHERE r.id = :serviceId")
    DbConfig findByServiceId(@Param("serviceId") Long serviceId);
}
