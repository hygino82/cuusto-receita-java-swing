package br.dev.hygino.entities;

import java.io.Serializable;

import br.dev.hygino.dto.InserirIngredienteDTO;
import br.dev.hygino.types.Tipo;
import br.dev.hygino.types.Unidade;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_ingrediente")
public class Ingrediente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nome;

    private String descricao;

    @NotNull
    private Double valorEmbalagem;

    @NotNull
    private Double quantidadeEmbalagem;

    @NotNull
    private Double quantidadeUtilizada;

    @NotNull
    private Unidade unidade;

    @NotNull
    private Tipo tipo;

    public Ingrediente() {
    }

    public Ingrediente(InserirIngredienteDTO dto) {
        nome = dto.nome();
        descricao = dto.descricao();
        valorEmbalagem = dto.valorEmbalagem();
        quantidadeEmbalagem = dto.quantidadeEmbalagem();
        quantidadeUtilizada = dto.quantidadeUtilizada();
        unidade = Unidade.valueOf(dto.unidade().toUpperCase());
        tipo = Tipo.valueOf(dto.tipo().toUpperCase());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorEmbalagem() {
        return valorEmbalagem;
    }

    public void setValorEmbalagem(Double valorEmbalagem) {
        this.valorEmbalagem = valorEmbalagem;
    }

    public Double getQuantidadeEmbalagem() {
        return quantidadeEmbalagem;
    }

    public void setQuantidadeEmbalagem(Double quantidadeEmbalagem) {
        this.quantidadeEmbalagem = quantidadeEmbalagem;
    }

    public Double getQuantidadeUtilizada() {
        return quantidadeUtilizada;
    }

    public void setQuantidadeUtilizada(Double quantidadeUtilizada) {
        this.quantidadeUtilizada = quantidadeUtilizada;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Double custo() {
        return (valorEmbalagem / quantidadeEmbalagem) * quantidadeUtilizada;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ingrediente other = (Ingrediente) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
