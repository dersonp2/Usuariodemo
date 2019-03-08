package com.usuariodemo.service;

import com.usuariodemo.model.Pessoa;
import com.usuariodemo.model.Usuario;
import com.usuariodemo.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private UsuarioService usuarioService;


    @Transactional
    public Pessoa salvar(Pessoa pessoa){
         return pessoaRepository.save(pessoa);
    }

    @Transactional
    public Pessoa atualizar(Long id, Pessoa pessoa){
        Pessoa pessoaSalva = pessoaRepository.findById(id.longValue());
        if (pessoaSalva !=null){
            BeanUtils.copyProperties(pessoa,pessoaSalva, "id");
        }
        return pessoaRepository.save(pessoaSalva);
    }

    @Transactional
    public void deletar(Long id){
        Pessoa pessoa = pessoaRepository.findById(id.longValue());

        if(pessoa!= null){
            List<Usuario> listUsuario = usuarioService.listarUsuarioPessoa(pessoa.getId());
            if(!listUsuario.isEmpty() && listUsuario != null){
                for (Usuario usuario : listUsuario){
                    usuarioService.delete(usuario.getId());
                }
            }
        }
        pessoaRepository.deleteById(id);
    }
}
