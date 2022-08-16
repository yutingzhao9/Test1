package com.example.test1.mapper;

import com.example.test1.domain.Add;
import com.example.test1.domain.Results;
import com.example.test1.domain.Student;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yuting.zhao
 */
@Mapper
public interface StudentMapper {
    /**
     * 功能：查询学生姓名，年龄，性别，出生年月，座位号，身高，体重，老师姓名，学校名称，所属班级
     *
     * @param studentName studentName
     * @param studentSex  studentSex
     * @param teacherId   teacherId
     * @return Student
     */
    List<Student> get(@Param("studentName") String studentName, @Param("studentSex") String studentSex,
                      @Param("teacherId") String teacherId);

    /**
     * 功能：查询学生姓名，成绩，学科名称，考试类型，老师名称，班级名称
     *
     * @param studentName studentName
     * @param subjectId   subjectId
     * @param resultsType resultsType
     * @param teacherId   teacherId
     * @return List<Results>
     */
    List<Results> getResults(@Param("studentName") String studentName, @Param("subjectId") String subjectId,
                             @Param("resultsType") String resultsType, @Param("teacherId") String teacherId);

    /**
     * 功能：插入数据
     *
     * @param add add
     * @return String
     */
    int saveResults(@Param("add") Add add);

    /**
     * 功能：删除老师
     *
     * @param teacherId teacherId
     * @return int
     */
    int deleteTeacher(@Param("teacherId") String teacherId);

    /**
     * 功能：获得teacherId
     * @return String
     */
    String getTeacherId();

    /**
     * 功能：获取一个老师的所有学生的学生id
     * @param teacherId teacherId
     * @return List<String>
     */
    List<String> getStudentIds(String teacherId);

    /**
     * 功能：修改老师id
     * @param studentIds studentIds
     * @param teacherId teacherId
     * @return int
     */
    int updateTeacherIdByStudentIds(List<String> studentIds, String teacherId);

    /**
     * 功能：修改老师id
     * @param studentIds studentIds
     * @param teacherId teacherId
     * @return int
     */
    int updateTeacherId(List<String> studentIds, String teacherId);


    /**
     * 功能：修改班级姓名
     * @param className className
     * @param teacherId teacherId
     * @param studentId studentId
     */
    void updateClassName(@Param("className") String className, @Param("teacherId") String teacherId,
                         @Param("studentId") String studentId);
    /**
     * 功能：修改学生的班级信息
     * @param className className
     * @return int
     */
    int getCount(String className);

    /**
     * 功能：挑选出老师id
     * @param className className
     * @return String
     */
    String getTeacherIdByClassName(String className);

    /**
     * 功能：修改老师id
     * @param studentId studentId
     * @param teacherId teacherId
     * @return
     */
    int updateTeacherIdByStudentId(String studentId, String teacherId);

    /**
     * 功能：修改老师id
     * @param studentId studentId
     * @param teacherId teacherId
     * @return int
     */
    int updateTeacherIdByStudent(String studentId, String teacherId);
}
