package persistencia;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Extra {
    public int id;
    public String titulo;
    public String descripcion;
    public int precio;
    public Date updatedAt;
    public Date createdAt;
}
