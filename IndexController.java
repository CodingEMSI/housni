package ma.emsi.gestion_stock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ma.emsi.gestion_stock.Entites.ProduitsDTO;
import ma.emsi.gestion_stock.Repos.InputRepo;
import ma.emsi.gestion_stock.Repos.OutputRepo;
import ma.emsi.gestion_stock.Repos.ProduitRepo;

@Controller
public class IndexController {
    
    @Autowired
    ProduitRepo produitRepo;
    
    @Autowired
    InputRepo inRepo;

    @Autowired
    OutputRepo outRepo;

    @GetMapping("")
    public String Index(Model model)
    {
        
        model.addAttribute("produits", produitRepo.findAll().stream().map((produit)->new ProduitsDTO(produit,
            inRepo.findAll().stream().filter((input) -> input.getProduitID().equals(produit.getId())).mapToInt((input)->input.getQte()).sum() -
            outRepo.findAll().stream().filter((output) -> output.getProduitID().equals(produit.getId())).mapToInt((output)->output.getQte()).sum()
        )));
        return "index";
    }
}
