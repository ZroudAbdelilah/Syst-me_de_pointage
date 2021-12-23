package org.youcode.foracademy.services;

import org.youcode.foracademy.dao.studentDao.StudentDao;

import org.youcode.foracademy.models.Student;

import java.util.List;

public class StudentService {
    private StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    public Student findById(long id){
        return studentDao.findById(id);
    }
    public List<Student> findAll(){
        return studentDao.findAll();
    }
    public boolean delete(long id){
        return studentDao.delete(id);
    }
    public Student insert(Student student){
        return studentDao.insert(student);
    }
    public Student update(Student student){
        return studentDao.insert(student);
    }
}
