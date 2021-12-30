package org.youcode.foracademy.interfaces;


import org.youcode.foracademy.models.Student;

import java.util.List;

public interface StudentDao {
    boolean delete(long id);
    List<Student> findAll();
    Student findById(long id);
    Student insert(Student student);
    Student update(Student student);

}
