package com.parqueadero.parqueadero.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String placa;
    //,nullable = false,updatable = false
    @Column(name="fecha_ingreso")
    private LocalDate fechaIngreso = LocalDate.now();
    //private Date fechaIngreso;
    @Column(name="hora_ingreso")

    private LocalTime horaIngreso=LocalTime.now();
    //@CreationTimestamp
    @Column(name = "hora_salida")
    private LocalTime horaSalida;
    //@CreationTimestamp
    @Column(name="fecha_salida")
    private LocalDate fechaSalida;
    @Column(name="valor_pagar")
    private long ValorApagar;
    @Column(name="fechaCalcularIngreso")
    private LocalDateTime fechaCalcuarIngreso ;
    @Column(name="fechaCalcularSalida")
    private LocalDateTime fechaCalcuarSalida ;
    public Historial() {
    }

    public Historial(String placa) {
        this.placa = placa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalTime getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(LocalTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public long getValorApagar() {
        return ValorApagar;
    }

    public void setValorApagar(long valorApagar) {
        ValorApagar = valorApagar;
    }

    public LocalDateTime getFechaCalcuarIngreso() {
        return fechaCalcuarIngreso;
    }

    public void setFechaCalcuarIngreso(LocalDateTime fechaCalcuarIngreso) {
        this.fechaCalcuarIngreso = fechaCalcuarIngreso;
    }

    public LocalDateTime getFechaCalcuarSalida() {
        return fechaCalcuarSalida;
    }

    public void setFechaCalcuarSalida(LocalDateTime fechaCalcuarSalida) {
        this.fechaCalcuarSalida = fechaCalcuarSalida;
    }
}
