package com.maxhyeon.ndays.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long msrl;
    @Column(nullable =false, unique = true, length =30)
    private String uid;
    @Column(nullable = false, length = 100)
    private String name;
}
