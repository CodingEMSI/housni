package ma.emsi.gestion_stock.Controller;

import ma.emsi.gestion_stock.Repos.InputRepo;
import ma.emsi.gestion_stock.Repos.OutputRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ma.emsi.gestion_stock.Entites.Produit;
import ma.emsi.gestion_stock.Repos.ProduitRepo;


@Controller
public class ProduitController {

    @Autowired
    ProduitRepo produitRepo;

    @Autowired
    InputRepo inRepo;

    @Autowired
    OutputRepo outRepo;

    @GetMapping("produits")
    public String Index(Model model)
    {
        model.addAttribute("produits", produitRepo.findAll());
        return "produits";
    }

    @PostMapping("produits")
    public String Post(Produit produit)
    {
        produitRepo.save(produit);
        return "redirect:/produits";
    }

    @GetMapping("produits/delete/{id}")
    public String Remove(@PathVariable(value = "id")String id)
    {
        inRepo.deleteByPId(id);
        outRepo.deleteByPId(id);
        produitRepo.deleteById(id);
        return "redirect:/produits";
    }
}
