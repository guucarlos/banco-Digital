package bancoDigital;

public class Cliente {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cliente(String nome) {
		this.nome = nome != null ? nome: "Cliente sem nome";
	}

	public Cliente() {
	}
	
	
	

}
