package com.usuariodemo.resource;

import com.usuariodemo.model.Situacao;
import com.usuariodemo.service.SituacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/situacao")
public class SituacaoResource {

    private SituacaoService situacaoService;

    public SituacaoResource(SituacaoService situacaoService) {
        this.situacaoService = situacaoService;
    }

    @PostMapping
    public ResponseEntity<Situacao> cadastrarSituacao(@RequestBody Situacao situacao){
        situacao = situacaoService.salvar(situacao);
        return new ResponseEntity<Situacao>(situacao, HttpStatus.CREATED);
    }
}
