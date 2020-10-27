package beans.login;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named ("login")
@RequestScoped
public class LoginBean {
	private String username;
	private String password;

	public void validaLogin() {
		// recupera o contexto da aplicaçao
		FacesContext context = FacesContext.getCurrentInstance();

		if (this.username.equals("admin") && this.password.equals("admin")) {
			// salva o objeto "user" em tempo de sessão 
			context.getExternalContext().getSessionMap().put("user", username);
			try {
				// redireciona para a página "home.xhtml"
				context.getExternalContext().redirect("home.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// Envia uma mensagem de erro de Login
			context.addMessage(null, new FacesMessage("Falha na Autenticação. Veja seu 'username' ou senha."));
		}
	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
		// outra forma de redirecionar para outra página 
		return "login.xhtml";
	}

	// get´s e set´s
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
