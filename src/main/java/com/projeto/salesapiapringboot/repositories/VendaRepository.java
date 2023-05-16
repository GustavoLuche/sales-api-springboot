package com.projeto.salesapiapringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.salesapiapringboot.models.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

}
