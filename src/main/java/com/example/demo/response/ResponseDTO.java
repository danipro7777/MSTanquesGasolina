package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseDTO {
    @JsonProperty("response")
    private String response;
    @JsonProperty("role")
    private RoleResponse role;
    @JsonProperty("user")
    private UserResponse user;

    @JsonProperty("phones")
    private PhonesResponse phones;

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

    public RoleResponse getRole() {
        return role;
    }

    public void setRole(RoleResponse role) {
        this.role = role;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public PhonesResponse getPhones() {
        return phones;
    }

    public void setPhones(PhonesResponse phones) {
        this.phones = phones;
    }
}
