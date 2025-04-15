package br.com.politks.controller;

import br.com.politks.dto.ElectionDTO;
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
    public Response getAll() {
        return Response.ok(service.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

    @POST
    @Transactional
    public Response create(ElectionDTO dto) {
        return Response.status(Response.Status.CREATED)
            .entity(service.create(dto))
            .build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, ElectionDTO dto) {
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