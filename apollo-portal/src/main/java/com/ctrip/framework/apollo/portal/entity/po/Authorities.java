package com.ctrip.framework.apollo.portal.entity.po;

import com.ctrip.framework.apollo.common.entity.BaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * Created by Roney on 2020/9/15.
 *
 * @author Roney
 * @date 2020-09-15 14:10
 */
@Entity
@Table(name = "AUTHORITIES")
@SQLDelete(sql = "Update AUTHORITIES set DELETED_FLAG = 1 where ID = ?")
@Where(clause = "DELETED_FLAG = 0")
public class Authorities  extends BaseEntity {
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "AUTHORITY", nullable = false)
    private long authority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getAuthority() {
        return authority;
    }

    public void setAuthority(long authority) {
        this.authority = authority;
    }
}
