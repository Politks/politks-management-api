package br.com.politks.controller;

import br.com.politks.dto.ElectionDTO;
import br.com.politks.dto.ElectionRequestDTO;
import br.com.politks.dto.PaginationResponse;
import br.com.politks.service.ElectionService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/elections")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ElectionController {
    private final ElectionService service;

    public ElectionController(ElectionService service) {
        this.service = service;
    }

    @GET
    public Response getAll(@QueryParam("page") @DefaultValue("0") int page, 
                          @QueryParam("size") @DefaultValue("10") int size) {
        var elections = service.findAllPaginated(page, size);
        var totalElements = service.count();
        var paginationResponse = new PaginationResponse<>(elections, page, size, totalElements);
        return Response.ok(paginationResponse).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

    @POST
    @Transactional
    public Response create(ElectionRequestDTO requestDTO) {
        return Response.status(Response.Status.CREATED)
            .entity(service.createFromRequest(requestDTO))
            .build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, ElectionRequestDTO requestDTO) {
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