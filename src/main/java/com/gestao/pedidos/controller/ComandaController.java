package com.gestao.pedidos.controller;

import com.gestao.pedidos.dto.ComandaRequest;
import com.gestao.pedidos.model.Comanda;
import com.gestao.pedidos.repository.ComandaRepository;
import com.gestao.pedidos.service.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comandas")
public class ComandaController {

    @Autowired
    private ComandaRepository repository;

    @Autowired
    private ComandaService comandaService;

    @PostMapping
    public Comanda abrirComanda(@RequestBody ComandaRequest request) {

        Comanda novaComanda = new Comanda();
        novaComanda.setNumeroMesa(request.numeroMesa());
        novaComanda.setStatus("ABERTA");

        return repository.save(novaComanda);
    }

    @GetMapping
    public List<Comanda> listarComandas() {
        return repository.findAll();
    }

    @PutMapping("/{id}/pagar")
    public String pagarComanda(@PathVariable Long id) {
        return comandaService.fecharMesaEPagar(id);
    }
}