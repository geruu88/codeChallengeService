/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.amusnet.service.api;

import com.amusnet.service.model.Player;
import com.amusnet.service.model.PlayersFilter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-26T10:51:52.725404300+02:00[Europe/Sofia]")
@Validated
@Tag(name = "Players", description = "Operations related to Players")
public interface PlayersApi {

    /**
     * GET /players/{playerId} : Find player by ID
     * Returns a single player
     *
     * @param playerId ID of player to return (required)
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "getPlayerById",
        summary = "Find player by ID",
        tags = { "players" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Player.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/players/{playerId}",
        produces = { "application/json" }
    )
    ResponseEntity<Player> getPlayerById(
        @Parameter(name = "playerId", description = "ID of player to return", required = true) @PathVariable("playerId") Long playerId
    );


    /**
     * GET /players : Retrieve all the players
     * Returns all the players matching the filter
     *
     * @param playersFilter  (required)
     * @return Successful operation (status code 200)
     */
    @Operation(
        operationId = "getPlayers",
        summary = "Retrieve all the players",
        tags = { "players" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Player.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/players",
        produces = { "application/json" }
    )
    ResponseEntity<List<Player>> getPlayers(
        @NotNull @Parameter(name = "playersFilter", description = "", required = true) @Valid PlayersFilter playersFilter
    );

}
