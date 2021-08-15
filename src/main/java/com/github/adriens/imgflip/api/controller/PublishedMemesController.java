/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.imgflip.api.controller;

import com.github.adriens.imgflip.api.service.PublishedMemesService;
import com.github.adriens.imgflip.sdk.imgflip.sdk.PublishedMeme;
import java.io.IOException;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author 3004SAL
 */
@RestController
@Tag(name = "Published memes", description = "Published memes related resources")
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class PublishedMemesController {

    @Autowired
    private PublishedMemesService publishedMemesService;

    @GetMapping("/hot/{stream}")
    @Operation(summary = "Get the hottest memes by stream",
            description = "Meme's list (page) for a given stream and page number.")
    public List<PublishedMeme> getMemes(
            @Parameter(description = "Stream name", example = "gaming") @PathVariable String stream,
            @Parameter(description = "Page number") @RequestParam(value="page", defaultValue = "1") int page) throws IOException{
        return publishedMemesService.getPageOfHotStream(stream,page);
    }

    @GetMapping("/hot")
    @Operation(summary = "Get the default hottest memes",
            description = "Meme's list (page) for a given page number.")
    public List<PublishedMeme> getMemes(
            @Parameter(description = "Page number") @RequestParam(value="page", defaultValue = "1") int page) throws IOException{
        return publishedMemesService.getPageOfHotStream(page);
    }

    @GetMapping("/top/{stream}/last/1d")
    @Operation(summary = "Get the top memes since last day for a stream",
            description = "Top meme's list (page) since last day for a stream and given page number.")
    public List<PublishedMeme> getTop1d(
            @Parameter(description = "Stream name", example = "gaming") @PathVariable String stream,
            @Parameter(description = "Page number") @RequestParam(value="page", defaultValue = "1") int page) throws IOException{
        return publishedMemesService.getTopOneDayPageOfHotStream(stream, page);
    }

    @GetMapping("/top/{stream}/last/7d")
    @Operation(summary = "Get the top memes since last 7 days for a stream",
            description = "Top meme's list (page) since 7 last days for a stream and given page number.")
    public List<PublishedMeme> getTop7d(
            @Parameter(description = "Stream name", example = "gaming") @PathVariable String stream,
            @Parameter(description = "Page number") @RequestParam(value="page", defaultValue = "1") int page) throws IOException{
        return publishedMemesService.getTopSevenDayPageOfHotStream(stream, page);
    }

    @GetMapping("/top/{stream}/last/30d")
    @Operation(summary = "Get the top memes since last 30 days for a stream",
            description = "Top meme's list (page) since 30 last days for a stream and given page number.")
    public List<PublishedMeme> getTop30d(
            @Parameter(description = "Stream name", example = "gaming") @PathVariable String stream,
            @Parameter(description = "Page number") @RequestParam(value="page", defaultValue = "1") int page) throws IOException{
        return publishedMemesService.getTopThirtyDayPageOfHotStream(stream, page);
    }

    @GetMapping("/top/{stream}/last/month")
    @Operation(summary = "Get the top memes since last month for a stream",
            description = "Top meme's list (page) since last month for a stream and given page number.")
    public List<PublishedMeme> getTopLastMonth(
            @Parameter(description = "Stream name", example = "gaming") @PathVariable String stream,
            @Parameter(description = "Page number") @RequestParam(value="page", defaultValue = "1") int page) throws IOException{
        return publishedMemesService.getTopLastMonthPageOfHotStream(stream, page);
    }
    
    @GetMapping("/top/{stream}/last/year")
    @Operation(summary = "Get the top memes since last year for a stream",
            description = "Top meme's list (page) since last year for a stream and given page number.")
    public List<PublishedMeme> getTopLastYear(
            @Parameter(description = "Stream name", example = "gaming") @PathVariable String stream,
            @Parameter(description = "Page number") @RequestParam(value="page", defaultValue = "1") int page) throws IOException{
        return publishedMemesService.getTopLastYearPageOfHotStream(stream, page);
    }
    

    @GetMapping("/top/{stream}/query")
    @Operation(summary = "Get the top memes for a specific year and/or month and stream",
            description = "Top meme's list (page) for a specific year and/or month and stream and given page number.")
    public List<PublishedMeme> getTopLastYear(@PathVariable String stream,
            @RequestParam(value="year", defaultValue = "0") int year,
            @RequestParam(value="month", defaultValue = "0") int month,
            @Parameter(description = "Page number") @RequestParam(value="page", defaultValue = "1") int page) throws IOException{

        if (year == 0) {
            // return default year
            return publishedMemesService.getTopDefaultYearHotStream(stream, page);
        } else {
            // we got a year
            if (month == 0) {
                // return default year
                return publishedMemesService.getTopDefaultYearHotStream(stream, page);
            } else {
                // we got a month
                return publishedMemesService.getTopYearMonthHotStream(stream, year, month, page);
            }
        }
    }
}
