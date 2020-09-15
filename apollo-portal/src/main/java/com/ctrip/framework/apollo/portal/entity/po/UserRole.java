package com.ctrip.framework.apollo.portal.entity.po;

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
@Table(name = "USER_ROLE",indexes = {
        @Index(name = "IDX_USERROLE_USER_ID", columnList = "USER_ID"),
        @Index(name = "IDX_USERROLE_ROLE_ID", columnList = "ROLE_ID"),
        @Index(name = "IDX_USERROLE_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update USER_ROLE set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class UserRole extends BaseEntity {
  @Column(name = "USER_ID", nullable = false)
  private String userId;

  @Column(name = "ROLE_ID", nullable = false)
  private long roleId;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }
}
