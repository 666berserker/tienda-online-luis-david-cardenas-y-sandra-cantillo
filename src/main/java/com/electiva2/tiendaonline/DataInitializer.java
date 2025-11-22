
package com.electiva2.tiendaonline;

import com.electiva2.tiendaonline.model.Usuario;
import com.electiva2.tiendaonline.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            for (Usuario u : usuarioRepository.findAll()) {
                String pwd = u.getContrasena();
                if (pwd != null && !pwd.startsWith("$2a$")) {
                    u.setContrasena(passwordEncoder.encode(pwd));
                    usuarioRepository.save(u);
                }
            }
        };
    }
}
