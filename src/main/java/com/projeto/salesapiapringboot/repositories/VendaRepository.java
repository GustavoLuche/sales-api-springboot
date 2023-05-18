package com.projeto.salesapiapringboot.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projeto.salesapiapringboot.models.Venda;
import com.projeto.salesapiapringboot.projections.VendedorListaProjection;

import jakarta.validation.constraints.NotNull;

public interface VendaRepository extends JpaRepository<Venda, Long> {
	
	@Query(nativeQuery = true, value = """
            SELECT tb_vendedor.vendedor_nome AS vendedorNome,
            COUNT(tb_venda.id) AS totalVendas,
            CAST(COUNT(tb_venda.id) AS DECIMAL) / (DATEDIFF('DAY', :dataInicial, :dataFinal)+1) AS mediaDiariaVendas
            FROM tb_venda
            INNER JOIN tb_vendedor ON tb_vendedor.id = tb_venda.vendedor_id
            WHERE tb_venda.data_venda >= :dataInicial
              AND tb_venda.data_venda <= :dataFinal
            GROUP BY tb_venda.vendedor_id
                                                     """)
    List<VendedorListaProjection> getVendedoresResumoVendasPeriodo(
      @NotNull @Param("dataInicial") LocalDate dataInicial,
      @NotNull @Param("dataFinal") LocalDate dataFinal) throws DataAccessException;
	
}
