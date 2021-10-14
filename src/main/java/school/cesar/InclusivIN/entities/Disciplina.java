package school.cesar.InclusivIN.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "DISCIPLINA")
public class Disciplina implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID", nullable = false)
    private Long id;

    @Column (name = "PROFESSOR", nullable = false)
    private String professor;

    @Column (name = "CARGA HORÁRIA", nullable = false)
    private String carga_horaria;

    @OneToMany (mappedBy = "curso", targetEntity = Curso,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private String nomeDisciplina;


}
