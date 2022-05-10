package ru.thirteenth.kryptohouse.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.thirteenth.kryptohouse.service.impl.ToRubConverterServiceCbrImpl;

@RestController
@RequestMapping("/api-v1/cbr")
@Tag(name = "CBR-Daily-controller")
public class CbrDailyController {

    private final ToRubConverterServiceCbrImpl toRubService;

    @Autowired
    public CbrDailyController(ToRubConverterServiceCbrImpl toRubService) {
        this.toRubService = toRubService;
    }

    @Operation(summary = "Converts the specified currency into RUB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})

    @GetMapping(value = "/{targetCurrency}")
    public double toRubConvert(@PathVariable String targetCurrency) {
        return toRubService.toRubConvert(targetCurrency);
    }
}
