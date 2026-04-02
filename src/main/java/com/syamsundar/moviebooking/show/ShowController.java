package com.syamsundar.moviebooking.show;

import com.syamsundar.moviebooking.show.dto.CreateShowRequest;
import com.syamsundar.moviebooking.show.dto.ShowResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    @PostMapping
    public ShowResponse createShow(@Valid @RequestBody CreateShowRequest request){
        return showService.createShow(request);
    }
}
