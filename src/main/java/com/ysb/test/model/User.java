package com.ysb.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Data
@Repository
public class User implements Serializable {
    private Integer id;
    private String name;
}
