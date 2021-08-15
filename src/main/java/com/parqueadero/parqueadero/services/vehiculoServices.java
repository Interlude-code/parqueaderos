package com.parqueadero.parqueadero.services;

import com.parqueadero.parqueadero.mensaje.Mensaje;
import com.parqueadero.parqueadero.model.Vehiculo;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Service;
import com.parqueadero.parqueadero.repository.vehiculoRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;


import java.util.List;

@Service
public class vehiculoServices {
    private final vehiculoRepository vehiculoRepository;

    public vehiculoServices(com.parqueadero.parqueadero.repository.vehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }


    public Vehiculo addVehiculo(Vehiculo vehiculo){

        return vehiculoRepository.save(vehiculo);

    }
    public List<Vehiculo> findAllVehiculos(){
        return vehiculoRepository.findAll();
    }
    public Vehiculo updateVehiculo(Vehiculo vehiculo){
        return vehiculoRepository.save(vehiculo);

    }
    public Optional<Vehiculo> getByPlaca(String placa){
        return vehiculoRepository.findByPlaca(placa);
    }
    public Vehiculo findVehiculoById(Long id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new Mensaje("User by id " + id + " was not found"));
    }
    public void deleteVehiculo(Long id){
        vehiculoRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return vehiculoRepository.existsById(id);
    }
    public boolean existsByPlaca(String placa){
        return vehiculoRepository.existsByPlaca(placa);
    }


}
