package cn.edu.hebut.jszhang.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.hebut.jszhang.dao.StudentDaoInterface;
import cn.edu.hebut.jszhang.domain.Student;

/**
 * StudentDaoInterfaceImpl
 */
@Repository
public class StudentDaoInterfaceImpl implements StudentDaoInterface {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public int userExists(Student student) {
        int ex = jdbc.queryForObject("select count(*) from students where sno=?", Integer.class , student.getSno());
        if (ex ==0 ) {
            return 0;
        } else {
            int result =  jdbc.queryForObject("select count(*) from students where sno=? and sname = ?", Integer.class, student.getSno(), student.getName());
            if(result == 0) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    @Override
    public int addUser(Student student) {
        int result = jdbc.update("insert into students(sno,sname) values(?,?)" , student.getSno(),student.getName());
        return result;
    }

    
}