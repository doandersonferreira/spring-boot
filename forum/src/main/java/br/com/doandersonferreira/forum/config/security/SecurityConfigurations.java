package br.com.doandersonferreira.forum.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // Habilitando o Spring Security
@Configuration // Indica ao Spring para carregar essas configuracoes ao startar a aplicacao
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{

}
