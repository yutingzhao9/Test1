package com.example.test1.controller;

import com.example.test1.domain.Add;
import com.example.test1.domain.Results;
import com.example.test1.domain.Student;
import com.example.test1.service.impl.StudentServiceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuting.zhao
 */
@RestController
public class StudentController {
    @Resource
    StudentServiceImpl studentService;
    @GetMapping("/get")
    public List<Student> getInformation(@RequestParam String studentName,
                                        @RequestParam String studentSex,
                                        @RequestParam String teacherId){
        return studentService.get(studentName,studentSex,teacherId);
    }
    @GetMapping("/getResults")
    public List<Results> getResults(@RequestParam String studentName,
                                    @RequestParam String subjectId,
                                    @RequestParam String resultsType,
                                    @RequestParam String teacherId){
        return studentService.getResults(studentName,subjectId,resultsType,teacherId);
    }
    @PostMapping("/addResults")
    public int addResults(@RequestBody Add add){
        return studentService.saveResults(add);
    }
    @DeleteMapping("deleteTeacher/{id}")
    public void deleteTeacherInformation(@PathVariable("id") String teacherId){
        studentService.deleteTeacher(teacherId);
    }
    @PutMapping("/update")
    public void updateInformation(@RequestParam String className,
                                 @RequestParam String studentId) throws NotFoundException {
        studentService.updateClassName(className,studentId);
    }
}
