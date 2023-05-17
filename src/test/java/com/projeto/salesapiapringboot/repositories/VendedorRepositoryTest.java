package com.projeto.salesapiapringboot.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.projeto.salesapiapringboot.models.Vendedor;

@DataJpaTest
@ActiveProfiles("test")
public class VendedorRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Test
    public void testFindById() {
        Vendedor vendedor = new Vendedor(null, "John Doe");
        entityManager.persist(vendedor);

        Vendedor foundVendedor = vendedorRepository.findById(vendedor.getId()).orElse(null);

        assertNotNull(foundVendedor);
        assertEquals("John Doe", foundVendedor.getNome());
    }

}