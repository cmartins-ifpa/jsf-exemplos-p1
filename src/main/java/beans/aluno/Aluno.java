package beans.aluno;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Aluno {
	private String nome;
	private Date dataNascimento;
	private Curso curso;
	private int idade;

	public Aluno() {
		// inicializa um curso
		this.curso = Curso.instanciaCursoPadrao();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public int getIdade() {
		this.idade = calculaIdade(this.dataNascimento);
		return this.idade;
	}
	
	private static int calculaIdade(java.util.Date dataNasc) {
		Calendar dataNascGregCalendar = new GregorianCalendar();
		dataNascGregCalendar.setTime(dataNasc);

		// Cria um objeto calendar com a data atual
		Calendar dtHoje = Calendar.getInstance();

		// Obtém a idade baseado no ano
		int anosIdade = dtHoje.get(Calendar.YEAR) - dataNascGregCalendar.get(Calendar.YEAR);
		dataNascGregCalendar.add(Calendar.YEAR, anosIdade);

		// se a data de hoje é antes da data de Nascimento, então diminui 1(um)
		if (dtHoje.before(dataNascGregCalendar)) {
			anosIdade--;
		}
		return anosIdade;
	}

}
