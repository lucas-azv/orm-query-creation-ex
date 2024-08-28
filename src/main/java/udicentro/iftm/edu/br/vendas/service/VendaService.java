package udicentro.iftm.edu.br.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import udicentro.iftm.edu.br.vendas.Venda;
import udicentro.iftm.edu.br.vendas.repository.VendaRepository;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public List<Venda> findVendasSemDesconto() {
        return vendaRepository.findByDesconto(0);
    }

    public List<Venda> findVendasComDesconto() {
        return vendaRepository.findByDescontoGreaterThan(0);
    }
}
