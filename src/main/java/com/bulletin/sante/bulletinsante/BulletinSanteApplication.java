package com.bulletin.sante.bulletinsante;

import com.bulletin.sante.bulletinsante.models.Profile;
import com.bulletin.sante.bulletinsante.models.Utilisateur;
import com.bulletin.sante.bulletinsante.repositories.ProfileRepository;
import com.bulletin.sante.bulletinsante.services.UtilisateurService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BulletinSanteApplication extends SpringBootServletInitializer {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        setRegisterErrorPageFilter(false);
        return application.sources(BulletinSanteApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BulletinSanteApplication.class, args);
    }

    @Bean
    InitializingBean utilisateur() {
        return () -> {
            try {
                Profile profile = new Profile();
                Utilisateur utilisateur = new Utilisateur();

                profile.setId(1L);
                profile.setLibelle("Admin");
                profileRepository.save(profile);

                utilisateur.setId(1L);
                utilisateur.setProfile(profile);
                utilisateur.setTelephone("+221774315331");
                utilisateur.setAdresse("Dakar");
                utilisateur.setPrenom("Mouhamed");
                utilisateur.setNom("NDOYE");
                utilisateur.setPassword("admin@123");
                utilisateur.setEmail("admin@mail.com");
                utilisateurService.addUser(utilisateur);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
