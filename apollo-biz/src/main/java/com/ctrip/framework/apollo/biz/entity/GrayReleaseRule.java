package com.ctrip.framework.apollo.biz.entity;

import com.ctrip.framework.apollo.common.entity.BaseEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "GRAY_RELEASE_RULE",indexes = {
        @Index(name = "IDX_GRARRULE_APP_ID", columnList = "APP_ID"),
        @Index(name = "IDX_GRARRULE_CLUSTER_NAME", columnList = "CLUSTER_NAME"),
        @Index(name = "IDX_GRARRULE_NAMESPACE_NAME", columnList = "NAMESPACE_NAME"),
        @Index(name = "IDX_GRARRULE_RELEASE_ID", columnList = "RELEASE_ID"),
        @Index(name = "IDX_GRARRULE_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update GRAY_RELEASE_RULE set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class GrayReleaseRule extends BaseEntity{

  @Column(name = "APP_ID", nullable = false)
  private String appId;

  @Column(name = "CLUSTER_NAME", nullable = false)
  private String clusterName;

  @Column(name = "NAMESPACE_NAME", nullable = false)
  private String namespaceName;

  @Column(name = "BRANCH_NAME", nullable = false)
  private String branchName;

  @Column(name = "RULES")
  private String rules;

  @Column(name = "RELEASE_ID", nullable = false)
  private Long releaseId;

  @Column(name = "BRANCH_STATUS", nullable = false)
  private int branchStatus;

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getClusterName() {
    return clusterName;
  }

  public void setClusterName(String clusterName) {
    this.clusterName = clusterName;
  }

  public String getNamespaceName() {
    return namespaceName;
  }

  public void setNamespaceName(String namespaceName) {
    this.namespaceName = namespaceName;
  }

  public String getBranchName() {
    return branchName;
  }

  public void setBranchName(String branchName) {
    this.branchName = branchName;
  }

  public String getRules() {
    return rules;
  }

  public void setRules(String rules) {
    this.rules = rules;
  }

  public Long getReleaseId() {
    return releaseId;
  }

  public void setReleaseId(Long releaseId) {
    this.releaseId = releaseId;
  }

  public int getBranchStatus() {
    return branchStatus;
  }

  public void setBranchStatus(int branchStatus) {
    this.branchStatus = branchStatus;
  }
}
