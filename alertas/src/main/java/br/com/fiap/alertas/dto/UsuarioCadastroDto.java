package br.com.fiap.alertas.dto;

import br.com.fiap.alertas.model.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDto(
        Long usuarioId,

        @NotBlank(message = "O nome do usuário é obrigatório")
        String nome,

        @NotBlank(message = "O email do usuário é obrigatório")
        @Email(message = "O email do usuário é obrigatório")
        String email,

        @NotBlank(message = "A senha é obrigatório")
        @Size(min = 6, max = 20, message = "A senha deve conter entre 6 e 20 caracteres")
        String senha,

        @Enumerated(EnumType.STRING)
        UserRole role
) {

        public String getSenha() {
                return senha;
        }

        public String getEmail() {
                return email;
        }

        public String getNome() {
                return nome;
        }

        public UserRole getRole() {
                return role;
        }
}
