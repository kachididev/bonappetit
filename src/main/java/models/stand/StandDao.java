package models.stand;


import models.agentModels.Agent;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface StandDao {
    //
    @SqlUpdate("insert into stand (" +
            "id, province, ville, commune, quartier, avenue, numero, type)" +
            " values (" +
            ":id, :province, :ville, :commune, :quartier, :avenue, :numero, :type " +
            ")")
    boolean insert(@BindBean Stand stand);

    @SqlQuery("select * from stand")
    @RegisterBeanMapper(Stand.class)
    List<Stand> getListeStand();

    @SqlQuery("select * from stand where id = :id")
    @RegisterBeanMapper(Stand.class)
    Stand getStand(@Bind("id") String id);

    @SqlUpdate("update stand set province= :province, ville= :ville, commune= :commune, quartier= :quartier, avenue= :avenue, numero= :numero," +
            "type= :type where id= :id")
    boolean upDateStand(@BindBean Stand stand);

    @SqlUpdate("DELETE FROM stand WHERE id= :id")
    boolean supprimerStand(@Bind("id") String id);

}
