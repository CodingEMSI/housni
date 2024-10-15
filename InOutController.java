package ma.emsi.gestion_stock.Controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ma.emsi.gestion_stock.Entites.Input;
import ma.emsi.gestion_stock.Entites.Output;
import ma.emsi.gestion_stock.Repos.InputRepo;
import ma.emsi.gestion_stock.Repos.OutputRepo;
import ma.emsi.gestion_stock.Repos.ProduitRepo;


@Controller
public class InOutController {

    @Autowired
    ProduitRepo produitRepo;
    
    @Autowired
    InputRepo inRepo;

    @Autowired
    OutputRepo outRepo;

    @GetMapping("entree")
    public String Index(Model model)
    {
        
        Map<String, String> produitsMap = new HashMap<>();
        produitRepo.findAll().stream().forEach((pro)->produitsMap.put(pro.getId(), pro.getLabel()));
        model.addAttribute("produits", produitsMap);
        model.addAttribute("inputs", inRepo.findAll());
        return "entree";
    }

    @GetMapping("sortie")
    public String Outdex(Model model)
    {
        Map<String, String> produitsMap = new HashMap<>();
        produitRepo.findAll().stream().forEach((pro)->produitsMap.put(pro.getId(), pro.getLabel()));
        model.addAttribute("produits", produitsMap);
        model.addAttribute("outputs", outRepo.findAll());
        return "sortie";
    }

    @PostMapping("entree")
    public String Post(Input input)
    {
        input.setDate(LocalDate.now());
        inRepo.save(input);
        return "redirect:/";
    }

    @PostMapping("sortie")
    public String Delete(Output output)
    {
        output.setDate(LocalDate.now());
        outRepo.save(output);
        return "redirect:/";
    }
}
