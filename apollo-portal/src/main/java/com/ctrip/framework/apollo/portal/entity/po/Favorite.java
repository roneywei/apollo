package com.ctrip.framework.apollo.portal.entity.po;

import com.ctrip.framework.apollo.common.entity.BaseEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "PORTAL_FAVORITE",indexes = {
        @Index(name = "IDX_FAVORITE_APP_ID", columnList = "APP_ID"),
        @Index(name = "IDX_FAVORITE_USER_ID", columnList = "USER_ID"),
        @Index(name = "IDX_FAVORITE_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update PORTAL_FAVORITE set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class Favorite extends BaseEntity {

  @Column(name = "APP_ID", nullable = false)
  private String appId;

  @Column(name = "USER_ID", nullable = false)
  private String userId;

  @Column(name = "POSITION")
  private long position;

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public long getPosition() {
    return position;
  }

  public void setPosition(long position) {
    this.position = position;
  }
}
