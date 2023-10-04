package com.knoma;

import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.quarkus.runtime.api.session.QuarkusCqlSession;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


import java.util.Map;

@Path("/cassandra")
public class CassandraResource {

    @Inject
    QuarkusCqlSession session;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> hello() {

        ResultSet execute = session.execute("SELECT release_version FROM system.local;");
        return Map.of("version", execute.one().getString(0));
    }
}