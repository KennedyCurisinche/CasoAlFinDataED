package rogger.guia.app.CasoDataEG.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = -1160500989864614150L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nameUsuario;
    private String passwordUsuario;
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "rol_us",
            joinColumns = @JoinColumn(
                    name = "id_usuario",
                    nullable = false,
                    unique = true,
                    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_usuario) references usuario(id_usuario)")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_rol",
                    nullable = false,
                    unique = true,
                    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_rol) references rol(id_rol)")
            )
    )
    private List<Rol> roles = new ArrayList<>();

}
