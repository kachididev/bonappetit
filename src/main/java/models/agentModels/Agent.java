package models.agentModels;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Agent {


    String id;
    String nom;
    String postnom;
    String prenom;
    String email;
    String numero1;
    String numero2;
    String etatcivil;
    String adresse;
    String role;
    Date datenaissance;
    String motdepasse;

    public Agent(
            String id,
            String nom,
            String postnom,
            String prenom,
            String email,
            String numero1,
            String numero2,
            String etatcivil,
            String adresse,
            String role,
            Date datenaissance,
            String motdepasse
    ){
        this.id = id;
        this.nom = nom;
        this.postnom = postnom;
        this.prenom = prenom;
        this.email = email;
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.etatcivil = etatcivil;
        this.adresse = adresse;
        this.role = role;
        this.datenaissance = datenaissance;
        this.motdepasse = motdepasse;
    }

    public Agent(

    ) {

    }


}
