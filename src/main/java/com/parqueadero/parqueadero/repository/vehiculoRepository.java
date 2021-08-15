package com.parqueadero.parqueadero.repository;

import com.parqueadero.parqueadero.model.Vehiculo;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface vehiculoRepository extends JpaRepository <Vehiculo,Long> {
    void deleteVehiculoById(Long id);
    Optional<Vehiculo> findByPlaca(String placa);
    boolean existsByPlaca(String Placa);


}
