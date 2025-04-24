package com.tallerwebi.presentacion.entrenamiento2ej1;

public class ContactoDto {

    private String nombre;
    private String email;
    private String mensajeContacto;


    public ContactoDto() {}

    public ContactoDto(String nombre, String email, String mensajeContacto) {
        this.nombre = nombre;
        this.email = email;
        this.mensajeContacto = mensajeContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMensajeContacto() {
        return mensajeContacto;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMensajeContacto(String mensajeContacto) {
        this.mensajeContacto = mensajeContacto;
    }
}
