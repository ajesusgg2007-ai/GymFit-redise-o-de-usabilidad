package org.example.gymfit.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Socio {

    Estado Estado;
    String id;
    String nombre;
    String apellido1;
    String apellido2;
    LocalDate fechaNacimiento;
    Sexo sexo;
    Provincia provincia;
    Cuota cuota;
    List<String> clases;
    String iban;
    LocalDate vencimiento;
    Situacion situacion;


    private static final int DIAS_AVISO_VENCIMIENTO = 7;

    public Socio(String id, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, Sexo sexo, Provincia provincia, Cuota cuota, List<String> clases, String iban, LocalDate vencimiento, Estado estado,Situacion situacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.provincia = provincia;
        this.cuota = cuota;
        this.clases = clases;
        this.iban = iban;
        this.vencimiento = vencimiento;
        this.Estado = estado;
        this.situacion=situacion;
    }

    public Estado getEstado() {
        return Estado;
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

    public Provincia getProvincia() {
        return provincia;
    }

    public Cuota getCuota() {
        return cuota;
    }

    public List<String> getClases() {
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

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }

    public void setClases(List<String> clases) {
        this.clases = clases;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setVencimiento(LocalDate vencimiento) {
        this.vencimiento = vencimiento;
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
