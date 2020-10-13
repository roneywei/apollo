package com.ctrip.framework.apollo.biz.entity;

import com.google.common.base.MoreObjects;

import java.util.Date;

import javax.persistence.*;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
@Entity
@Table(name = "CONFIG_INSTANCE",uniqueConstraints = {
        @UniqueConstraint(name="UK_INSTANCE_APP_ID_CN_DC_IP",columnNames = {"APP_ID","CLUSTER_NAME","DATA_CENTER","IP"})
},
indexes = {
        @Index(name = "IDX_INSTANCE_IP", columnList = "IP"),
        @Index(name = "IDX_INSTANCE_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
public class Instance {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
  @SequenceGenerator(name = "sequence", sequenceName = "APOLLO_ID_SEQ", allocationSize = 1)
  @Column(name = "ID")
  private long id;

  @Column(name = "APP_ID", nullable = false)
  private String appId;

  @Column(name = "CLUSTER_NAME", nullable = false)
  private String clusterName;

  @Column(name = "DATA_CENTER", nullable = false)
  private String dataCenter;

  @Column(name = "IP", nullable = false)
  private String ip;

  @Column(name = "DATACHANGE_CREATEDTIME", nullable = false)
  private Date dataChangeCreatedTime;

  @Column(name = "DATACHANGE_LASTTIME")
  private Date dataChangeLastModifiedTime;

  @PrePersist
  protected void prePersist() {
    if (this.dataChangeCreatedTime == null) {
      dataChangeCreatedTime = new Date();
    }
    if (this.dataChangeLastModifiedTime == null) {
      dataChangeLastModifiedTime = dataChangeCreatedTime;
    }
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public String getDataCenter() {
    return dataCenter;
  }

  public void setDataCenter(String dataCenter) {
    this.dataCenter = dataCenter;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public Date getDataChangeCreatedTime() {
    return dataChangeCreatedTime;
  }

  public void setDataChangeCreatedTime(Date dataChangeCreatedTime) {
    this.dataChangeCreatedTime = dataChangeCreatedTime;
  }

  public Date getDataChangeLastModifiedTime() {
    return dataChangeLastModifiedTime;
  }

  public void setDataChangeLastModifiedTime(Date dataChangeLastModifiedTime) {
    this.dataChangeLastModifiedTime = dataChangeLastModifiedTime;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .omitNullValues()
        .add("id", id)
        .add("appId", appId)
        .add("clusterName", clusterName)
        .add("dataCenter", dataCenter)
        .add("ip", ip)
        .add("dataChangeCreatedTime", dataChangeCreatedTime)
        .add("dataChangeLastModifiedTime", dataChangeLastModifiedTime)
        .toString();
  }
}
