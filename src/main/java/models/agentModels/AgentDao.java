package models.agentModels;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlBatch;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
//import org.springframework.context.annotation.Bean;

import java.util.List;

//@UseClasspathSqlLocator
public interface AgentDao {
    //
    @SqlUpdate("insert into agent (" +
            "id, nom, postnom, prenom, email, numero1, numero2,etatcivil,adresse,role,datenaissance,motdepasse)" +
            " values (" +
            ":id, :nom, :postnom, :prenom, :email, :numero1, :numero2,:etatcivil,:adresse,:role,:datenaissance,:motdepasse" +
            ")")
    boolean insert(@BindBean Agent agent);

    @SqlQuery("select * from agent")
    @RegisterBeanMapper(Agent.class)
    List<Agent> getListeAgent();

    @SqlQuery("select * from agent where id = :id")
    @RegisterBeanMapper(Agent.class)
    Agent getAgent(@Bind("id") String id);

    @SqlUpdate("update agent set nom= :nom, postnom= :postnom, prenom= :prenom, email= :email, numero1= :numero1, numero2= :numero2," +
            "etatcivil= :etatcivil,adresse= :adresse,role= :role,datenaissance= :datenaissance,motdepasse= :motdepasse " +
            "where id= :id")
    boolean upDateAgent(@BindBean Agent agent);

    @SqlUpdate("DELETE FROM agent WHERE id= :id")
    boolean supprimerAgent(@Bind("id") String id);

}
