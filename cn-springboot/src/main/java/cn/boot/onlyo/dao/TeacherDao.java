package cn.boot.onlyo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import cn.boot.onlyo.entity.Teacher;

@Repository
public interface TeacherDao extends JpaRepository<Teacher, Integer>, JpaSpecificationExecutor {

    // @Query(value = "select * from Teacher where name = ?", nativeQuery = true)
    Teacher findByNameLike(String name);
}
