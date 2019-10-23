package com.amx.infra.directorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColaboradorService{

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public List getAllColaboradores() {
        List personas = new ArrayList<>();
        colaboradorRepository.findAll().forEach(personas::add);
        return personas;
    }

    public Colaborador getColaborador(Integer id) {
        return colaboradorRepository.findById(id).orElseGet(Colaborador::new);
    }

    public void addColaborador(Colaborador whiskey) {
        colaboradorRepository.save(whiskey);
    }

    public void updateColaborador(Integer id, Colaborador whiskey) {
        colaboradorRepository.save(whiskey);
    }

    public void deleteColaborador(Integer id) {
        colaboradorRepository.deleteById(id);
    }

}
