package cn.edu.hebut.jszhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hebut.jszhang.dao.StudentDaoInterface;
import cn.edu.hebut.jszhang.domain.Student;
import cn.edu.hebut.jszhang.service.StudentServiceInterface;

/**
 * StudentServiceInterfaceImpl
 */
@Service
public class StudentServiceInterfaceImpl implements StudentServiceInterface {

    @Autowired
    StudentDaoInterface studentDao;

    @Override
    public int checkStudent(Student student) {
        return studentDao.userExists(student);
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.addUser(student);
    }

    
}