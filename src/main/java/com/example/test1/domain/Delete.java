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
public class Delete {
    private String teacherName;
    private String teacherId;
}
