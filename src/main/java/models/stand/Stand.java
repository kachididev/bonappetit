package models.stand;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stand {

    String id;
    String province;
    String ville;
    String commune;
    String quartier;
    String avenue;
    int numero;
    String type;

    public Stand(){

    }

    public Stand(
            String id,
            String province,
            String ville,
            String commune,
            String quartier,
            String avenue,
            int numero,
            String type
    ){
        this.id = id;
        this.province = province;
        this.ville = ville;
        this.commune = commune;
        this.quartier = quartier;
        this.avenue = avenue;
        this.numero = numero;
        this.type = type;
    }
}
