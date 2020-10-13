package com.ctrip.framework.apollo.biz.entity;

import com.ctrip.framework.apollo.common.entity.BaseEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "CONFIG_COMMIT",indexes = {
        @Index(name = "IDX_COMMIT_APP_ID", columnList = "APP_ID"),
        @Index(name = "IDX_COMMIT_CLUSTER_NAME", columnList = "CLUSTER_NAME"),
        @Index(name = "IDX_COMMIT_NAMESPACE_NAME", columnList = "NAMESPACE_NAME"),
        @Index(name = "IDX_COMMIT_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update CONFIG_COMMIT set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class Commit extends BaseEntity {

  @Lob
  @Column(name = "CHANGE_SETS", nullable = false)
  private String changeSets;

  @Column(name = "APP_ID", nullable = false)
  private String appId;

  @Column(name = "CLUSTER_NAME", nullable = false)
  private String clusterName;

  @Column(name = "NAMESPACE_NAME", nullable = false)
  private String namespaceName;

  @Column(name = "COMMENT_MSG")
  private String comment;

  public String getChangeSets() {
    return changeSets;
  }

  public void setChangeSets(String changeSets) {
    this.changeSets = changeSets;
  }

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

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Override
  public String toString() {
    return toStringHelper().add("changeSets", changeSets).add("appId", appId).add("clusterName", clusterName)
        .add("namespaceName", namespaceName).add("comment", comment).toString();
  }
}
