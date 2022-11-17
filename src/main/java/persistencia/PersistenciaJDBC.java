package persistencia;

import java.sql.*;
import java.util.List;

public class PersistenciaJDBC {

    private String url;
    private String usr;
    private String pass;

    public PersistenciaJDBC() {
//			Properties p = new Properties();
//			p.load(new FileInputStream("src/main/resources/propiedades.properties"));
        url = "jdbc:mysql://127.0.0.1:3307/AD_avis?serverTimezone=UTC";
        usr = "root";
        pass = "root";

    }

    public boolean aniadirExtras(Integer reservaId, List<Extra> extras) {
        boolean result = false;

        Connection conn = null;

        try {
            // creo conexión
            conn = DriverManager.getConnection(url, usr, pass);

            //(1) definir el setAutocommit = false
            conn.setAutoCommit(false);
            if (existeReserva(reservaId)) {
                for (Extra extra : extras
                ) {
                    if (existeExtra(extra.id)) {
                        PreparedStatement ps = conn.prepareStatement("insert into reservas_extras(reserva_id, extra_id) values (?,?)");

                        ps.setInt(1, reservaId);
                        ps.setInt(2, extra.getId());

                        // ejecutar consulta
                        ps.executeUpdate();
                        ps.close();
                    } else {
                        conn.rollback();
                        return false;
                    }
                }

                //(2) confirmamos las instrucciones ejecutadas
                conn.commit();
                result = true;
            }

        } catch (SQLException e) {
            try {
                //(3) si existe algún error hacer rollback
                conn.rollback();
                System.err.println("Se ha realizado el rollback en aniadirProducto");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private boolean existeReserva(int id) {
        Boolean existe = false;

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, usr, pass);

            PreparedStatement ps = conn.prepareStatement("select * from reservas where id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            existe = rs.next();

            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return existe;
    }

    private boolean existeExtra(int id) {
        Boolean existe = false;

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, usr, pass);

            PreparedStatement ps = conn.prepareStatement("select * from extras where id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            existe = rs.next();

            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return existe;
    }
}


