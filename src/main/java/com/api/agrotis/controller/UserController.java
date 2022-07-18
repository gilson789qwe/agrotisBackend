package com.api.agrotis.controller;

import com.api.agrotis.model.User;
import com.api.agrotis.repository.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private Users users;

    @GetMapping
    public List<User> get(){
        return users.findAll();
    }

    @PostMapping
    public User create(@Valid @RequestBody User user){
        return users.save(user);
    }

    @PutMapping
    public ResponseEntity save(@Valid @RequestBody User user) {
        return users.findById(user.getId())
                .map(payload -> {
                    payload.setNome(user.getNome());
                    payload.setDataInicial(user.getDataInicial());
                    payload.setDataFinal(user.getDataFinal());
                    payload.setInfosPropriedade(user.getInfosPropriedade());
                    payload.setCnpj(user.getCnpj());
                    payload.setLaboratorio(user.getLaboratorio());
                    payload.setObservacoes(user.getObservacoes());
                    User updated = users.save(payload);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody User user) {
        return users.findById(id)
                .map(payload -> {
                    payload.setNome(user.getNome());
                    payload.setDataInicial(user.getDataInicial());
                    payload.setDataFinal(user.getDataFinal());
                    payload.setInfosPropriedade(user.getInfosPropriedade());
                    payload.setCnpj(user.getCnpj());
                    payload.setLaboratorio(user.getLaboratorio());
                    payload.setObservacoes(user.getObservacoes());
                    User updated = users.save(payload);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
        return users.findById(id)
                .map(record -> {
                    users.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
