package resource;

import java.util.Date;

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
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OpportunityResource {

  @Inject
  OpportunityService opportunityService;

  @GET
  @Path("/report")
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public Response generateReport() {

    try {

      return Response.ok(opportunityService.generateOpportunityData(), MediaType.APPLICATION_OCTET_STREAM)
          .header("content-disposition", "attachment; filename = " + new Date() + "--opportunity-venda.csv").build();

    } catch (ServerErrorException e) {

      return Response.serverError().build();

    }

  }

}
