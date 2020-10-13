package com.ctrip.framework.apollo.biz.entity;

import com.ctrip.framework.apollo.common.entity.BaseEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
@Entity
@Table(name = "CONFIG_RELEASE",indexes = {
        @Index(name = "IDX_RELEASE_APP_ID", columnList = "APP_ID"),
        @Index(name = "IDX_RELEASE_CLUSTER_NAME", columnList = "CLUSTER_NAME"),
        @Index(name = "IDX_RELEASE_NAMESPACE_NAME", columnList = "NAMESPACE_NAME"),
        @Index(name = "IDX_RELEASE_RELEASE_KEY", columnList = "RELEASE_KEY"),
        @Index(name = "IDX_RELEASE_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update CONFIG_RELEASE set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class Release extends BaseEntity {
  @Column(name = "RELEASE_KEY", nullable = false)
  private String releaseKey;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "APP_ID", nullable = false)
  private String appId;

  @Column(name = "CLUSTER_NAME", nullable = false)
  private String clusterName;

  @Column(name = "NAMESPACE_NAME", nullable = false)
  private String namespaceName;

  @Column(name = "CONFIGURATIONS", nullable = false)
  @Lob
  private String configurations;

  @Column(name = "COMMENT_MSG", nullable = false)
  private String comment;

  @Column(name = "ABANDONED_FLAG", columnDefinition = "Number(1) default 0 ")
  private boolean isAbandoned = false;

  public String getReleaseKey() {
    return releaseKey;
  }

  public String getAppId() {
    return appId;
  }

  public String getClusterName() {
    return clusterName;
  }

  public String getComment() {
    return comment;
  }

  public String getConfigurations() {
    return configurations;
  }

  public String getNamespaceName() {
    return namespaceName;
  }

  public String getName() {
    return name;
  }

  public void setReleaseKey(String releaseKey) {
    this.releaseKey = releaseKey;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public void setClusterName(String clusterName) {
    this.clusterName = clusterName;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public void setConfigurations(String configurations) {
    this.configurations = configurations;
  }

  public void setNamespaceName(String namespaceName) {
    this.namespaceName = namespaceName;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isAbandoned() {
    return isAbandoned;
  }

  public void setAbandoned(boolean abandoned) {
    isAbandoned = abandoned;
  }

  public String toString() {
    return toStringHelper().add("name", name).add("appId", appId).add("clusterName", clusterName)
        .add("namespaceName", namespaceName).add("configurations", configurations)
        .add("comment", comment).add("isAbandoned", isAbandoned).toString();
  }
}
