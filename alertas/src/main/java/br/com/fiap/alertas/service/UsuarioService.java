package br.com.fiap.alertas.service;

import br.com.fiap.alertas.dto.UsuarioCadastroDto;
import br.com.fiap.alertas.dto.UsuarioExibicaoDto;
import br.com.fiap.alertas.model.Alerta;
import br.com.fiap.alertas.model.Usuario;
import br.com.fiap.alertas.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDto salvarUsuario(UsuarioCadastroDto usuarioDto) {

        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioDto.senha());

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDto.getNome());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setSenha(senhaCriptografada);
        usuario.setRole(usuarioDto.getRole());
        return new UsuarioExibicaoDto(usuarioRepository.save(usuario));
    }

    public List<UsuarioExibicaoDto> listarTodos() {
        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioExibicaoDto::new)
                .toList();
    }

    public void excluir(Long id){
        usuarioRepository.delete(usuarioRepository.findById(id).get());
    }

    public UsuarioExibicaoDto atualizar(Usuario usuario, Long id) {
        Optional<Usuario> usuarioAttOpt = usuarioRepository.findById(id);

        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuario.getSenha());

        if (usuarioAttOpt.isPresent()) {
            Usuario usuarioAtt = usuarioAttOpt.get();
            usuarioAtt.setId(id);
            usuarioAtt.setNome(usuario.getNome());
            usuarioAtt.setEmail(usuario.getUsername());
            usuarioAtt.setSenha(senhaCriptografada);
            usuarioAtt.setRole(usuario.getRole());

            Usuario usuarioSalvo = usuarioRepository.save(usuarioAtt);
            return new UsuarioExibicaoDto(usuarioSalvo);
        } else {
            throw new EntityNotFoundException("Usuário não encontrado com id: " + id);
        }
    }

}
