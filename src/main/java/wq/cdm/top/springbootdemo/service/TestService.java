package wq.cdm.top.springbootdemo.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wq.cdm.top.springbootdemo.config.datasource.DatasourceConst;
import wq.cdm.top.springbootdemo.config.datasource.DatasourceRouting;
import wq.cdm.top.springbootdemo.dao.mappers.PersonMapper;
import wq.cdm.top.springbootdemo.dao.po.Person;

@Service
public class TestService {
    @Autowired
    private PersonMapper personMapper;

    @DatasourceRouting(DatasourceConst.DATASOURCE_SLAVE1)
    public Person getPerson(Person person) {
        person = personMapper.selectByPrimaryKey(person.getId());
        return person;
    }

    @DatasourceRouting(DatasourceConst.DATASOURCE_MASTER)
    @Transactional // 声明式事务
    public Person insertPerson() {
        Person person = new Person();
        person.setName(UUID.randomUUID().toString());
        personMapper.insertUseGeneratedKeys(person);
        return person;
    }
}
