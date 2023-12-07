package projeto_tarefas;

public abstract class Tarefa implements Prioridade {
	
	protected String nome;
	protected boolean concluido;
	protected int prioridade;
	
	public abstract void verTarefa();
	public abstract void estadoTarefa();

	public Tarefa(String nome, boolean concluida, int prioridade) {
		this.nome = nome;
		this.concluido = concluida;
		this.prioridade = prioridade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluida) {
		this.concluido = concluida;
	}
}
