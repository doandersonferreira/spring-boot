package br.com.doandersonferreira.forum.config.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.doandersonferreira.forum.model.Usuario;
import br.com.doandersonferreira.forum.repository.UsuarioRepository;

// Filter responsavel por, a cada request, validar tokens e autorizar usuarios
// Uma vez que a API stateless, o procedimento de validacao deve ser realizado por request
public class AutenticacaoViaTokenFilter extends OncePerRequestFilter{

	private TokenService tokenService;
	private UsuarioRepository repository;
	
	public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioRepository repository) {
		this.tokenService = tokenService;
		this.repository = repository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// Recupera o token informado no cabecalho da requisicao
		String token = recuperarToken(request);
	
		// Valido o token
		boolean valido = tokenService.isTokenValido(token);

		if(valido) {
			// Forca a autenticacao pelo Spring
			autenticarCliente(token);
		}
		
		
		// Segue o fluxo da requisicao
		filterChain.doFilter(request, response);
	}

	private void autenticarCliente(String token) {

		Long idUsuario = tokenService.getIdUsuario(token);
		Usuario usuario = repository.findById(idUsuario).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;			
		}
		
		return token.substring(7, token.length());
	}

}
