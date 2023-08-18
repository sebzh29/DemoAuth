package fr.eni.demoauth.controller;

import fr.eni.demoauth.bo.Utilisateur;
import fr.eni.demoauth.service.UtilisateurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.AttributedString;

@Controller
public class RegisterController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/inscription")
    public String index(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        model.addAttribute("roles", utilisateurService.allRoles());
        return "security/register";
    }

    @PostMapping("/inscription")
    public String register(@ModelAttribute Utilisateur utilisateur,
                           @Valid
                           BindingResult br) {
        if (br.hasErrors()) {
            return "security/register";
        }

        //encrypt mdp
        utilisateur.setPassword(passwordEncoder.encode(
                utilisateur.getPassword()
        ));

        //sauvegarde user
        utilisateurService.saveUtilisateur(utilisateur);

        return "redirect:/login";


    }
}
