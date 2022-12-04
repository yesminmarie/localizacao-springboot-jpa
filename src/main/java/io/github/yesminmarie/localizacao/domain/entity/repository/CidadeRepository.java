package io.github.yesminmarie.localizacao.domain.entity.repository;

import io.github.yesminmarie.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
