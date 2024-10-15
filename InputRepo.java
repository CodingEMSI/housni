package ma.emsi.gestion_stock.Repos;

import ma.emsi.gestion_stock.Entites.Input;
import ma.emsi.gestion_stock.Entites.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface InputRepo  extends MongoRepository<Input, String> {
    @Query(value="{'produitID' : ?0}", delete = true)
    public Input deleteByPId (String id);
}
