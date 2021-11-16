package com.dataelicit.sw.universalendpoint.auth.dto;

public class JwtOauth2ResponseDto {
    private String accessToken;
    private String refreshToken;

    private JwtOauth2ResponseDto() {
        this.accessToken ="";
        this.refreshToken = "";
    }

    public JwtOauth2ResponseDto(final String accessToken, final String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }

    public void setRefreshToken(final String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

}

