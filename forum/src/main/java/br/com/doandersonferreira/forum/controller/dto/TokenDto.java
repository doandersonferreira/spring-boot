package br.com.doandersonferreira.forum.controller.dto;

public class TokenDto {

	private String token;
	private String tipoAutenticacao;

	public TokenDto(String token, String tipoAutenticacao) {
		this.token = token;
		this.tipoAutenticacao = tipoAutenticacao;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setTipoAutenticacao(String tipoAutenticacao) {
		this.tipoAutenticacao = tipoAutenticacao;
	}

	public String getToken() {
		return token;
	}

	public String getTipoAutenticacao() {
		return tipoAutenticacao;
	}

}
