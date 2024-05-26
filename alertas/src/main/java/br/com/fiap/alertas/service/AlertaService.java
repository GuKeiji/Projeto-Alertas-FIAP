package br.com.fiap.alertas.service;

import br.com.fiap.alertas.model.Alerta;
import br.com.fiap.alertas.model.Usuario;
import br.com.fiap.alertas.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    public Alerta salvar(Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    public List<Alerta> listarTodosAlertas() {
        return alertaRepository.findAll();
    }

    public void remover(Long id) {
        alertaRepository.deleteById(id);
    }

    public Alerta buscarPorId(Long id) {
        var alertaOptional = alertaRepository.findById(id);

        if (alertaOptional.isPresent()) {
            return alertaOptional.get();
        } else {
            throw new RuntimeException("Alerta não existe!");
        }
    }

    public Alerta atualizar(Alerta alerta){
        return alertaRepository.save(alerta);
    }

}
