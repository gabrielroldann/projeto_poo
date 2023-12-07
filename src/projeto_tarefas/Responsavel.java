package projeto_tarefas;

public class Responsavel {
	
	private String nome;
	private String cargo;
	
	public Responsavel(String nome, String cargo) {
		this.nome = nome;
		this.cargo = cargo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public void verResponsavel() {
		System.out.println("Nome: " + nome);
		System.out.println("Cargo: " + cargo);
	}
}
