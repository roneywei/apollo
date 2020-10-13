package com.ctrip.framework.apollo.biz.entity;

import com.ctrip.framework.apollo.common.entity.BaseEntity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "CONFIG_ITEM",indexes = {
        @Index(name = "IDX_ITEM_NAMESPACE_ID", columnList = "NAMESPACE_ID"),
        @Index(name = "IDX_ITEM_CHANGE_LASTTIME", columnList = "DATACHANGE_LASTTIME"),
})
@SQLDelete(sql = "Update CONFIG_ITEM set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class Item extends BaseEntity {

  @Column(name = "NAMESPACE_ID", nullable = false)
  private long namespaceId;

  @Column(name = "ITEM_KEY", nullable = false)
  private String key;

  @Column(name = "ITEM_VALUE")
  @Lob
  private String value;

  @Column(name = "COMMENT_MSG")
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

  public String toString() {
    return toStringHelper().add("namespaceId", namespaceId).add("key", key).add("value", value)
        .add("lineNum", lineNum).add("comment", comment).toString();
  }
}
