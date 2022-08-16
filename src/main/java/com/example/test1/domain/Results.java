package com.example.test1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yuting.zhao
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Results {
    private String studentName;
    private String teacherId;
    private String teacherName;
    private String className;
    private String studentResults;
    private String resultsType;
    private String subjectId;
    private String subjectName;
}
