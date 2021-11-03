package data;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class Connexion {

    public Jdbi jdbi; // = Jdbi.create("jdbc:postgresql://host:port/database","postgres","joellungu");
    public Connexion(){
        jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/postgres","postgres","joellungu");
        jdbi.installPlugin(new SqlObjectPlugin());
    }
}
