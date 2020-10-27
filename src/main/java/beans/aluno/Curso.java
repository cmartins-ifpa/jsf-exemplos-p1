package beans.aluno;

import java.math.BigDecimal;

public class Curso {
    private String nome;
    private BigDecimal valor;
	

	public static Curso instanciaCursoPadrao() {
		Curso cursoPadrao = new Curso("Java Básico", new BigDecimal(100f));
		return cursoPadrao;
	}
    
	public Curso() {};
	
    public Curso(String nome, BigDecimal valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValor() {
		if (this.nome.equalsIgnoreCase("Java Básico") ) {
            this.valor = new BigDecimal(100f);			
		} else
			if (this.nome.equalsIgnoreCase("Java Web") ) {
	            this.valor = new BigDecimal(130f);			
			} else
				if (this.nome.equalsIgnoreCase("JSF") ) {
		            this.valor = new BigDecimal(250f);			
				} 
		return this.valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
