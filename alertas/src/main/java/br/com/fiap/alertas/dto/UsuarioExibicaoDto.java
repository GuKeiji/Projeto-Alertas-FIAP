package br.com.fiap.alertas.dto;

import br.com.fiap.alertas.model.Usuario;

public record UsuarioExibicaoDto(
        Long id,
        String nome,
        String email
) {

    public UsuarioExibicaoDto(Usuario usuario) {
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getUsername()
        );
    }

}
