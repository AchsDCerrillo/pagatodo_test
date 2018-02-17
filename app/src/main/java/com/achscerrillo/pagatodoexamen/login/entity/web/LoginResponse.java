package com.achscerrillo.pagatodoexamen.login.entity.web;

/**
 * Created by alejandrocerrillo on 17/02/18.
 */

public class LoginResponse {
    String agente;
    Error error;
    String id_user;
    String token;

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "agente='" + agente + '\'' +
                ", error='" + error + '\'' +
                ", id_user='" + id_user + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
