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
    public List<Venda> getItemsWithoutDiscount() {
        return vendaService.getAllItemsWithoutDiscount();
    }

    @GetMapping("/com-desconto")
    public List<Venda> getItemsWithDiscount() {
        return vendaService.getAllItemsWithDiscount();
    }

    @GetMapping("/ordenado")
    public List<Venda> getItemsOrderByValorUnitDesc() {
        return vendaService.getAllItemsOrderByValorUnitDesc();
    }

    @GetMapping("/mais-vendido")
    public List<Object[]> getTopProductByNf() {
        return vendaService.getTopProductByNf();
    }

    @GetMapping("/mais-de-10")
    public List<Integer> getNfsWithMoreThan10UnitsSold() {
        return vendaService.getNfsWithMoreThan10UnitsSold();
    }

    @GetMapping("/total-maior-500")
    public List<Object[]> getTotalNfValueGreaterThan500() {
        return vendaService.getTotalNfValueGreaterThan500();
    }
}
