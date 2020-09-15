package com.ctrip.framework.apollo.portal.entity.po;

import com.ctrip.framework.apollo.common.entity.BaseEntity;

import javax.persistence.Index;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
@Entity
@Table(name = "SERVER_CONFIG",indexes = {
        @Index(name = "IDX_SERCONFIG_CONFIG_KEY", columnList = "CONFIG_KEY"),
        @Index(name = "IDX_SERCONFIG_CONFIG_VALUE", columnList = "CONFIG_VALUE"),
        @Index(name = "IDX_SERCONFIG_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update SERVER_CONFIG set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class ServerConfig extends BaseEntity {
  @NotBlank(message = "ServerConfig.Key cannot be blank")
  @Column(name = "CONFIG_KEY", nullable = false)
  private String key;

  @NotBlank(message = "ServerConfig.Value cannot be blank")
  @Column(name = "CONFIG_VALUE", nullable = false)
  private String value;

  @Column(name = "CONFIG_COMMENT", nullable = false)
  private String comment;

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String toString() {
    return toStringHelper().add("key", key).add("value", value).add("comment", comment).toString();
  }
}
