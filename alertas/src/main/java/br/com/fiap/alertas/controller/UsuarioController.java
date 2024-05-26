package br.com.fiap.alertas.controller;

import br.com.fiap.alertas.dto.UsuarioCadastroDto;
import br.com.fiap.alertas.dto.UsuarioExibicaoDto;
import br.com.fiap.alertas.model.Alerta;
import br.com.fiap.alertas.model.Usuario;
import br.com.fiap.alertas.service.AlertaService;
import br.com.fiap.alertas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto salvar(@RequestBody UsuarioCadastroDto usuario){
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioExibicaoDto> buscarTodos(){
        return usuarioService.listarTodos();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        usuarioService.excluir(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto atualizar(@RequestBody Usuario usuario, @PathVariable Long id){
        return usuarioService.atualizar(usuario, id);
    }
}
