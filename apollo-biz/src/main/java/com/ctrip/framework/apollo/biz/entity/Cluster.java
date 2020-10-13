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
@Table(name = "CONFIG_CLUSTER",indexes = {
        @Index(name = "IDX_CLUSTER_NAME", columnList = "NAME"),
        @Index(name = "IDX_CLUSTER_APP_ID", columnList = "APP_ID"),
        @Index(name = "IDX_CLUSTER_PARENT_ID", columnList = "PARENT_CLUSTER_ID"),
        @Index(name = "IDX_CLUSTER_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update CONFIG_CLUSTER set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class Cluster extends BaseEntity implements Comparable<Cluster> {

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "APP_ID", nullable = false)
  private String appId;

  @Column(name = "PARENT_CLUSTER_ID", nullable = false)
  private long parentClusterId;

  public String getAppId() {
    return appId;
  }

  public String getName() {
    return name;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getParentClusterId() {
    return parentClusterId;
  }

  public void setParentClusterId(long parentClusterId) {
    this.parentClusterId = parentClusterId;
  }

  public String toString() {
    return toStringHelper().add("name", name).add("appId", appId)
        .add("parentClusterId", parentClusterId).toString();
  }

  @Override
  public int compareTo(Cluster o) {
    if (o == null || getId() > o.getId()) {
      return 1;
    }

    if (getId() == o.getId()) {
      return 0;
    }

    return -1;
  }
}
