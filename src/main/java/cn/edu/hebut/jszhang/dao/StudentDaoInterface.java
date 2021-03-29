package cn.edu.hebut.jszhang.dao;

import cn.edu.hebut.jszhang.domain.Student;

/**
 * StudentDaoInterface
 */
public interface StudentDaoInterface {
    public int userExists(Student student);
    public int addUser(Student student);
    
}