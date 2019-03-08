package com.usuariodemo.resource;

import com.usuariodemo.model.Pessoa;
import com.usuariodemo.repository.PessoaRepository;
import com.usuariodemo.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

    private PessoaService pessoaService;

    private PessoaRepository pessoaRepository;

    public PessoaResource(@Lazy PessoaService pessoaService, PessoaRepository pessoaRepository) {
        this.pessoaService = pessoaService;
        this.pessoaRepository = pessoaRepository;
    }


    @PostMapping
    public ResponseEntity<Pessoa> cadastrarPessoa(@Valid @RequestBody Pessoa pessoa){
        pessoa = pessoaService.salvar(pessoa);
        return new ResponseEntity<Pessoa>(pessoa, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas(){
        return new ResponseEntity<List<Pessoa>> (pessoaRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoa(@PathVariable Long id){
        Pessoa pessoa = pessoaRepository.findById(id.longValue());
        return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id,@Valid @RequestBody Pessoa pessoa){
        pessoa=pessoaService.atualizar(id, pessoa);
        return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPessoa(@PathVariable Long id){
        pessoaService.deletar(id);
    }
}
