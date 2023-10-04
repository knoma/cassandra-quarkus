package com.knoma;

import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;

@Mapper
public interface PersonMapper {
    @DaoFactory
    PersonDAO personDao();
}