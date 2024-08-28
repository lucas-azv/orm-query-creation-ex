package udicentro.iftm.edu.br.vendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udicentro.iftm.edu.br.vendas.Venda;
import udicentro.iftm.edu.br.vendas.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping("/sem-desconto")
    public ResponseEntity<List<Venda>> findVendasSemDesconto() {
        List<Venda> vendas = vendaService.findVendasSemDesconto();
        return ResponseEntity.ok().body(vendas);
    }

    @GetMapping("/com-desconto")
    public ResponseEntity<List<Venda>> findVendasComDesconto() {
        List<Venda> vendas = vendaService.findVendasComDesconto();
        return ResponseEntity.ok().body(vendas);
    }
}
