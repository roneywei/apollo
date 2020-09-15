package com.ctrip.framework.apollo.biz.entity;

import com.ctrip.framework.apollo.common.entity.BaseEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "PRIVILEGE",
        indexes = {
                @Index(name = "IDX_PRIVILEGE_NAMESPACE_ID", columnList = "NAMESPACE_ID"),
                @Index(name = "IDX_PRIVILEGE_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
        })
@SQLDelete(sql = "Update PRIVILEGE set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class Privilege extends BaseEntity {

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "PRIVIL_TYPE", nullable = false)
  private String privilType;

  @Column(name = "NAMESPACE_ID")
  private long namespaceId;

  public String getName() {
    return name;
  }

  public long getNamespaceId() {
    return namespaceId;
  }

  public String getPrivilType() {
    return privilType;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setNamespaceId(long namespaceId) {
    this.namespaceId = namespaceId;
  }

  public void setPrivilType(String privilType) {
    this.privilType = privilType;
  }

  public String toString() {
    return toStringHelper().add("namespaceId", namespaceId).add("privilType", privilType)
        .add("name", name).toString();
  }
}
