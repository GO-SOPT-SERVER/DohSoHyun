package sopt.org.SecondSeminar.domain.user;

import lombok.Getter;

@Getter
public class User {
    private Long id;
    private String gender;
    private String name;
    private String email;
    private int age;

    public User(String gender, String name, String email, int age){
        this.gender = gender;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public void setId(Long id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\n" +
                "gender: " + this.gender + "\n" +
                "name: " + this.name + "\n" +
                "email: " + this.email + "\n" +
                "age: " + this.age;
    }
}
