package org.sopt.secondSeminarChallenge.member.domain;

import lombok.Getter;

@Getter
public class Member {
    private Long id;
    private String email;
    private String name;

    public Member( String email, String name){
        this.email = email;
        this.name = name;
    }

    public void setId(Long id){
        this.id = id;
    }

    @Override
    public String toString(){
        return "id: " + this.id + "\n" +
                "email: "+ this.email + "\n" +
                "name" + this.name + "\n";
    }
}
