package com.dev.alain.Service;

import com.dev.alain.Dto.CrearAutoDto;

import com.dev.alain.Entity.DavidEntity.AutoDavid;
import com.dev.alain.Entity.LocalEntity.Auto;
import com.dev.alain.Repository.DavidRepository.DavidAutoRepository;
import com.dev.alain.Repository.LocalRepository.AlainAutoRepository;
import com.dev.alain.Repository.LocalRepository.AlainSucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService {

    @Autowired
    AlainAutoRepository alainAutoRepository;

    @Autowired
    DavidAutoRepository davidAutoRepository;

    public void ingresarAuto(CrearAutoDto crearAutoDto) {
        if (crearAutoDto.getSucursal_id() == 1) {

            Auto auto = new Auto();

            auto.setNombre(crearAutoDto.getNombre());
            auto.setModelo(crearAutoDto.getModelo());
            auto.setMarca(crearAutoDto.getMarca());
            auto.setColor(crearAutoDto.getColor());

            alainAutoRepository.save(auto);
        } else if (crearAutoDto.getSucursal_id() == 2) {

            AutoDavid autoDavid = new AutoDavid();
            autoDavid.setNombre(crearAutoDto.getNombre());
            autoDavid.setModelo(crearAutoDto.getModelo());
            autoDavid.setMarca(crearAutoDto.getMarca());
            autoDavid.setColor(crearAutoDto.getColor());

            davidAutoRepository.save(autoDavid);
        } else {
            throw new IllegalArgumentException("Sucursal no válida");
        }
    }

    public List<?> obtenerAutosPorSucursal(int sucursalId) {
        if (sucursalId == 1) {
            // Retorna los autos de la sucursal de Alain
            return alainAutoRepository.findAll();
        } else if (sucursalId == 2) {
            // Retorna los autos de la sucursal de David
            return davidAutoRepository.findAll();
        } else {
            throw new IllegalArgumentException("Sucursal no válida");
        }
    }

}
