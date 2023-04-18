package br.com.campeonatofifa.main.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "PLAYER", schema = "public")
public class PlayerModel {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "PLAYER_NAME")
    private String playerName;

    @Column(name = "PLAYER_TEAM_NAME")
    private String playerTeamName;

    @Column(name = "PLAYER_TEAM_TAG")
    private String playerTeamTag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PLAYER_ORG_CODE", referencedColumnName = "ORG_CODE")
    private OrganizationModel playerOrgCode;

    @Column(name = "PLAYER_DATE_CREATED")
    private Date playerDateCreated;

    @Column(name = "PLAYER_SCORE")
    private Integer playerScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerTeamName() {
        return playerTeamName;
    }

    public void setPlayerTeamName(String playerTeamName) {
        this.playerTeamName = playerTeamName;
    }

    public String getPlayerTeamTag() {
        return playerTeamTag;
    }

    public void setPlayerTeamTag(String playerTeamTag) {
        this.playerTeamTag = playerTeamTag;
    }

    public OrganizationModel getPlayerOrgCode() {
        return playerOrgCode;
    }

    public void setPlayerOrgCode(OrganizationModel playerOrgCode) {
        this.playerOrgCode = playerOrgCode;
    }

    public Date getPlayerDateCreated() {
        return playerDateCreated;
    }

    public void setPlayerDateCreated(Date playerDateCreated) {
        this.playerDateCreated = playerDateCreated;
    }

    public Integer getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(Integer playerScore) {
        this.playerScore = playerScore;
    }

    public PlayerModel() {
    }

    public PlayerModel(Integer id, String playerName, String playerTeamName, String playerTeamTag, OrganizationModel playerOrgCode, Date playerDateCreated, Integer playerScore) {
        this.id = id;
        this.playerName = playerName;
        this.playerTeamName = playerTeamName;
        this.playerTeamTag = playerTeamTag;
        this.playerOrgCode = playerOrgCode;
        this.playerDateCreated = playerDateCreated;
        this.playerScore = playerScore;
    }
}
