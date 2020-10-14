package com.ctrip.framework.apollo.common.entity;

import com.ctrip.framework.apollo.common.utils.InputValidator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "CONFIG_APP",indexes = {
        @Index(name = "IDX_APP_APP_ID", columnList = "APP_ID"),
        @Index(name = "IDX_APP_NAME", columnList = "NAME"),
        @Index(name = "IDX_APP_DATACHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update CONFIG_APP set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class App extends BaseEntity {

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

    private App app = new App();

    public Builder name(String name) {
      app.setName(name);
      return this;
    }

    public Builder appId(String appId) {
      app.setAppId(appId);
      return this;
    }

    public Builder orgId(String orgId) {
      app.setOrgId(orgId);
      return this;
    }

    public Builder orgName(String orgName) {
      app.setOrgName(orgName);
      return this;
    }

    public Builder ownerName(String ownerName) {
      app.setOwnerName(ownerName);
      return this;
    }

    public Builder ownerEmail(String ownerEmail) {
      app.setOwnerEmail(ownerEmail);
      return this;
    }

    public App build() {
      return app;
    }

  }

  public static Builder builder() {
    return new Builder();
  }


}
