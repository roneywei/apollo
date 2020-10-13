package com.ctrip.framework.apollo.openapi.entity;

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
@Table(name = "PORTAL_CONSUMER_ROLE",indexes = {
        @Index(name = "IDX_CONROLE_CONSUMER_ID", columnList = "CONSUMER_ID"),
        @Index(name = "IDX_CONROLE_ROLE_ID", columnList = "ROLE_ID"),
        @Index(name = "IDX_CONROLE_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update PORTAL_CONSUMER_ROLE set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class ConsumerRole extends BaseEntity {
  @Column(name = "CONSUMER_ID", nullable = false)
  private long consumerId;

  @Column(name = "ROLE_ID", nullable = false)
  private long roleId;

  public long getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(long consumerId) {
    this.consumerId = consumerId;
  }

  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }

  @Override
  public String toString() {
    return toStringHelper().add("consumerId", consumerId).add("roleId", roleId).toString();
  }
}
