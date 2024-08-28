package udicentro.iftm.edu.br.vendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import udicentro.iftm.edu.br.vendas.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findByDesconto(double desconto);
    List<Venda> findByDescontoGreaterThan(double desconto);
    List<Venda> findAllByOrderByValorUnitDesc();
}
