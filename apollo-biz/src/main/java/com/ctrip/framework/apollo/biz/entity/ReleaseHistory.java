package com.ctrip.framework.apollo.biz.entity;

import com.ctrip.framework.apollo.common.entity.BaseEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
@Entity
@Table(name = "CONFIG_RELEASE_HISTORY",indexes = {
        @Index(name = "IDX_RELEASEHI_APP_ID", columnList = "APP_ID"),
        @Index(name = "IDX_RELEASEHI_CLUSTER_NAME", columnList = "CLUSTER_NAME"),
        @Index(name = "IDX_RELEASEHI_NAMESPACE_NAME", columnList = "NAMESPACE_NAME"),
        @Index(name = "IDX_RELEASEHI_BRANCH_NAME", columnList = "BRANCH_NAME"),
        @Index(name = "IDX_RELEASEHI_RELEASE_ID", columnList = "RELEASE_ID"),
        @Index(name = "IDX_RELEASEHI_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update CONFIG_RELEASE_HISTORY set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class ReleaseHistory extends BaseEntity {
  @Column(name = "APP_ID", nullable = false)
  private String appId;

  @Column(name = "CLUSTER_NAME", nullable = false)
  private String clusterName;

  @Column(name = "NAMESPACE_NAME", nullable = false)
  private String namespaceName;

  @Column(name = "BRANCH_NAME", nullable = false)
  private String branchName;

  @Column(name = "RELEASE_ID")
  private long releaseId;

  @Column(name = "PREVIOUS_RELEASE_ID")
  private long previousReleaseId;

  @Column(name = "OPERATION")
  private int operation;

  @Column(name = "OPERATION_CONTEXT", nullable = false)
  private String operationContext;

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

  public long getReleaseId() {
    return releaseId;
  }

  public void setReleaseId(long releaseId) {
    this.releaseId = releaseId;
  }

  public long getPreviousReleaseId() {
    return previousReleaseId;
  }

  public void setPreviousReleaseId(long previousReleaseId) {
    this.previousReleaseId = previousReleaseId;
  }

  public int getOperation() {
    return operation;
  }

  public void setOperation(int operation) {
    this.operation = operation;
  }

  public String getOperationContext() {
    return operationContext;
  }

  public void setOperationContext(String operationContext) {
    this.operationContext = operationContext;
  }

  public String toString() {
    return toStringHelper().add("appId", appId).add("clusterName", clusterName)
        .add("namespaceName", namespaceName).add("branchName", branchName)
        .add("releaseId", releaseId).add("previousReleaseId", previousReleaseId)
        .add("operation", operation).toString();
  }
}
