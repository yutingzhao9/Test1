package com.example.test1.service;

import com.example.test1.domain.Add;
import com.example.test1.domain.Results;
import com.example.test1.domain.Student;
import java.util.List;

/**
 * @author yuting.zhao
 */
public interface StudentService {
    /**
     * 功能：查询学生姓名，年龄，性别，出生年月，座位号，身高，体重，老师姓名，学校名称，所属班级
     * @param studentName studentName
     * @param studentSex studentSex
     * @param  teacherId teacherId
     * @return List<Student>
     */
    List<Student> get(String studentName, String studentSex, String teacherId);

    /**
     * 功能：查询学生姓名，成绩，学科名称，考试类型，老师名称，班级名称
     * @param studentName studentName
     * @param subjectId subjectId
     * @param resultsType resultsType
     * @param teacherId teacherId
     * @return List<Results>
     */
    List<Results> getResults(String studentName, String subjectId, String resultsType, String teacherId);

    /**
     * 功能：插入数据
     * @param add add
     * @return int
     */
    int saveResults(Add add);

    /**
     * 功能：删除老师
     * @param teacherId teacherId
     * @return int
     */
    void deleteTeacher(String teacherId);

    /**
     * 功能：修改学生的班级信息
     * @param className className
     * @param studentId studentId
     * @return int
     */
    void updateClassName(String className,String studentId) throws Exception;
}
