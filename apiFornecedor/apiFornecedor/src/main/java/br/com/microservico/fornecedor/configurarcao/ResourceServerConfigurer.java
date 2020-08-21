package br.com.microservico.fornecedor.configurarcao;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

	/*
	 * Caso esteja com esta implementação todas as requisições deverão ser autenticadas
	 * 
	 * @Override 
	 * public void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests() .anyRequest() .authenticated(); }
	 */
	
	@Override 
	 public void configure(HttpSecurity http) throws Exception {
	 http.authorizeRequests()
	 .antMatchers(HttpMethod.POST, "/pedido")
	 .hasRole("USER");
	}
	 
}
