package cn.boot.onlyo.entity;

import java.io.Serializable;

public class Student implements Serializable {

    /**
    	 * 
    	 */
    private static final long serialVersionUID = 7107413248445531737L;

    private int id;

    private String name;

    private int score;

    private int age;

    public Student() {

    }

    public Student(int id, String name, int score, int age) {
        super();
        this.id = id;
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", score=" + score + ", age=" + age + "]";
    }

}
