package com.example.test1.service.impl;

import com.example.test1.domain.Add;
import com.example.test1.domain.Results;
import com.example.test1.domain.Student;
import com.example.test1.mapper.StudentMapper;
import com.example.test1.service.StudentService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yuting.zhao
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;
    @Override
    public List<Student> get(String studentName, String studentSex, String teacherId){
        return studentMapper.get(studentName,studentSex,teacherId);
    }
    @Override
    public List<Results> getResults(String studentName, String subjectId, String resultsType, String teacherId){
        return studentMapper.getResults(studentName,subjectId,resultsType,teacherId);
    }
    @Override
    public int saveResults(Add add){
        return studentMapper.saveResults(add);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTeacher(String teacherId){
        System.out.println();
        //1、根据id删除老师
        studentMapper.deleteTeacher(teacherId);
        //2、根据创建日期挑选出资历最老教师id
        String teacherId1 = studentMapper.getTeacherId();
        //3、两表联查，根据老师ID找出删除老师下的学生id
        List<String> studentIds = studentMapper.getStudentIds(teacherId);
        //4、将资历最老的老师id放在第三步挑选出来的学生id的学生表中
        studentMapper.updateTeacherIdByStudentIds(studentIds,teacherId1);
        //5、根据学生id将老师id修改成绩列表
        studentMapper.updateTeacherId(studentIds,teacherId1);
    }
    @Override
    public void updateClassName(String className,String studentId) throws NotFoundException {
        //1、根据班级姓名查询条数
        int count = studentMapper.getCount(className);
        //2、判断是否为空，如果是空，抛出异常
        if(count==0){
            throw new NotFoundException("该班级不存在");
        }
        //3、如果不是空，根据班级姓名查询teacherid
        String teacherIdByClassName = studentMapper.getTeacherIdByClassName(className);
        //4、根据studentid修改student表的teacherid
        int i = studentMapper.updateTeacherIdByStudentId(studentId,teacherIdByClassName);
        //5、根据studentid修改results表的teacherid
        studentMapper.updateTeacherIdByStudent(studentId,teacherIdByClassName);
    }
}
