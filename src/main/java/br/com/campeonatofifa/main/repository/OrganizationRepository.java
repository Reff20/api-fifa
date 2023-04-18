package br.com.campeonatofifa.main.repository;

import br.com.campeonatofifa.main.model.OrganizationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface OrganizationRepository extends JpaRepository<OrganizationModel, Integer> {

    @Query(nativeQuery = true,value = "SELECT * FROM ORGANIZATION WHERE ORG_CODE = :code")
    Optional<OrganizationModel> findByOrgCode(@Param("code") String code);

    @Query(nativeQuery = true,value = "SELECT * FROM ORGANIZATION WHERE ORG_NAME = :name")
    Optional<OrganizationModel> findByOrgName(@Param("name") String name);

    @Query(nativeQuery = true,value = "SELECT * FROM ORGANIZATION WHERE ORG_TAG = :tag")
    Optional<OrganizationModel> findByOrgTag(@Param("tag") String tag);

}
