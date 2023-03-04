package org.acme;

import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.session.Session;
import com.datastax.oss.quarkus.runtime.api.session.QuarkusCqlSession;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/cassandra")
public class CassandraResource {

    @Inject
    QuarkusCqlSession session;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> hello() {

        ResultSet execute = session.execute("SELECT cql_version FROM system.local;");
        return Map.of("version", execute.one().getString(0));
    }
}