package com.example.codingchallenge.exception;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 404:
                throw new ExternalApiException("Resource not found in the external API");
            case 405:
                throw new ExternalApiException("Method Not Allowed in the external API");
            case 500:
                throw new ExternalApiException("Internal server error in the external API");
        }

        return FeignException.errorStatus(methodKey, response);
    }
}
