package com.usuariodemo.repository;

        import com.usuariodemo.model.Pessoa;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findById(long id);
}
