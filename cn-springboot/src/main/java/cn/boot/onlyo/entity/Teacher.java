package cn.boot.onlyo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Teacher")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String likes;

    @Column
    private Date regDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLike() {
        return likes;
    }

    public void setLike(String likes) {
        this.likes = likes;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", likes='" + likes + '\'' +
                ", regDate=" + regDate +
                '}';
    }

    public Teacher(String name, String likes, Date regDate) {
        this.name = name;
        this.likes = likes;
        this.regDate = regDate;
    }

    public Teacher() {

    }
}
