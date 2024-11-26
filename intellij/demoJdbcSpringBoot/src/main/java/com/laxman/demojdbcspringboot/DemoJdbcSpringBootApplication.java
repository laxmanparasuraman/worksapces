package com.laxman.demojdbcspringboot;

import com.laxman.demojdbcspringboot.model.Alien;
import com.laxman.demojdbcspringboot.model.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoJdbcSpringBootApplication {



    public static void main(String[] args) {

        ApplicationContext context= SpringApplication.run(DemoJdbcSpringBootApplication.class, args);

        Alien alien=context.getBean(Alien.class);
        alien.setId(1);
        alien.setName("Laxman");
        alien.setTech("java spring bot");
        AlienRepo alienRepo=context.getBean(AlienRepo.class);
        alienRepo.save(alien);
        System.out.println(alienRepo.findAll());

//144.34

    }

}
