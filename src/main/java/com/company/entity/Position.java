package com.company.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "position")
@Getter
@Setter
@NoArgsConstructor
public class Position implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`name`", nullable = false, unique = true)
    @Convert(converter = PositionNameConverter.class)
    private Name name;

    @OneToMany(mappedBy = "position")
    private List<Account> accounts;

    public enum Name {
        DEV("Dev"), TEST("Test"), SCRUM_MASTER("Scrum Master"), PM("PM");

        private String name;

        private Name(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static Name toEnum(String sqlName) {
            for (Name item : Name.values()) {
                if (item.getName().equals(sqlName)) {
                    return item;
                }
            }
            return null;
        }
    }
}
