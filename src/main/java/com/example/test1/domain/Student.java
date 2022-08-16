package com.example.test1.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yuting.zhao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private String studentName;
    private String studentAge;
    private String studentSex;
    private Date studentBirthday;
    private Integer studentSeatNumber;
    private String studentHigh;
    private String studentWeight;
    private String className;
    private String schoolName;
    private String teacherName;
}
