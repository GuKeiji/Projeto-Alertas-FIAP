package br.com.fiap.alertas.controller;

import br.com.fiap.alertas.model.Alerta;
import br.com.fiap.alertas.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/alertas")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Alerta salvar(@RequestBody Alerta alerta){
        return alertaService.salvar(alerta);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Alerta buscarPorId(@PathVariable Long id){
        return alertaService.buscarPorId(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Alerta> buscarTodos(){
        return alertaService.listarTodosAlertas();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        alertaService.remover(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Alerta atualizar(@RequestBody Alerta alerta, @PathVariable Long id){
        alerta.setId(id);
        return alertaService.atualizar(alerta);
    }
}
