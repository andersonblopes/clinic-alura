package med.lopes.clinic.center.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig {

    @Bean
    public SecurityFilterChain resourceServerFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/oauth2/**").authenticated()
                .and()
                .csrf().disable()
                .cors()
                .and()
                .oauth2ResourceServer().opaqueToken();

        return http.build();
    }

}
