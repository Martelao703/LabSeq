package com.david.labseq.resource;

import com.david.labseq.service.LabSeqService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import static com.david.labseq.service.LabSeqService.MAX_N;


@Path("/labseq")
@Produces(MediaType.APPLICATION_JSON)
public class LabSeqResource {

    @Inject
    LabSeqService labSeqService;

    @GET
    @Path("/{n}")
    @Operation(summary = "Get l(n)", description = "Get labseq value at index n (0 ≤ n ≤ " + MAX_N + ")")
    @APIResponse(
            responseCode = "200",
            description = "The sequence value as an integer",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(type = SchemaType.INTEGER))
    )
    @APIResponse(
            responseCode = "400",
            description = "Invalid index (must be 0 ≤ n ≤ " + MAX_N + ")",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(type = SchemaType.STRING))
    )
    public Response getLabSeqValue(
            @Parameter(
                    description = "Sequence index n (integer, 0 ≤ n ≤ " + MAX_N + ")",
                    required = true
            )
            @PathParam("n") int n) {
        return Response.ok(labSeqService.getLabSeq(n)).build();
    }
}
