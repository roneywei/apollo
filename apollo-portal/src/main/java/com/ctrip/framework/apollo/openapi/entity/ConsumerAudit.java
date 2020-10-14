package com.ctrip.framework.apollo.openapi.entity;

import com.google.common.base.MoreObjects;

import java.util.Date;

import javax.persistence.*;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
@Entity
@Table(name = "PORTAL_CONSUMER_AUDIT",indexes = {
        @Index(name = "IDX_CONAUDIT_CONSUMER_ID", columnList = "CONSUMER_ID"),
        @Index(name = "IDX_CONAUDIT_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
public class ConsumerAudit {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
  @SequenceGenerator(name = "sequence", sequenceName = "APOLLO_ID_SEQ", allocationSize = 1)
  @Column(name = "ID")
  private long id;

  @Column(name = "CONSUMER_ID", length = 19)
  private long consumerId;

  @Column(name = "URI", nullable = false, length = 1024)
  private String uri;

  @Column(name = "METHOD", nullable = false, length = 16)
  private String method;

  @Column(name = "DATACHANGE_CREATEDTIME", columnDefinition = "TIMESTAMP(6)  DEFAULT CURRENT_TIMESTAMP  NOT NULL ")
  private Date dataChangeCreatedTime;

  @Column(name = "DATACHANGE_LASTTIME", columnDefinition = "TIMESTAMP(6)  DEFAULT CURRENT_TIMESTAMP  NOT NULL ")
  private Date dataChangeLastModifiedTime;

  @PrePersist
  protected void prePersist() {
    if (this.dataChangeCreatedTime == null) {
      this.dataChangeCreatedTime = new Date();
    }
    if (this.dataChangeLastModifiedTime == null) {
      dataChangeLastModifiedTime = this.dataChangeCreatedTime;
    }
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(long consumerId) {
    this.consumerId = consumerId;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
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
        .add("consumerId", consumerId)
        .add("uri", uri)
        .add("method", method)
        .add("dataChangeCreatedTime", dataChangeCreatedTime)
        .add("dataChangeLastModifiedTime", dataChangeLastModifiedTime)
        .toString();
  }
}
