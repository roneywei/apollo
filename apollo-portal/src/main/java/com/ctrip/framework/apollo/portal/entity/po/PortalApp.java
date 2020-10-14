package com.ctrip.framework.apollo.portal.entity.po;

import com.ctrip.framework.apollo.common.entity.BaseEntity;
import com.ctrip.framework.apollo.common.utils.InputValidator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "PORTAL_APP",indexes = {
        @Index(name = "IDX_POAPP_APP_ID", columnList = "APP_ID"),
        @Index(name = "IDX_POAPP_NAME", columnList = "NAME"),
        @Index(name = "IDX_POAPP_DATACHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update PORTAL_APP set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class PortalApp extends BaseEntity {

  @NotBlank(message = "Name cannot be blank")
  @Column(name = "NAME", nullable = false, length = 500)
  private String name;

  @NotBlank(message = "AppId cannot be blank")
  @Pattern(
          regexp = InputValidator.CLUSTER_NAMESPACE_VALIDATOR,
          message = InputValidator.INVALID_CLUSTER_NAMESPACE_MESSAGE
  )
  @Column(name = "APP_ID", nullable = false, length = 500)
  private String appId;

  @Column(name = "ORG_ID", nullable = false, length = 32)
  private String orgId;

  @Column(name = "ORG_NAME", nullable = false, length = 64)
  private String orgName;

  @NotBlank(message = "OwnerName cannot be blank")
  @Column(name = "OWNER_NAME", nullable = false, length = 500)
  private String ownerName;

  @NotBlank(message = "OwnerEmail cannot be blank")
  @Column(name = "OWNER_EMAIL", nullable = false, length = 500)
  private String ownerEmail;

  public String getAppId() {
    return appId;
  }

  public String getName() {
    return name;
  }

  public String getOrgId() {
    return orgId;
  }

  public String getOrgName() {
    return orgName;
  }

  public String getOwnerEmail() {
    return ownerEmail;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setOrgId(String orgId) {
    this.orgId = orgId;
  }

  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }

  public void setOwnerEmail(String ownerEmail) {
    this.ownerEmail = ownerEmail;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public String toString() {
    return toStringHelper().add("name", name).add("appId", appId)
        .add("orgId", orgId)
        .add("orgName", orgName)
        .add("ownerName", ownerName)
        .add("ownerEmail", ownerEmail).toString();
  }

  public static class Builder {

    public Builder() {
    }

    private PortalApp portalApp = new PortalApp();

    public Builder name(String name) {
      portalApp.setName(name);
      return this;
    }

    public Builder appId(String appId) {
      portalApp.setAppId(appId);
      return this;
    }

    public Builder orgId(String orgId) {
      portalApp.setOrgId(orgId);
      return this;
    }

    public Builder orgName(String orgName) {
      portalApp.setOrgName(orgName);
      return this;
    }

    public Builder ownerName(String ownerName) {
      portalApp.setOwnerName(ownerName);
      return this;
    }

    public Builder ownerEmail(String ownerEmail) {
      portalApp.setOwnerEmail(ownerEmail);
      return this;
    }

    public PortalApp build() {
      return portalApp;
    }

  }

  public static Builder builder() {
    return new Builder();
  }


}
