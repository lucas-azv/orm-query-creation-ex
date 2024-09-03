package udicentro.iftm.edu.br.vendas.dto;

public class VendaDto {
    private Long id;
    private Integer idNf;
    private Integer idItem;
    private Integer codProd;
    private Double valorUnit;
    private Integer quantidade;
    private Double desconto;

    // Construtores, getters e setters

    public VendaDto() { }

    public VendaDto(Long id, Integer idNf, Integer idItem, Integer codProd, Double valorUnit, Integer quantidade, Double desconto) {
        this.id = id;
        this.idNf = idNf;
        this.idItem = idItem;
        this.codProd = codProd;
        this.valorUnit = valorUnit;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdNf() {
        return idNf;
    }

    public void setIdNf(Integer idNf) {
        this.idNf = idNf;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getCodProd() {
        return codProd;
    }

    public void setCodProd(Integer codProd) {
        this.codProd = codProd;
    }

    public Double getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(Double valorUnit) {
        this.valorUnit = valorUnit;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
}
