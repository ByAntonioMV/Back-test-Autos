package com.dev.alain.Controller;


import com.dev.alain.Dto.CrearAutoDto;
import com.dev.alain.Entity.LocalEntity.Auto;
import com.dev.alain.Service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/autos")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AutoController {

    @Autowired
    private AutoService autoService;

    @PostMapping
    public ResponseEntity<String> ingresarAuto(@RequestBody CrearAutoDto crearAutoDto) {
        try {
            autoService.ingresarAuto(crearAutoDto);
            return ResponseEntity.ok("Auto ingresado exitosamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor.");
        }
    }

    @GetMapping("/{sucursalId}")
    public ResponseEntity<?> obtenerAutosPorSucursal(@PathVariable int sucursalId) {
        try {
            List<?> autos = autoService.obtenerAutosPorSucursal(sucursalId);
            return ResponseEntity.ok(autos);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor.");
        }
    }
}
