package net.pryszawa.usvc.demo.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.authorizeHttpRequests { authz -> authz
            .antMatchers(HttpMethod.GET, "/actuator", "/actuator/**", "/favicon.ico", "/swagger-ui/**", "/swagger-ui.html", "/v3/api-docs/**").permitAll()
            .anyRequest().hasAuthority("SCOPE_full-scope") // SCOPE_ prefix is necessary when checking scopes
        }.oauth2ResourceServer { oauth2 -> oauth2
            .jwt()
        }
    }

}