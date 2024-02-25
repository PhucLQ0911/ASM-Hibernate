package com.company.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`Account`")
@Getter
@Setter
@NoArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "`id`")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`email`", length = 50, unique = true)
    private String email;

    @Column(name = "`username`", length = 50, nullable = false, unique = true)
    private String username;


    @Column(name = "`fullname`", length = 50, nullable = false)
    private String fullname;

    @ManyToOne
    @JoinColumn(name = "`department_id`")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "`position_id`")
    private Position position;

    @Column(name = "`created_date`")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<GroupAccount> groupAccounts;

    @PrePersist
    public void prePersit() {
        if (createdDate == null) {
            createdDate = new Date();
        }
        if (position == null) {
            position = new Position();
            position.setId(1);
        }
    }
}
