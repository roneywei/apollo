package com.ctrip.framework.apollo.biz.entity;

import com.ctrip.framework.apollo.common.entity.BaseEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "CONFIG_NAMESPACE",indexes = {
        @Index(name = "IDX_NAMESPACE_APP_ID", columnList = "APP_ID"),
        @Index(name = "IDX_NAMESPACE_CLUSTER_NAME", columnList = "CLUSTER_NAME"),
        @Index(name = "IDX_NAMESPACE_NAMESPACE_NAME", columnList = "NAMESPACE_NAME"),
        @Index(name = "IDX_NAMESPACE_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update CONFIG_NAMESPACE set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class Namespace extends BaseEntity {

  @Column(name = "APP_ID", nullable = false, length = 500)
  private String appId;

  @Column(name = "CLUSTER_NAME", nullable = false, length = 500)
  private String clusterName;

  @Column(name = "NAMESPACE_NAME", nullable = false, length = 500)
  private String namespaceName;

  public Namespace(){

  }

  public Namespace(String appId, String clusterName, String namespaceName) {
    this.appId = appId;
    this.clusterName = clusterName;
    this.namespaceName = namespaceName;
  }

  public String getAppId() {
    return appId;
  }

  public String getClusterName() {
    return clusterName;
  }

  public String getNamespaceName() {
    return namespaceName;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public void setClusterName(String clusterName) {
    this.clusterName = clusterName;
  }

  public void setNamespaceName(String namespaceName) {
    this.namespaceName = namespaceName;
  }

  public String toString() {
    return toStringHelper().add("appId", appId).add("clusterName", clusterName)
        .add("namespaceName", namespaceName).toString();
  }
}
