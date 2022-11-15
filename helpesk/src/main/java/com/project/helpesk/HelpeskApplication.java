package com.project.helpesk;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.helpesk.config.AppConstants;
import com.project.helpesk.entities.Role;
import com.project.helpesk.repositories.RoleRepo;

/**
 * @author opera_ao6omsd
 *
 */
@SpringBootApplication
public class HelpeskApplication implements CommandLineRunner {
    /**
     *
     * Protected constructor.
     */

    @Autowired
    private RoleRepo roleRepo;

    /**
     * help desk application.
     */
    protected HelpeskApplication() {
    }

    /**
     * @param args User arguments.
     */
    public static void main(final String[] args) {
        SpringApplication.run(HelpeskApplication.class, args);
    }

    /**
     * @return ModelMapper.
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(final String... args) throws Exception {


    Role role = new Role();
        role.setId(AppConstants.ADMIN_USER);
        role.setName("ADMIN");

        Role role1 = new Role();
        role1.setId(AppConstants.NORMAL_USER);
        role1.setName("EMPLOYEE");

        List<Role> roles = new ArrayList<Role>();
        roles.add(role);
        roles.add(role1);
        try {
            List<Role> result = this.roleRepo.saveAll(roles);

            result.forEach(r -> {
         System.out.print(r.getName());
            });
        } catch (Exception e) {
            System.out.println("catch e");
            }
    }
}

