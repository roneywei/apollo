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
@Table(name = "PORTAL_PERMISSION",indexes = {
        @Index(name = "IDX_PERM_PERMISSION_TYPE", columnList = "PERMISSION_TYPE"),
        @Index(name = "IDX_PERM_TARGET_ID", columnList = "TARGET_ID"),
        @Index(name = "IDX_PERM_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update PORTAL_PERMISSION set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class Permission extends BaseEntity {
  @Column(name = "PERMISSION_TYPE", nullable = false)
  private String permissionType;

  @Column(name = "TARGET_ID", nullable = false)
  private String targetId;

  public String getPermissionType() {
    return permissionType;
  }

  public void setPermissionType(String permissionType) {
    this.permissionType = permissionType;
  }

  public String getTargetId() {
    return targetId;
  }

  public void setTargetId(String targetId) {
    this.targetId = targetId;
  }
}
