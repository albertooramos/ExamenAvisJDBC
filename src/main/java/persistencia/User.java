package persistencia;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class User {
    public int id;
    public String name;
    public String email;
    public String password;
    public String rol;
    public Date updated_at;
    public Date created_at;

}
