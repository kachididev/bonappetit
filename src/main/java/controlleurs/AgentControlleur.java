package controlleurs;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.Connexion;
import models.agentModels.Agent;
import models.agentModels.AgentDao;
import org.jdbi.v3.core.Jdbi;
import services.AgentService;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

public class AgentControlleur {

    static AgentService agentService = new AgentService();

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
                    Agent agent = obm.readValue(rqst.body(), Agent.class);
                    boolean ag = agentService.enregistrerAgent(agent);

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
                    Agent agent = obm.readValue(rqst.body(), Agent.class);
                    boolean ag = agentService.update(agent);

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
                    List<Agent> liste = agentService.getAll();
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
                    Agent a = agentService.get(id);
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
                    Boolean a = agentService.delete(id);
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
