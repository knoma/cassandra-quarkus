package org.acme;

import com.datastax.oss.driver.api.core.PagingIterable;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.mapper.annotations.*;
import org.acme.pojo.Person;

import java.util.UUID;

@Dao
public interface PersonDAO {

    @Update
    void update(Person person);

    @Select
    PagingIterable<Person> findAll();


    @Query("SELECT count(1) from cass_drop.person")
    Long countAll();

    @Query("SELECT count(1) from cass_drop.person")
    long count();

    @Select
    Person getById(UUID id);

    @Query("DELETE FROM cass_drop.person WHERE id = :id;")
    void delete(UUID id);
}