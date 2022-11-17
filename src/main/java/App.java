import persistencia.Extra;
import persistencia.PersistenciaJDBC;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {
    public static void main( String[] args )
    {
        List<Extra> extras=new ArrayList<>();
        extras.add(new Extra(1,"", "", 0, new Date(), new Date()));
        extras.add(new Extra(2,"", "", 0, new Date(), new Date()));
        extras.add(new Extra(3,"", "", 0, new Date(), new Date()));

        boolean aniadido = new PersistenciaJDBC().aniadirExtras(1,extras);
        System.out.println(aniadido ? "añadido ok" : "error");
    }
}
