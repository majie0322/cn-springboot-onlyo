package cn.boot.onlyo.service;


import cn.boot.onlyo.entity.Student;

import java.util.List;

public interface StuService {
	public List<Student> likeName(String name);
}
