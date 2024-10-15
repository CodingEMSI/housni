package ma.emsi.gestion_stock.Repos;

import ma.emsi.gestion_stock.Entites.Input;
import ma.emsi.gestion_stock.Entites.Output;
import ma.emsi.gestion_stock.Entites.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface OutputRepo  extends MongoRepository<Output, String> {
    @Query(value="{'produitID' : $0}", delete = true)
    public Output deleteByPId (String id);
}
