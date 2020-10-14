package com.ctrip.framework.apollo.biz.entity;

import com.ctrip.framework.apollo.common.entity.BaseEntity;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "CONFIG_NAMESPACE_LOCK",
        uniqueConstraints = {
        @UniqueConstraint(name = "UK_NAMESPACE_LOCK_NAMESPACE_ID",columnNames = {"NAMESPACE_ID"})
        },
        indexes = {
        @Index(name = "IDX_NAMESPLOCK_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@Where(clause = "DELETED_FLAG = 0")
public class NamespaceLock extends BaseEntity{

  @Column(name = "NAMESPACE_ID", nullable = false)
  private long namespaceId;

  public long getNamespaceId() {
    return namespaceId;
  }

  public void setNamespaceId(long namespaceId) {
    this.namespaceId = namespaceId;
  }
}
