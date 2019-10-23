package com.amx.infra.directorio;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ColaboradorController{

    @Autowired
    private ColaboradorService empleadoservice;

    @GetMapping("api/empleados")
    public List getAllEmpleados() {
	System.out.println("Entramos a GET All Colaboradores");
        return empleadoservice.getAllColaboradores();
    }

    @GetMapping("/api/empleados/{idEmpleado}")
    public Colaborador getEmpleado(@PathVariable int idEmpleado){
        return empleadoservice.getColaborador(idEmpleado);
    }


    @PostMapping("api/empleados")
    public void addEmpleado(@RequestBody Colaborador empleado) {
        empleadoservice.addColaborador(empleado);
    }

    @PutMapping("api/empleados/{idEmpleado}")
    public void updateEmpleado(@PathVariable int idEmpleado, @RequestBody Colaborador colaborador) {
        empleadoservice.updateColaborador(idEmpleado, colaborador);
    }

    @DeleteMapping("api/empleados/{idEmpleado}")
    public void deleteEmpleado(@PathVariable int idEmpleado) {
        empleadoservice.deleteColaborador(idEmpleado);
    }

}

