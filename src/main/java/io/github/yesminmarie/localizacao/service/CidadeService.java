package io.github.yesminmarie.localizacao.service;

import io.github.yesminmarie.localizacao.domain.entity.Cidade;
import io.github.yesminmarie.localizacao.domain.entity.repository.CidadeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CidadeService {

    private CidadeRepository repository;

    public CidadeService(CidadeRepository repository){
        this.repository = repository;
    }

    public void listarCidadesPorQuantidadeHabitantes(){
        repository
                .findByHabitantesLessThanAndNomeLike(2000001L, "Porto%")
                .forEach(System.out::println);
    }

    public void listarCidadesPorNome(){
        Pageable pageable = PageRequest.of(0, 10);
        repository
                .findByNomeLike(
                "Porto%", pageable)
                .forEach(System.out::println);
    }

    public void listarCidadesPorHabitantes(){
        repository.findByHabitantes(10000000L).forEach(System.out::println);
    }

    @Transactional
    public void salvarCidade(){
        var cidade = new Cidade(1L, "São Paulo", 12396372L);
        repository.save(cidade);
    }

    public void listarCidades(){
        repository.findAll().forEach(System.out::println);
    }
}