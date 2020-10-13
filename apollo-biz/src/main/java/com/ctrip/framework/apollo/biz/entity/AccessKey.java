package com.ctrip.framework.apollo.biz.entity;

import com.ctrip.framework.apollo.common.entity.BaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "CONFIG_ACCESS_KEY",indexes = {
        @Index(name = "IDX_ACCESS_KEY_APP_ID", columnList = "APP_ID"),
        @Index(name = "IDX_ACCKEY_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update CONFIG_ACCESS_KEY set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class AccessKey extends BaseEntity {

  @Column(name = "APP_ID", nullable = false)
  private String appId;

  @Column(name = "SECRET", nullable = false)
  private String secret;

  @Column(name = "ENABLED_FLAG", columnDefinition = "Number(1) default 0 ")
  private boolean enabled = false;

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  @Override
  public String toString() {
    return toStringHelper().add("appId", appId).add("secret", secret)
        .add("enabled", enabled).toString();
  }
}
