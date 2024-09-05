package entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import entidades.DetalleFactura;


@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Factura implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private int numero;
    private int total;
    private String fecha;

    //Foreign Keys
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @Singular("detalleFactura")
    @OneToMany(mappedBy = "factura", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<DetalleFactura> detalleFactura = new HashSet<>();
}
