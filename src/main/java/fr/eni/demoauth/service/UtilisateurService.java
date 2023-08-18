package fr.eni.demoauth.service;

import fr.eni.demoauth.bo.Role;
import fr.eni.demoauth.bo.Utilisateur;
import fr.eni.demoauth.repository.UtilisateurRepository;
import fr.eni.demoauth.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("**********************************************");

        return utilisateurRepository.findByUsername(username);
    }

    public List<Role> allRoles(){
        return roleRepository.findAll();
    }

    public void saveUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }


}
