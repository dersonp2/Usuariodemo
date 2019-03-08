package com.usuariodemo.service;

import com.usuariodemo.model.UsuarioSituacao;
import com.usuariodemo.repository.UsuarioSituacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioSituacaoService {

    private UsuarioSituacaoRepository usuarioSituacaoRepository;

    public UsuarioSituacaoService(UsuarioSituacaoRepository usuarioSituacaoRepository) {
        this.usuarioSituacaoRepository = usuarioSituacaoRepository;
    }

    @Transactional
    public UsuarioSituacao salvar(UsuarioSituacao usuarioSituacao){
        return usuarioSituacaoRepository.save(usuarioSituacao);
    }
}
