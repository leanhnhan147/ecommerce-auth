package com.ecommerce.auth.repository;


import com.ecommerce.auth.model.ServerProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerProviderRepository extends JpaRepository<ServerProvider, Long>, JpaSpecificationExecutor<ServerProvider> {
    ServerProvider findFirstByUrl(String url);
}
