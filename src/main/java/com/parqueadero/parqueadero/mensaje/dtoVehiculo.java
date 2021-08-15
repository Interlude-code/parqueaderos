package com.parqueadero.parqueadero.mensaje;

import com.sun.istack.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class dtoVehiculo {
    @NotNull
    private String placa;
    //,nullable = false,updatable = false
    private LocalDateTime fechaIngreso = LocalDateTime.now();
    private LocalTime horaIngreso;
    private LocalTime horaSalida;
    private LocalDate fechaSalida;
    private long valorApagar;
    private LocalDateTime fechaCalcuarIngreso ;
    private LocalDateTime fechaCalcuarSalida ;

    public dtoVehiculo() {
    }

    public dtoVehiculo(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
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
        return valorApagar;
    }

    public void setValorApagar(Long valorApagar) {
        this.valorApagar = valorApagar;
    }

}
