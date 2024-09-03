package udicentro.iftm.edu.br.vendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import udicentro.iftm.edu.br.vendas.domain.Venda;
import udicentro.iftm.edu.br.vendas.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Operation(summary = "Retorna todos os itens vendidos sem desconto")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Itens sem desconto encontrados")
    })
    @GetMapping("/sem-desconto")
    public List<Venda> getItemsWithoutDiscount() {
        return vendaService.getAllItemsWithoutDiscount();
    }

    @Operation(summary = "Retorna todos os itens vendidos com desconto")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Itens com desconto encontrados")
    })
    @GetMapping("/com-desconto")
    public List<Venda> getItemsWithDiscount() {
        return vendaService.getAllItemsWithDiscount();
    }

    @Operation(summary = "Retorna todos os itens ordenados por valor unitário do maior para o menor")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Itens ordenados encontrados")
    })
    @GetMapping("/ordenado")
    public List<Venda> getItemsOrderByValorUnitDesc() {
        return vendaService.getAllItemsOrderByValorUnitDesc();
    }

    @Operation(summary = "Retorna o produto que mais vendeu em uma mesma nota fiscal")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto mais vendido encontrado")
    })
    @GetMapping("/mais-vendido")
    public List<Object[]> getTopProductByNf() {
        return vendaService.getTopProductByNf();
    }

    @Operation(summary = "Consulta NF que foram vendidas mais de 10 unidades de pelo menos um produto")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Notas fiscais encontradas")
    })
    @GetMapping("/mais-de-10")
    public List<Integer> getNfsWithMoreThan10UnitsSold() {
        return vendaService.getNfsWithMoreThan10UnitsSold();
    }

    @Operation(summary = "Pesquisa o valor total das NF onde esse valor é maior que 500 e ordena do maior para o menor")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Notas fiscais com valor total maior que 500 encontradas")
    })
    @GetMapping("/total-maior-500")
    public List<Object[]> getTotalNfValueGreaterThan500() {
        return vendaService.getTotalNfValueGreaterThan500();
    }
}
