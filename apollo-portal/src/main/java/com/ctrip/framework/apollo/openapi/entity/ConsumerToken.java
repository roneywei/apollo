package com.ctrip.framework.apollo.openapi.entity;

import com.ctrip.framework.apollo.common.entity.BaseEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
@Entity
@Table(name = "PORTAL_CONSUMER_TOKEN",indexes = {
        @Index(name = "IDX_CONTOKEN_CONSUMER_ID", columnList = "CONSUMER_ID"),
        @Index(name = "IDX_CONTOKEN_TOKEN", columnList = "TOKEN",unique = true),
        @Index(name = "IDX_CONTOKEN_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update PORTAL_CONSUMER_TOKEN set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class ConsumerToken extends BaseEntity {
  @Column(name = "CONSUMER_ID")
  private long consumerId;

  @Column(name = "TOKEN", nullable = false, length = 128)
  private String token;

  @Column(name = "EXPIRES", nullable = false)
  private Date expires;

  public long getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(long consumerId) {
    this.consumerId = consumerId;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Date getExpires() {
    return expires;
  }

  public void setExpires(Date expires) {
    this.expires = expires;
  }

  @Override
  public String toString() {
    return toStringHelper().add("consumerId", consumerId).add("token", token)
        .add("expires", expires).toString();
  }
}
