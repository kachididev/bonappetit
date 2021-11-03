import controlleurs.AgentControlleur;
import controlleurs.StandControlleur;
import org.jdbi.v3.core.Jdbi;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args){
        Jdbi j = Jdbi.create("jdbc:postgresql://host:port/database","postgres","joellungu");
        System.out.println("cool");

        port(8080);
        staticFiles.location("/public");
        //System.out.println("cool!");
        //get("/hello", (req, res) -> "Hello World");
        path("/api", () -> {
            before("/*", (q, a) -> System.out.println("Received api call"));

            path("/agent", () -> {
                post("/add",  AgentControlleur.add());
                put("/update",  AgentControlleur.update());
                get("/getall", AgentControlleur.getall());
                get("/get", AgentControlleur.get());
                delete("/remove",  AgentControlleur.remove());
            });

            path("/stand", () -> {
                post("/add",  StandControlleur.add());
                put("/update",  StandControlleur.update());
                get("/getall", StandControlleur.getall());
                get("/get", StandControlleur.get());
                delete("/remove",  StandControlleur.remove());
            });

            /*
            path("/metaformulaire", () -> {
                post("/add",       EmailApi.addEmail);
                put("/update",     EmailApi.changeEmail);
                get("/getall",     EmailApi.changeEmail);
                get("/get",     EmailApi.changeEmail);
                delete("/remove",  EmailApi.deleteEmail);
            });
            path("/admin", () -> {
                post("/add",       UserApi.addUsername);
                put("/change",     UserApi.changeUsername);
                delete("/remove",  UserApi.deleteUsername);
            });
            */
        });
    }
}
