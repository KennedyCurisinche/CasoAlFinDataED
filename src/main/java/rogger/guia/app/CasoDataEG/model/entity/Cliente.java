package rogger.guia.app.CasoDataEG.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Serial
    private static final long serialVersionUID = -3349741945334705692L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nombreCliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_saldo")
    private Saldo saldo;

}
