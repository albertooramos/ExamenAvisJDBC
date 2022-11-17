package persistencia;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Reserva {
    public int id;
    public User user;
    public Coche coche;
    public Date fecha_inicio;
    public Date fecha_fin;
    public Double precio_total;
    public String estado;
    public Date updated_at;
    public Date created_at;
    public User usuario;
}
