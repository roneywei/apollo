package com.ctrip.framework.apollo.openapi.entity;

import com.ctrip.framework.apollo.common.entity.BaseEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "PORTAL_CONSUMER",indexes = {
        @Index(name = "IDX_CONSUMER_APP_ID", columnList = "APP_ID"),
        @Index(name = "IDX_CONSUMER_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update PORTAL_CONSUMER set DELETED_FLAG = 1 where id = ?")
@Where(clause = "DELETED_FLAG = 0")
public class Consumer extends BaseEntity {

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "APP_ID", nullable = false)
  private String appId;

  @Column(name = "ORG_ID", nullable = false)
  private String orgId;

  @Column(name = "ORG_NAME", nullable = false)
  private String orgName;

  @Column(name = "OWNER_NAME", nullable = false)
  private String ownerName;

  @Column(name = "OWNER_EMAIL", nullable = false)
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

  @Override
  public String toString() {
    return toStringHelper().add("name", name).add("appId", appId)
        .add("orgId", orgId)
        .add("orgName", orgName)
        .add("ownerName", ownerName)
        .add("ownerEmail", ownerEmail).toString();
  }
}
