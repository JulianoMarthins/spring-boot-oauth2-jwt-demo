package com.devsuperior.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Criação da função para criptografar dados
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());

        // http.csrf(AbstractHttpConfigurer::disable);

        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        return http.build();
    }

    /*
            Quando criada a dependência Maven para a segurança "OAuth2", automaticamente todas as rotas serão
            restritas no sistema, para liberadas é preciso criar este arquivo de configuração, a mesma está na terceira
            linha da função filterChain.

            A primeira linha da função desabilita a proteção do tipo "CSRF", este ataca pode gravar dados na sessão,
            está é uma vulnerabilidade onde o invasor pode acessar informações indevidas no sistema.

            A API que estamos construíndo disponibiliza dados controlados e não é capaz de guardar dados em sessão,
            o tornando assim, inacessível a este tipo de ataque.

            A segunda linha da função tem a mesma função da primeira, está comentada para causar inatividade, pois
            quero mantê-la para fins didáticos

            A terceira linha da função é uma autorização para a configuração dos end-points criados por mim nesta API,
            nesta estou permitindo que todas as requisições tenham acesso permitido, somente na classe dos controladores
            que haverá as configurações diretas em cada rota, limitando acesso às rotas específicas.
     */


}
