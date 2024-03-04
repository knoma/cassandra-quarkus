package com.knoma.pojo;


import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;


import java.util.UUID;

@Entity(defaultKeyspace = "cass_drop")
public record Person(UUID id, String firstName, String lastName, String email) {
    @PartitionKey
    public UUID id() {
        return id;
    }
}