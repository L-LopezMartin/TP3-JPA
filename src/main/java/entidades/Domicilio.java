package entidades;

import lombok.*;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = "cliente")
public class Domicilio implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCalle;
    private int numero;

    //Foreign Keys
    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;
}
