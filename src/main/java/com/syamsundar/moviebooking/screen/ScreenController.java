package com.syamsundar.moviebooking.screen;

import com.syamsundar.moviebooking.screen.dto.CreateScreenRequest;
import com.syamsundar.moviebooking.screen.dto.ScreenResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/screens")
@RequiredArgsConstructor
public class ScreenController {

    private final ScreenService screenService;

    @PostMapping
    public ScreenResponse createScreen(@Valid @RequestBody CreateScreenRequest request){
        return screenService.createScreen(request);
    }
}
