package com.parqueadero.parqueadero.model;






import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class Vehiculo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String placa;
    @Column(name="fecha_ingreso")
    private LocalDate fechaIngreso = LocalDate.now();
    @Column(name="hora_ingreso")
    private LocalTime horaIngreso=LocalTime.now();
    @Column(name = "hora_salida")
    private LocalTime horaSalida;
    @Column(name="fecha_salida")
    private LocalDate fechaSalida;
    @Column(name="valor_pagar")
    private long valorApagar;
    @Column(name="fechaCalcularIngreso")
    private LocalDateTime fechaCalcuarIngreso = LocalDateTime.now();
    @Column(name="fechaCalcularSalida")
    private LocalDateTime fechaCalcuarSalida ;









    public Vehiculo() {
    }

    public Vehiculo(String placa) {
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
        return valorApagar;
    }

    public void setValorApagar(long valorApagar) {
        this.valorApagar = valorApagar;
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
