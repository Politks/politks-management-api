package br.com.politks.controller;

import br.com.politks.dto.CandidateRequestDTO;
import br.com.politks.dto.PaginationResponse;
import br.com.politks.service.CandidateService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/candidates")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CandidateController {
  private final CandidateService service;

  public CandidateController(CandidateService service) {
    this.service = service;
  }

  @GET
  public Response getAll(
      @QueryParam("page") @DefaultValue("0") int page,
      @QueryParam("size") @DefaultValue("10") int size) {
    var candidates = service.findAllPaginated(page, size);
    var totalElements = service.count();
    var paginationResponse = new PaginationResponse<>(candidates, page, size, totalElements);
    return Response.ok(paginationResponse).build();
  }

  @GET
  @Path("/{id}")
  public Response getById(@PathParam("id") Long id) {
    return Response.ok(service.findById(id)).build();
  }

  @POST
  @Transactional
  public Response create(CandidateRequestDTO requestDTO) {
    return Response.status(Response.Status.CREATED)
        .entity(service.createFromRequest(requestDTO))
        .build();
  }

  @PUT
  @Path("/{id}")
  @Transactional
  public Response update(@PathParam("id") Long id, CandidateRequestDTO requestDTO) {
    return Response.ok(service.updateFromRequest(id, requestDTO)).build();
  }

  @DELETE
  @Path("/{id}")
  @Transactional
  public Response delete(@PathParam("id") Long id) {
    service.delete(id);
    return Response.noContent().build();
  }
}
