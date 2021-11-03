package services;

import data.Connexion;
import models.agentModels.Agent;
import models.agentModels.AgentDao;

import java.util.List;

public class AgentService {

    Connexion connexion = new Connexion();

    public AgentService() {}

    public boolean enregistrerAgent(Agent agent){
        boolean a =  connexion.jdbi.withExtension(AgentDao.class, dao -> {
            boolean ag = dao.insert(agent);
            return ag;
        });
        return a;
    }

    public boolean update(Agent agent){
        boolean a =  connexion.jdbi.withExtension(AgentDao.class, dao -> {
            boolean ag = dao.upDateAgent(agent);
            return ag;
        });
        return a;
    }

    public List<Agent> getAll(){
        List<Agent> l =  connexion.jdbi.withExtension(AgentDao.class, dao -> {
            List<Agent>  liste = dao.getListeAgent();
            return liste;
        });
        return l;
    }

    public Agent get(String id){
        Agent a =  connexion.jdbi.withExtension(AgentDao.class, dao -> {
            Agent  agent = dao.getAgent(id);
            return agent;
        });
        return a;
    }

    public Boolean delete(String id){
        Boolean a =  connexion.jdbi.withExtension(AgentDao.class, dao -> {
            Boolean  v = dao.supprimerAgent(id);
            return v;
        });
        return a;
    }

}
