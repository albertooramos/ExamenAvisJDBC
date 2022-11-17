package persistencia;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Coche {
    public int id;
    public String tipo;
    public String descripcion;
    public int puertas;
    public int asientos;
    public String tipo_conduccion;
    public double precioDia;
    public Date updated_at;
    public Date created_at;
}
