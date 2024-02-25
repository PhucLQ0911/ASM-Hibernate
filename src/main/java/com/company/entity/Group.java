package com.company.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`Group`")
@Getter
@Setter
@NoArgsConstructor
public class Group {

    @Column(name = "`id`")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`name`", length = 50, unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "`creator_id`")
    private Account creator;

    @Column(name = "`created_date`")
    @Temporal(TemporalType.DATE)
    private Date createdDate;


    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<GroupAccount> groupAccounts;

    @PrePersist
    public void prePersist() {
        if (createdDate == null) {
            createdDate = new Date();
        }
    }

}
