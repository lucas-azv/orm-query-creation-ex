package udicentro.iftm.edu.br.vendas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vendas")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "idNf")
    private int idNf;
    
    @Column(name = "idItem")
    private int idItem;
    
    @Column(name = "codProd")
    private int codProd;
    
    @Column(name = "valorUnit")
    private double valorUnit;
    
    @Column(name = "quantidade")
    private int quantidade;
    
    @Column(name = "desconto")
    private double desconto;
}
