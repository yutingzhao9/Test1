package com.example.test1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yuting.zhao
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Update {
    private String className;
    private String teacherId;
    private String studentId;
}
