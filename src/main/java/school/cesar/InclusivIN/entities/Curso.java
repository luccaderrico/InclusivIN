package school.cesar.InclusivIN.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CURSOS")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false, unique = true)
    private String nomeCurso;

   /*@OneToMany(mappedBy="Disciplina")
    @JoinColumn(name = "DISCIPLINA_ID")
    private List<Disciplina> disciplinas;*/

}
