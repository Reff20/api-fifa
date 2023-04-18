package br.com.campeonatofifa.main.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORGANIZATION", schema = "public")
public class OrganizationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORG_CODE")
    private List<PlayerModel> orgCode;

    @Column(name = "ORG_NAME")
    private String orgName;

    @Column(name = "ORG_TAG")
    private String orgTag;

    @Column(name = "ORG_DATE_CREATED")
    private Date orgDateCreated;

    @Column(name = "ORG_LOGO")
    private String orgLogo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PlayerModel> getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(List<PlayerModel> orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgTag() {
        return orgTag;
    }

    public void setOrgTag(String orgTag) {
        this.orgTag = orgTag;
    }

    public Date getOrgDateCreated() {
        return orgDateCreated;
    }

    public void setOrgDateCreated(Date orgDateCreated) {
        this.orgDateCreated = orgDateCreated;
    }

    public String getOrgLogo() {
        return orgLogo;
    }

    public void setOrgLogo(String orgLogo) {
        this.orgLogo = orgLogo;
    }

    public OrganizationModel(Integer id, List<PlayerModel> orgCode, String orgName, String orgTag, Date orgDateCreated, String orgLogo) {
        this.id = id;
        this.orgCode = orgCode;
        this.orgName = orgName;
        this.orgTag = orgTag;
        this.orgDateCreated = orgDateCreated;
        this.orgLogo = orgLogo;
    }

    public OrganizationModel() {
    }
}
