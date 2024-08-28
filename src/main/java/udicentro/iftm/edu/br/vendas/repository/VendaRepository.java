package udicentro.iftm.edu.br.vendas.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import udicentro.iftm.edu.br.vendas.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findByDesconto(BigDecimal desconto);

    List<Venda> findByDescontoGreaterThan(BigDecimal desconto);

    List<Venda> findAllByOrderByValorUnitDesc();

    @Query("SELECT v.codProd, SUM(v.quantidade) as total FROM Venda v GROUP BY v.codProd ORDER BY total DESC")
    List<Object[]> findTopProductByNf();

    @Query("SELECT DISTINCT v.idNf FROM Venda v WHERE v.quantidade > 10")
    List<Integer> findNfsWithMoreThan10UnitsSold();

    @Query("SELECT v.idNf, SUM(v.valorUnit * v.quantidade) as total FROM Venda v GROUP BY v.idNf HAVING total > 500 ORDER BY total DESC")
    List<Object[]> findTotalNfValueGreaterThan500();
}
