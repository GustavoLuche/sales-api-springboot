package com.projeto.salesapiapringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.salesapiapringboot.models.Vendedor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    @Override
    @Valid
    <S extends Vendedor> S save(@NotNull @Valid S entity);

}
