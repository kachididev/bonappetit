package services;

import data.Connexion;
import models.agentModels.Agent;
import models.agentModels.AgentDao;
import models.stand.Stand;
import models.stand.StandDao;

import java.util.List;

public class StandService {

    Connexion connexion = new Connexion();

    public StandService() {}

    public boolean enregistrerAgent(Stand stand){
        boolean a =  connexion.jdbi.withExtension(StandDao.class, dao -> {
            boolean ag = dao.insert(stand);
            return ag;
        });
        return a;
    }

    public boolean update(Stand stand){
        boolean a =  connexion.jdbi.withExtension(StandDao.class, dao -> {
            boolean ag = dao.upDateStand(stand);
            return ag;
        });
        return a;
    }

    public List<Stand> getAll(){
        List<Stand> l =  connexion.jdbi.withExtension(StandDao.class, dao -> {
            List<Stand>  liste = dao.getListeStand();
            return liste;
        });
        return l;
    }

    public Stand get(String id){
        Stand a =  connexion.jdbi.withExtension(StandDao.class, dao -> {
            Stand  stand = dao.getStand(id);
            return stand;
        });
        return a;
    }

    public Boolean delete(String id){
        Boolean a =  connexion.jdbi.withExtension(StandDao.class, dao -> {
            Boolean  v = dao.supprimerStand(id);
            return v;
        });
        return a;
    }

}
