package com.parqueadero.parqueadero.controller;


import com.parqueadero.parqueadero.model.Vehiculo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.parqueadero.parqueadero.services.vehiculoServices;
import com.parqueadero.parqueadero.mensaje.Mensaje;
import com.parqueadero.parqueadero.mensaje.dtoVehiculo;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/vehiculo" )
@CrossOrigin(origins = "http://localhost:4200")
public class VehiculoController {
    private final vehiculoServices vehiculoServices;

    public VehiculoController(vehiculoServices vehiculoServices) {
        this.vehiculoServices = vehiculoServices;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Vehiculo>> list(){
        List<Vehiculo> list = vehiculoServices.findAllVehiculos();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Vehiculo> getById(@PathVariable("id") Long id){
        if(!vehiculoServices.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Vehiculo vehiculo = vehiculoServices.findVehiculoById(id);
        return new ResponseEntity(vehiculo, HttpStatus.OK);
    }

    @GetMapping("/detailname/{placa}")
    public ResponseEntity<Vehiculo> getByNombre(@PathVariable("placa") String placa){
        if(!vehiculoServices.existsByPlaca(placa))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
       Vehiculo vehiculo = vehiculoServices.getByPlaca(placa).get();
       return new ResponseEntity(vehiculo, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoVehiculo dtoVehiculo){
        if(StringUtils.isEmpty(dtoVehiculo.getPlaca()))
            return new ResponseEntity(new Mensaje("La placa es obligatorio"), HttpStatus.BAD_REQUEST);
        if(vehiculoServices.existsByPlaca(dtoVehiculo.getPlaca()))
            return new ResponseEntity(new Mensaje("Esa placa ya existe"), HttpStatus.BAD_REQUEST);
        if(vehiculoServices.findAllVehiculos().size()>=30)
            return new ResponseEntity(new Mensaje("Capacidad al maximo"), HttpStatus.BAD_REQUEST);
        Vehiculo vehiculo = new Vehiculo(dtoVehiculo.getPlaca());
        vehiculoServices.addVehiculo(vehiculo);
        return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
    }

    @PutMapping("/salida/{placa}")
    public ResponseEntity<?> update(@PathVariable("placa")String placa){
        if(!vehiculoServices.existsByPlaca(placa))
            return new ResponseEntity(new Mensaje("no existe la placa a modificar"), HttpStatus.NOT_FOUND);
        //if(productoService.existsByNombre(productoDto.getNombre()) && productoService.getByNombre(productoDto.getNombre()).get().getId() != id)
          //  return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Vehiculo vehiculo = vehiculoServices.getByPlaca(placa).get();
        vehiculo.setFechaSalida(LocalDate.now());
        vehiculo.setHoraSalida(LocalTime.now());
        vehiculo.setFechaCalcuarSalida(LocalDateTime.now());
        vehiculo.setValorApagar((ChronoUnit.MINUTES.between(vehiculo.getFechaCalcuarIngreso(), vehiculo.getFechaCalcuarSalida()))*100);
        vehiculoServices.addVehiculo(vehiculo);
        return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")long id){
        if(!vehiculoServices.existsById(id))
            return new ResponseEntity(new Mensaje("La placa no existe"), HttpStatus.NOT_FOUND);
        vehiculoServices.deleteVehiculo(id);
        return new ResponseEntity(new Mensaje("Vehiculo Eliminado"), HttpStatus.OK);
    }
}