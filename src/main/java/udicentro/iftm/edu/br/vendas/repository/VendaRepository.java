package udicentro.iftm.edu.br.vendas.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import udicentro.iftm.edu.br.vendas.domain.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    @Query("SELECT v FROM Venda v WHERE v.desconto = :desconto")
    List<Venda> findByDesconto(BigDecimal desconto);

    @Query("SELECT v FROM Venda v WHERE v.desconto > :desconto")
    List<Venda> findByDescontoGreaterThan(BigDecimal desconto);

    List<Venda> findAllByOrderByValorUnitDesc();

    @Query("SELECT v.idNf, v.codProd, SUM(v.quantidade) as totalQuantidade " +
           "FROM Venda v " +
           "GROUP BY v.idNf, v.codProd " +
           "HAVING totalQuantidade = (SELECT MAX(totalQuantidade) " +
           "                           FROM (SELECT SUM(v2.quantidade) as totalQuantidade " +
           "                                 FROM Venda v2 " +
           "                                 WHERE v2.idNf = v.idNf " +
           "                                 GROUP BY v2.codProd) subquery)")
    List<Object[]> findTopProductByNf();

    @Query("SELECT DISTINCT v.idNf " +
           "FROM Venda v " +
           "WHERE v.quantidade > 10")
    List<Integer> findNfsWithMoreThan10UnitsSold();

    @Query("SELECT v.idNf, SUM(v.valorUnit * v.quantidade) as totalValue " +
           "FROM Venda v " +
           "GROUP BY v.idNf " +
           "HAVING totalValue > 500 " +
           "ORDER BY totalValue DESC")
    List<Object[]> findTotalNfValueGreaterThan500();
}
