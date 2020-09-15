package com.ctrip.framework.apollo.biz.entity;

import com.google.common.base.MoreObjects;

import java.util.Date;

import javax.persistence.*;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
@Entity
@Table(name = "INSTANCE_CONFIG",uniqueConstraints = {
        @UniqueConstraint(name="UK_INSCONFIG_APP_ID_NAMESPACE",columnNames = {"INSTANCE_ID","CONFIG_APP_ID","CONFIG_NAMESPACE_NAME"})
},
        indexes = {
                @Index(name = "IDX_INSCONFIG_CONFIG_APP_ID", columnList = "CONFIG_APP_ID"),
                @Index(name = "IDX_INSCONFIG_CLUSTER_NAME", columnList = "CONFIG_CLUSTER_NAME"),
                @Index(name = "IDX_INSCONFIG_NAMESPACE_NAME", columnList = "CONFIG_NAMESPACE_NAME"),
                @Index(name = "IDX_INSCONFIG_RELEASE_KEY", columnList = "RELEASE_KEY"),
                @Index(name = "IDX_INSCONFIG_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
        })
public class InstanceConfig {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
  @SequenceGenerator(name = "sequence", sequenceName = "APOLLO_ID_SEQ", allocationSize = 1)
  @Column(name = "ID")
  private long id;

  @Column(name = "INSTANCE_ID")
  private long instanceId;

  @Column(name = "CONFIG_APP_ID", nullable = false)
  private String configAppId;

  @Column(name = "CONFIG_CLUSTER_NAME", nullable = false)
  private String configClusterName;

  @Column(name = "CONFIG_NAMESPACE_NAME", nullable = false)
  private String configNamespaceName;

  @Column(name = "RELEASE_KEY", nullable = false)
  private String releaseKey;

  @Column(name = "RELEASE_DELIVERY_TIME", nullable = false)
  private Date releaseDeliveryTime;

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

  @PreUpdate
  protected void preUpdate() {
    this.dataChangeLastModifiedTime = new Date();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(long instanceId) {
    this.instanceId = instanceId;
  }

  public String getConfigAppId() {
    return configAppId;
  }

  public void setConfigAppId(String configAppId) {
    this.configAppId = configAppId;
  }

  public String getConfigNamespaceName() {
    return configNamespaceName;
  }

  public void setConfigNamespaceName(String configNamespaceName) {
    this.configNamespaceName = configNamespaceName;
  }

  public String getReleaseKey() {
    return releaseKey;
  }

  public void setReleaseKey(String releaseKey) {
    this.releaseKey = releaseKey;
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

  public String getConfigClusterName() {
    return configClusterName;
  }

  public void setConfigClusterName(String configClusterName) {
    this.configClusterName = configClusterName;
  }

  public Date getReleaseDeliveryTime() {
    return releaseDeliveryTime;
  }

  public void setReleaseDeliveryTime(Date releaseDeliveryTime) {
    this.releaseDeliveryTime = releaseDeliveryTime;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .omitNullValues()
        .add("id", id)
        .add("configAppId", configAppId)
        .add("configClusterName", configClusterName)
        .add("configNamespaceName", configNamespaceName)
        .add("releaseKey", releaseKey)
        .add("dataChangeCreatedTime", dataChangeCreatedTime)
        .add("dataChangeLastModifiedTime", dataChangeLastModifiedTime)
        .toString();
  }
}
