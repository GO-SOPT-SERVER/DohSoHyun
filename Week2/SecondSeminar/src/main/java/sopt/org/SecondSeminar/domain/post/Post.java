package sopt.org.SecondSeminar.domain.post;

import lombok.Getter;

@Getter
public class Post {
    private Long id;

    private String name;

    private String contents;

    public Post(String name, String contents){
        this.name = name;
        this.contents = contents;
    }

    public void setId(Long id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\n" +
                "name: " + this.name + "\n"+
                "contents: " + this.contents + "\n";
    }
}
