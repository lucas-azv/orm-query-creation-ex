package udicentro.iftm.edu.br.vendas.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import udicentro.iftm.edu.br.vendas.Venda;
import udicentro.iftm.edu.br.vendas.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> getAllItemsWithoutDiscount() {
        return vendaRepository.findByDesconto(BigDecimal.ZERO);
    }

    public List<Venda> getAllItemsWithDiscount() {
        return vendaRepository.findByDescontoGreaterThan(BigDecimal.ZERO);
    }

    public List<Venda> getAllItemsOrderByValorUnitDesc() {
        return vendaRepository.findAllByOrderByValorUnitDesc();
    }

    public List<Object[]> getTopProductByNf() {
        return vendaRepository.findTopProductByNf();
    }

    public List<Integer> getNfsWithMoreThan10UnitsSold() {
        return vendaRepository.findNfsWithMoreThan10UnitsSold();
    }

    public List<Object[]> getTotalNfValueGreaterThan500() {
        return vendaRepository.findTotalNfValueGreaterThan500();
    }
}
