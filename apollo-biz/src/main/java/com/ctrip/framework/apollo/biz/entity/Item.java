package com.ctrip.framework.apollo.biz.entity;


import com.google.common.base.MoreObjects;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CONFIG_ITEM",indexes = {
        @Index(name = "IDX_ITEM_NAMESPACE_ID", columnList = "NAMESPACE_ID"),
        @Index(name = "IDX_ITEM_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update CONFIG_ITEM set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class Item  {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
  @SequenceGenerator(name = "sequence", sequenceName = "APOLLO_ITEM_ID_SEQ", allocationSize = 1)
  @Column(name = "ID")
  private long id;

  @Column(name = "DELETED_FLAG" , columnDefinition = "Number(1) default 0 ")
  private Boolean isDeleted = false;

  @Column(name = "DATACHANGE_CREATEDBY", columnDefinition = "VARCHAR2(255) DEFAULT 'apollo'  NOT NULL")
  private String dataChangeCreatedBy;

  @Column(name = "DATACHANGE_CREATEDTIME", columnDefinition = "TIMESTAMP(6)  DEFAULT CURRENT_TIMESTAMP  NOT NULL ")
  private Date dataChangeCreatedTime;

  @Column(name = "DATACHANGE_LASTMODIFIEDBY", columnDefinition = "VARCHAR2(255) DEFAULT 'apollo'  NOT NULL")
  private String dataChangeLastModifiedBy;

  @Column(name = "DATACHANGE_LASTTIME", columnDefinition = "TIMESTAMP(6)  DEFAULT CURRENT_TIMESTAMP  NOT NULL ")
  private Date dataChangeLastModifiedTime;

  @Column(name = "NAMESPACE_ID", nullable = false)
  private long namespaceId;

  @Column(name = "ITEM_KEY", nullable = false)
  private String key;

  @Column(name = "ITEM_VALUE", nullable = false)
  @Lob
  private String value;

  @Column(name = "COMMENT_MSG", length = 1024)
  private String comment;

  @Column(name = "LINE_NUM")
  private Integer lineNum;

  public String getComment() {
    return comment;
  }

  public String getKey() {
    return key;
  }

  public long getNamespaceId() {
    return namespaceId;
  }

  public String getValue() {
    return value;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public void setNamespaceId(long namespaceId) {
    this.namespaceId = namespaceId;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Integer getLineNum() {
    return lineNum;
  }

  public void setLineNum(Integer lineNum) {
    this.lineNum = lineNum;
  }

  public String getDataChangeCreatedBy() {
    return dataChangeCreatedBy;
  }

  public Date getDataChangeCreatedTime() {
    return dataChangeCreatedTime;
  }

  public String getDataChangeLastModifiedBy() {
    return dataChangeLastModifiedBy;
  }

  public Date getDataChangeLastModifiedTime() {
    return dataChangeLastModifiedTime;
  }

  public long getId() {
    return id;
  }

  public boolean isDeleted() {
    return isDeleted;
  }

  public void setDataChangeCreatedBy(String dataChangeCreatedBy) {
    this.dataChangeCreatedBy = dataChangeCreatedBy;
  }

  public void setDataChangeCreatedTime(Date dataChangeCreatedTime) {
    this.dataChangeCreatedTime = dataChangeCreatedTime;
  }

  public void setDataChangeLastModifiedBy(String dataChangeLastModifiedBy) {
    this.dataChangeLastModifiedBy = dataChangeLastModifiedBy;
  }

  public void setDataChangeLastModifiedTime(Date dataChangeLastModifiedTime) {
    this.dataChangeLastModifiedTime = dataChangeLastModifiedTime;
  }

  public void setDeleted(boolean deleted) {
    isDeleted = deleted;
  }

  public void setId(long id) {
    this.id = id;
  }

  @PrePersist
  protected void prePersist() {
    if(this.dataChangeCreatedBy == null){
      dataChangeCreatedBy = "apollo";
    }
    if (this.dataChangeCreatedTime == null) {
      dataChangeCreatedTime = new Date();
    }
    if (this.dataChangeLastModifiedTime == null) {
      dataChangeLastModifiedTime = new Date();
    }
    if(this.dataChangeLastModifiedBy == null){
      dataChangeLastModifiedBy = "apollo";
    }
  }

  @PreUpdate
  protected void preUpdate() {
    this.dataChangeLastModifiedTime = new Date();
  }

  @PreRemove
  protected void preRemove() {
    this.dataChangeLastModifiedTime = new Date();
  }

  protected MoreObjects.ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this).omitNullValues().add("id", id)
            .add("dataChangeCreatedBy", dataChangeCreatedBy)
            .add("dataChangeCreatedTime", dataChangeCreatedTime)
            .add("dataChangeLastModifiedBy", dataChangeLastModifiedBy)
            .add("dataChangeLastModifiedTime", dataChangeLastModifiedTime);
  }


  public String toString() {
    return toStringHelper().add("namespaceId", namespaceId).add("key", key).add("value", value)
        .add("lineNum", lineNum).add("comment", comment).toString();
  }
}
