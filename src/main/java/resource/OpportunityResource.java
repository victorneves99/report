package resource;

import java.util.Date;
import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;

import dto.OpportunityDTO;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.ServerErrorException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.OpportunityService;

@Path("/api/opportunity")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OpportunityResource {

  @Inject
  OpportunityService opportunityService;

  @Inject
  JsonWebToken jsonWebToken;

  @GET
  @Path("/report")
  @RolesAllowed({ "user", "manager" })
  public List<OpportunityDTO> generateReport() {

    return opportunityService.generateOpportunityData();

  }

}
