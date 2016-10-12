package com.example.mariella.distribucionpolicialapp.models;

/**
 * Created by USER on 11/10/2016.
 */
public class Usuario {


    private int idUsuario;
    private Comisaria comisaria;
    private String correo;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String contrasenha;

    public Usuario() {
    }


    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(int idUsuario, Comisaria comisaria, String correo, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasenha) {
        this.idUsuario = idUsuario;
        this.comisaria = comisaria;
        this.correo = correo;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasenha = contrasenha;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Comisaria getComisaria() {
        return this.comisaria;
    }

    public void setComisaria(Comisaria comisaria) {
        this.comisaria = comisaria;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getContrasenha() {
        return this.contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }


}

