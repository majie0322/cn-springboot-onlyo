package cn.boot.onlyo.entity;

import java.io.Serializable;

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

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", name='" + name + '\'' + ", likes='" + likes + '\'' + '}';
    }

    public Teacher() {
    }

    public Teacher(String name, String likes) {
        this.name = name;
        this.likes = likes;
    }
}
