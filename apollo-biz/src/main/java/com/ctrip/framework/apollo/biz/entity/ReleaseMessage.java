package com.ctrip.framework.apollo.biz.entity;

import com.google.common.base.MoreObjects;

import java.util.Date;

import javax.persistence.*;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
@Entity
@Table(name = "CONFIG_RELEASE_MESSAGE",indexes = {
        @Index(name = "IDX_RELEASEMES_MESSAGE", columnList = "MESSAGE"),
        @Index(name = "IDX_RELEASEMES_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
public class ReleaseMessage {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
  @SequenceGenerator(name = "sequence", sequenceName = "APOLLO_ID_SEQ", allocationSize = 1)
  @Column(name = "ID")
  private long id;

  @Column(name = "MESSAGE", nullable = false)
  private String message;

  @Column(name = "DATACHANGE_LASTTIME")
  private Date dataChangeLastModifiedTime;

  @PrePersist
  protected void prePersist() {
    if (this.dataChangeLastModifiedTime == null) {
      dataChangeLastModifiedTime = new Date();
    }
  }

  public ReleaseMessage() {
  }

  public ReleaseMessage(String message) {
    this.message = message;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .omitNullValues()
        .add("id", id)
        .add("message", message)
        .add("dataChangeLastModifiedTime", dataChangeLastModifiedTime)
        .toString();
  }
}
