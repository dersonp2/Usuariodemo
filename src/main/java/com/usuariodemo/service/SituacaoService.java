package com.usuariodemo.service;

import com.usuariodemo.model.Situacao;
import com.usuariodemo.repository.SituacaoRepository;
import com.usuariodemo.resource.SituacaoResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SituacaoService {
    private SituacaoRepository situacaoRepository;

    public SituacaoService(SituacaoRepository situacaoRepository) {
        this.situacaoRepository = situacaoRepository;
    }

    @Transactional
    public Situacao salvar(Situacao situacao){
        return situacaoRepository.save(situacao);
    }
}
