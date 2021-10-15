package school.cesar.InclusivIN.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "DISCIPLINA")
public class Disciplina implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID", nullable = false)
    private Long id;

    @Column (name = "NOME DISCIPLINA", nullable = false)
    private String nomeDisciplina;

    @Column (name = "PROFESSOR", nullable = false)
    private String professor;

    @Column (name = "CARGA HORÁRIA", nullable = false)
    private String cargaHoraria;

    /*@ManyToOne
    @JoinColumn (name = "CURSO_ID")
    private Curso curso;*/

}
