/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.imgflip.api.controller;

import com.github.adriens.imgflip.api.service.StreamService;
import com.github.adriens.imgflip.sdk.imgflip.sdk.domain.PopularStream;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author 3004SAL
 */
@RestController
@Tag(name = "Streams", description = "Streams related resources")
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class StreamsController {

    private final Logger log = LoggerFactory.getLogger(StreamsController.class);

    private final StreamService streamService;

    public StreamsController(StreamService streamService) {
        this.streamService = streamService;
    }

    @GetMapping(value = "streams/popular")
    @Operation(summary = "Get the top popular streams",
            description = "Popular streams' list, include Not Safe For Work or not (not by default).")
    public List<PopularStream> getPopularStreams(
            @Parameter(description = "include NSFW streams") @RequestParam(value="includeNSFW", defaultValue = "false") Boolean includeNSFW) throws IOException {
        log.debug("GET getPopularStreams request with includeNSFW=[{}]", includeNSFW);

        return streamService.getPopularStreams(includeNSFW);
    }

    @GetMapping(value = "streams/popular/nsfw")
    @Operation(summary = "Get the top NSFW popular streams",
            description = "NSFW popular streams' list only.")
    public List<PopularStream> getPopularNSFWStreams() throws IOException {
        log.debug("GET getPopularNSFWStreams request");

        return streamService.getPopularNSFWStreams();
    }
    
}
