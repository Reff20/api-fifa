package br.com.campeonatofifa.main.repository;

import br.com.campeonatofifa.main.model.PlayerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface PlayerRepository extends JpaRepository<PlayerModel, Integer> {

    @Query(nativeQuery = true,value = "SELECT * FROM PLAYER WHERE PLAYER_TEAM_NAME = :name")
    Optional<PlayerModel> findByPlayerTeamName(@Param("name") String name);

    @Query(nativeQuery = true,value = "SELECT * FROM PLAYER WHERE PLAYER_NAME = :name")
    Optional<PlayerModel> findByPlayerName(@Param("name") String name);

    @Query(nativeQuery = true,value = "SELECT * FROM PLAYER WHERE PLAYER_TEAM_TAG = :tag")
    Optional<PlayerModel> findByPlayerTeamTag(@Param("tag") String tag);

}
