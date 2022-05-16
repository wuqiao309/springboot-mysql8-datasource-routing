package wq.cdm.top.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import wq.cdm.top.springbootdemo.dao.po.Person;
import wq.cdm.top.springbootdemo.service.TestService;

@RestController
public class TestController {
    @Autowired
    private TestService testService;



    @GetMapping("/test")
    public Person test() {
        Person person = testService.insertPerson();

        person = testService.getPerson(person);

        return person;
    }



}
