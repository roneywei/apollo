package com.ctrip.framework.apollo.biz.entity;

import com.ctrip.framework.apollo.common.entity.BaseEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "CONFIG_AUDIT",indexes = {
        @Index(name = "IDX_AUDIT_DATACHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update CONFIG_AUDIT set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class Audit extends BaseEntity {

  public enum OP {
    INSERT, UPDATE, DELETE
  }

  @Column(name = "ENTITY_NAME", nullable = false)
  private String entityName;

  @Column(name = "ENTITY_ID")
  private Long entityId;

  @Column(name = "OP_NAME", nullable = false)
  private String opName;

  @Column(name = "COMMENT_MSG")
  private String comment;

  public String getComment() {
    return comment;
  }

  public Long getEntityId() {
    return entityId;
  }

  public String getEntityName() {
    return entityName;
  }

  public String getOpName() {
    return opName;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public void setEntityId(Long entityId) {
    this.entityId = entityId;
  }

  public void setEntityName(String entityName) {
    this.entityName = entityName;
  }

  public void setOpName(String opName) {
    this.opName = opName;
  }

  public String toString() {
    return toStringHelper().add("entityName", entityName).add("entityId", entityId)
        .add("opName", opName).add("comment", comment).toString();
  }
}
