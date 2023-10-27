package com.example.demo.request;

import com.example.demo.models.Phones;
import com.example.demo.models.Provider;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
    @JsonProperty("user") //Para que el objeto se vea mas bonito en JSON
    private User user;
    @JsonProperty("role")
    private Role role;
    @JsonProperty("phones")
    private Phones phones;
    @JsonProperty("provider")
    private Provider provider;

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Phones getPhones() {
        return phones;
    }

    public void setPhones(Phones phones) {
        this.phones = phones;
    }
}
