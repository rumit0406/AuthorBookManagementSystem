package com.training;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;

public class AppConfiguration extends Configuration {
    @NotNull
    private String url, username, password;
    @JsonProperty
    public String getUrl() {
        return url;
    }
    @JsonProperty
    public void setUrl(String url) {
        this.url = url;
    }
    @JsonProperty
    public String getUsername() {
        return username;
    }
    @JsonProperty
    public void setUsername(String username) {
        this.username = username;
    }
    @JsonProperty
    public String getPassword() {
        return password;
    }
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }
}
