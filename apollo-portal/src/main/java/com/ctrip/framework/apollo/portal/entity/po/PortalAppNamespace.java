package com.ctrip.framework.apollo.portal.entity.po;


import com.ctrip.framework.apollo.common.entity.BaseEntity;
import com.ctrip.framework.apollo.common.utils.InputValidator;
import com.ctrip.framework.apollo.core.enums.ConfigFileFormat;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "PORTAL_APP_NAMESPACE",indexes = {
        @Index(name = "IDX_POAPP_NAMESPACE_APP_ID", columnList = "APP_ID"),
        @Index(name = "IDX_POAPP_NAMESPACE_NAME", columnList = "NAME"),
        @Index(name = "IDX_POAPPNASP_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update PORTAL_APP_NAMESPACE set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class PortalAppNamespace extends BaseEntity {

  @NotBlank(message = "AppNamespace Name cannot be blank")
  @Pattern(
          regexp = InputValidator.CLUSTER_NAMESPACE_VALIDATOR,
          message = "Invalid Namespace format: " + InputValidator.INVALID_CLUSTER_NAMESPACE_MESSAGE + " & " + InputValidator.INVALID_NAMESPACE_NAMESPACE_MESSAGE
  )
  @Column(name = "NAME", nullable = false, length = 32)
  private String name;

  @NotBlank(message = "AppId cannot be blank")
  @Column(name = "APP_ID", nullable = false, length = 32)
  private String appId;

  @Column(name = "FORMAT", nullable = false, length = 32)
  private String format;

  @Column(name = "PUBLIC_FLAG", columnDefinition = "Number(1) default 0 ")
  private boolean isPublic = false;

  @Column(name = "COMMENT_MSG", length = 1024)
  private String comment;

  public String getAppId() {
    return appId;
  }

  public String getComment() {
    return comment;
  }

  public String getName() {
    return name;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isPublic() {
    return isPublic;
  }

  public void setPublic(boolean aPublic) {
    isPublic = aPublic;
  }

  public ConfigFileFormat formatAsEnum() {
    return ConfigFileFormat.fromString(this.format);
  }

  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public String toString() {
    return toStringHelper().add("name", name).add("appId", appId).add("comment", comment)
        .add("format", format).add("isPublic", isPublic).toString();
  }
}
