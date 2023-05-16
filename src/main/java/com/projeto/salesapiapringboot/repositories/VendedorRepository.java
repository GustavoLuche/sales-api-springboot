package com.projeto.salesapiapringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.salesapiapringboot.models.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

}
