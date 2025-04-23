package br.com.politks.controller;

import br.com.politks.dto.PaginationResponse;
import br.com.politks.dto.PoliticianDTO;
import br.com.politks.dto.PoliticianRequestDTO;
import br.com.politks.service.PoliticianService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/politicians")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PoliticianController {
    private final PoliticianService service;

    public PoliticianController(PoliticianService service) {
        this.service = service;
    }

    @GET
    public Response getAll(@QueryParam("page") @DefaultValue("0") int page, 
                          @QueryParam("size") @DefaultValue("10") int size) {
        var politicians = service.findAllPaginated(page, size);
        var totalElements = service.count();
        var paginationResponse = new PaginationResponse<>(politicians, page, size, totalElements);
        return Response.ok(paginationResponse).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

    @POST
    @Transactional
    public Response create(PoliticianRequestDTO requestDTO) {
        return Response.status(Response.Status.CREATED)
            .entity(service.createFromRequest(requestDTO))
            .build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, PoliticianDTO dto) {
        return Response.ok(service.update(id, dto)).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
