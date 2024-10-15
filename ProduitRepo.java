package ma.emsi.gestion_stock.Repos;

import ma.emsi.gestion_stock.Entites.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProduitRepo extends MongoRepository<Produit, String> {
}
