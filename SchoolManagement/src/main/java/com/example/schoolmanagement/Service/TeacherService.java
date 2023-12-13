package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.ApiException.ApiException;
import com.example.schoolmanagement.Model.Address;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.AddressRepository;
import com.example.schoolmanagement.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;
    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public void updateTeacher(Integer id,Teacher teacher){
        Teacher oldTeacher=teacherRepository.findTeacherById(id);
        if (oldTeacher == null) {
            throw new ApiException("the teacher not found");
        }
        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldTeacher);
    }
    public void deleteTeacher(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if ( teacher == null) {
            throw new ApiException("the teacher not found");
        }
        teacherRepository.delete(teacher);
    }
    public Teacher searchTeacher(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if ( teacher == null) {
            throw new ApiException("the teacher not found");
        }
        return teacher;
    }
    public Address check(Integer number){
//        Teacher teacher=teacherRepository.findTeacherById(number);
        Address address=addressRepository.findAddressById(number);
//        Address q = teacher.getAddress();
        if ( address == null) {
            throw new ApiException("the teacher not found");
        }
        return address;
    }
}
