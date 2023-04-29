package org.sopt.ThirdSeminarChallenge.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;


    @Builder
    public User(String name, String email){
        this.name = name;
        this.email = email;
    }
}
