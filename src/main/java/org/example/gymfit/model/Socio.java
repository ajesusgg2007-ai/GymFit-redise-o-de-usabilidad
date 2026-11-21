package org.example.gymfit.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Socio {

    Estado estado;
    String id;
    String nombre;
    String apellido1;
    String apellido2;
    LocalDate fechaNacimiento;
    Sexo sexo;
    String provincia;
    Cuota cuota;
    String clases;
    String iban;
    LocalDate vencimiento;
    Situacion situacion;


    private static final int DIAS_AVISO_VENCIMIENTO = 7;

    public Socio(String nombre, String apellidos, LocalDate fechaNacimiento, Sexo sexo,
                 String provincia, Cuota cuota, String clases, String iban) {
        this.nombre = nombre;

        // Divide los apellidos en apellido1 y apellido2 si vienen separados por espacio
        if (apellidos != null && !apellidos.isBlank()) {
            String[] partes = apellidos.trim().split("\\s+", 2);
            this.apellido1 = partes[0];
            this.apellido2 = partes.length > 1 ? partes[1] : "";
        }

        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.provincia = provincia;
        this.cuota = cuota;
        this.clases = clases;
        this.iban = iban;

        // Valores por defecto para que no sean null al abrir la ficha de detalle
        this.estado = Estado.ACTIVO;
        this.situacion = Situacion.AL_CORRIENTE;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public String getProvincia() {
        return provincia;
    }

    public Cuota getCuota() {
        return cuota;
    }

    public String getClases() {
        return clases;
    }

    public String getIban() {
        return iban;
    }

    public LocalDate getVencimiento() {
        return vencimiento;
    }

    public Situacion getSituacion() {
        return situacion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }

    public void setClases(String clases) {
        this.clases = clases;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setVencimiento(LocalDate vencimiento) {
        this.vencimiento = vencimiento;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setSituacion(Situacion situacion) {
        this.situacion = situacion;
    }

    public String nombreCompleto() {
        return Stream.of(nombre, apellido1, apellido2)
                .filter(parte -> parte != null && !parte.isBlank())
                .collect(Collectors.joining(" "));
    }


    public int edad(LocalDate hoy) {
        return Period.between(fechaNacimiento, hoy).getYears();
    }


}
