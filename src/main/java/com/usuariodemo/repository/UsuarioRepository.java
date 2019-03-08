package com.usuariodemo.repository;

import com.usuariodemo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByPessoaId(long id);

    Usuario findById (long id);
}
