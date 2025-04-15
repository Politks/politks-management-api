package org.acme.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.PoliticianDTO;
import org.acme.service.PoliticianService;

@Path("api/politician")
public class PoliticianController {
  private final PoliticianService service;

  public PoliticianController(PoliticianService service) {
    this.service = service;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAll() {
    return Response.ok(service.findAll()).build();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public Response create(PoliticianDTO politicianDTO) {
    try {
      return Response.created(null).entity(service.createNewCustomer(politicianDTO)).build();
    } catch (Exception e) {
      return Response.serverError().entity(e.getMessage()).build();
    }
  }

  @PUT
  @Path("/{id}")
  @Transactional
  @Produces(MediaType.APPLICATION_JSON)
  public Response update(@PathParam("id") Long id, PoliticianDTO politicianDTO) {
    try {
      return Response.accepted(service.update(id, politicianDTO)).build();
    } catch (Exception e) {
      return Response.serverError().entity(e.getMessage()).build();
    }
  }

  @DELETE
  @Path("/{id}")
  @Transactional
  public Response delete(@PathParam("id") Long id) {
    try {
      service.delete(id);
      return Response.noContent().build();
    } catch (Exception e) {
      return Response.serverError().entity(e.getMessage()).build();
    }
  }
}
