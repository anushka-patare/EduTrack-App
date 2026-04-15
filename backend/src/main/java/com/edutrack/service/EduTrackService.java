package com.edutrack.service;

import com.edutrack.model.Batch;
import com.edutrack.model.Student;
import com.edutrack.repository.BatchRepository;
import com.edutrack.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduTrackService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BatchRepository batchRepository;

    // Student Operations
    public Student saveStudent(Student student) { return studentRepository.save(student); }
    public List<Student> getAllStudents() { return studentRepository.findAll(); }
    public void deleteStudent(String id) { studentRepository.deleteById(id); }
    public Student getStudentById(String id) { return studentRepository.findById(id).orElse(null); }

    // Batch Operations
    public Batch saveBatch(Batch batch) { return batchRepository.save(batch); }
    public List<Batch> getAllBatches() { return batchRepository.findAll(); }
    public Batch getBatchById(String id) { return batchRepository.findById(id).orElse(null); }
    public void deleteBatch(String id) { batchRepository.deleteById(id); }
}
