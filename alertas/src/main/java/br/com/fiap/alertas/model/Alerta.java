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
    private String nome;
    private String descricao;

    @Column(name = "dt_Lancamento")
    private LocalDate dataAlerta;


}
