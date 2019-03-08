package com.usuariodemo.service;

import com.usuariodemo.model.Situacao;
import com.usuariodemo.model.Usuario;
import com.usuariodemo.model.UsuarioSituacao;
import com.usuariodemo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private UsuarioSituacaoService usuarioSituacaoService;


    @Transactional
    public Usuario salvar(Usuario usuario) {
        if (usuario != null &&
                usuario.getPessoa() != null &&
                usuario.getPessoa().getId() == null) {
            usuario.setPessoa(pessoaService.salvar(usuario.getPessoa()));
        }
        usuario = usuarioRepository.save(usuario);

        UsuarioSituacao usuarioSituacao = new UsuarioSituacao();
        usuarioSituacao.setUsuario(usuario);
        usuarioSituacao.setSituacao(new Situacao(1L));

        usuarioSituacaoService.salvar(usuarioSituacao);

        return usuario;
    }


    public List<Usuario> listarUsuarioPessoa(Long id) {
        return usuarioRepository.findByPessoaId(id);
    }

    @Transactional
    public void delete(Long id) {
        Usuario usuario = usuarioRepository.findById(id.longValue());
        if (usuario != null) {
            usuarioRepository.delete(usuario);
        }
    }
}
