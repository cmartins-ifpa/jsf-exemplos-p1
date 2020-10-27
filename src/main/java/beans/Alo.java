package beans;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Alo {
    private String nome;
    private String mensagem;

    public void criaMensagem() {
        mensagem = "Alô, " + nome + "!";
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMensagem() {
		return mensagem;
	}
}
