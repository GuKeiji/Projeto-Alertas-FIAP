package br.com.fiap.alertas.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "T_Alertas")
public class Alerta {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_ALERTAS"
    )
    @SequenceGenerator(
            name = "SEQ_ALERTAS",
            sequenceName = "SEQ_ALERTAS",
            allocationSize = 1
    )
    private Long id;
    private String titulo;
    private String descricao;
    private String categoria;
    private String risco;
    private String situacao;

    @Column(name = "dt_Lancamento")
    private LocalDate dataAlerta;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public LocalDate getDataAlerta() {
        return dataAlerta;
    }

    public void setDataAlerta(LocalDate dataAlerta) {
        this.dataAlerta = dataAlerta;
    }
}
