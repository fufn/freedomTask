package com.testTask.freedom.controller;

import com.testTask.freedom.service.impl.RatesServiceImpl;
import kz.namespace.my.rates.GetRatesRequest;
import kz.namespace.my.rates.GetRatesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class RatesEndpoint {
    private static final String NAMESPACE_URI = "http://my.namespace.kz/rates";
    private final RatesServiceImpl ratesService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRatesRequest")
    @ResponsePayload
    public GetRatesResponse getRates(@RequestPayload GetRatesRequest request) {
        return ratesService.getRatesResponse(request.getCurrencyCode());
    }
}