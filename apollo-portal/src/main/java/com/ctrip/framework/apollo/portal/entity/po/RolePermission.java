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
@Table(name = "PORTAL_ROLE_PERMISSION",indexes = {
        @Index(name = "IDX_ROLEPERM_ROLE_ID", columnList = "ROLE_ID"),
        @Index(name = "IDX_ROLEPERM_PERMISSION_ID", columnList = "PERMISSION_ID"),
        @Index(name = "IDX_ROLEPERM_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update PORTAL_ROLE_PERMISSION set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class RolePermission extends BaseEntity {
  @Column(name = "ROLE_ID", nullable = false)
  private long roleId;

  @Column(name = "PERMISSION_ID", nullable = false)
  private long permissionId;

  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }

  public long getPermissionId() {
    return permissionId;
  }

  public void setPermissionId(long permissionId) {
    this.permissionId = permissionId;
  }
}
