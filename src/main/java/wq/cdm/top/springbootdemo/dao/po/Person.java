package wq.cdm.top.springbootdemo.dao.po;

import javax.persistence.Id;

import lombok.Data;

@Data
public class Person {
    @Id
    private Long id;

    private String name;

}
