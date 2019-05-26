package cn.edu.hebut.jszhang.service;

import cn.edu.hebut.jszhang.domain.Student;

public interface StudentServiceInterface {

    /**
     * 判定该学生在数据库中是否存在，存在返回1，不存在返回0，学号存在但姓名不匹配返回-1
     * @param student
     * @return
     */
    public int checkStudent(Student student);

    public int addStudent(Student student);
}