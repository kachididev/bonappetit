package controlleurs;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.agentModels.Agent;
import models.stand.Stand;
import services.AgentService;
import services.StandService;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

public class StandControlleur {

    static StandService standService = new StandService();

    public static Route add(){
        class AddRoute implements Route {

            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                //Connexion connexion = new Connexion();
                //Jdbi j = connexion.jdbi;
                try{
                    ObjectMapper obm = new ObjectMapper();
                    JsonNode node = obm.readTree(rqst.body());
                    //Agent agent = new Agent();
                    Stand stand = obm.readValue(rqst.body(), Stand.class);
                    boolean ag = standService.enregistrerAgent(stand);

                    System.out.println("-------:"+ag);
                    return ag;
                    /*

                     */
                }catch(Exception e){
                    return  e.getMessage();
                    //System.out.println("erreur du a: "+e.getMessage());
                }
                //return "ajouter d'un agent effectué!";
            }

        }
        return new AddRoute();
    }

    public static Route update(){


        class UpdateRoute implements Route {

            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {

                try{
                    ObjectMapper obm = new ObjectMapper();
                    JsonNode node = obm.readTree(rqst.body());
                    //Agent agent = new Agent();
                    Stand stand = obm.readValue(rqst.body(), Stand.class);
                    boolean ag = standService.update(stand);

                    System.out.println("-------:"+ag);
                    return ag;
                    /*

                     */
                }catch(Exception e){
                    return  e.getMessage();
                }
            }

        }
        return new UpdateRoute();
    }

    public static Route getall(){
        class GetallRoute implements Route {


            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                try{
                    ObjectMapper obm = new ObjectMapper();
                    //JsonNode node = obm.readTree(rqst.body());
                    //Agent agent = new Agent();
                    //Agent agent = obm.readValue(rqst.body(), Agent.class);
                    List<Stand> liste = standService.getAll();
                    String l = obm.writeValueAsString(liste);
                    System.out.println("-------:"+l);
                    return l;
                    /*

                     */
                }catch(Exception e){
                    return  e.getMessage();
                }
            }

        }
        return new GetallRoute();
    }

    public static Route get(){
        class GetRoute implements Route {


            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                try{
                    ObjectMapper obm = new ObjectMapper();
                    String id = rqst.queryParams("id");
                    Stand a = standService.get(id);
                    String l = obm.writeValueAsString(a);
                    System.out.println("-------:"+l);
                    return l;
                    /*

                     */
                }catch(Exception e){
                    return  e.getMessage();
                }
            }

        }
        return new GetRoute();
    }

    public static Route remove(){
        class RemoveRoute implements Route {


            @Override
            public Object handle(Request rqst, Response rspns) throws Exception {
                try{
                    ObjectMapper obm = new ObjectMapper();
                    String id = rqst.queryParams("id");
                    Boolean a = standService.delete(id);
                    //String l = obm.writeValueAsString(a);
                    System.out.println("-------:"+a);
                    return a;
                    /*

                     */
                }catch(Exception e){
                    return  e.getMessage();
                }
            }

        }
        return new RemoveRoute();
    }

}
