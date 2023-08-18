package fr.eni.demoauth.controller;

import fr.eni.demoauth.bo.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "home/index";
    }

    @GetMapping("/mon-compte")
    public String monCompte() {
        return "dashboard/index";
    }
}
