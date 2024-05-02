package com.test.crud.services;

import com.test.crud.model.Student;
import com.test.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public Student update(Long id, Student studentDetails) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (!studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setName(studentDetails.getName());
            return studentRepository.save(student);
        }
        return null;
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
