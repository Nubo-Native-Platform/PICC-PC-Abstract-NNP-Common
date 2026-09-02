package com.nnp.common.abs.features.domainvalues.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.nnp.common.abs.features.domainvalues.entity.ConfigDomain;

import java.util.List;
import java.util.Optional;

public interface ConfigDomainRepository extends JpaRepository<ConfigDomain, String>, JpaSpecificationExecutor<ConfigDomain> {
    @Query("select c from ConfigDomain c where active = true order by c.name, c.sequence, c.label, c.key")
    Optional<List<ConfigDomain>> findAllOrdered();


}