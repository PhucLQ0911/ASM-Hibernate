package com.company.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "`group_account`")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class GroupAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @NonNull
    private GroupAccountPK id;

    @ManyToOne
    @MapsId("account_id")
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @MapsId("group_id")
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "join_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date joinDate;

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @RequiredArgsConstructor
    public static class GroupAccountPK implements Serializable {

        private static final long serialVersionUID = 1L;

        @Column(name = "group_id")
        @NonNull
        private Integer groupId;

        @Column(name = "account_id")
        @NonNull
        private Integer accountId;
    }
}
