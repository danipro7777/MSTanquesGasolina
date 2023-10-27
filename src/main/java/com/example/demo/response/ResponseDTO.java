package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseDTO {
    @JsonProperty("response")
    private String response;

    @JsonProperty("provider")
    private ProviderResponse provider;

    public ProviderResponse getProvider() {
        return provider;
    }

    public void setProvider(ProviderResponse provider) {
        this.provider = provider;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
