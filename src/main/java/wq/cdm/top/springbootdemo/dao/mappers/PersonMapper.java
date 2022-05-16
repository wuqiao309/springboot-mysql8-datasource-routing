package wq.cdm.top.springbootdemo.dao.mappers;

import org.apache.ibatis.annotations.Mapper;

import wq.cdm.top.springbootdemo.dao.BaseMapper;
import wq.cdm.top.springbootdemo.dao.po.Person;

@Mapper
public interface PersonMapper extends BaseMapper<Person> {
}
