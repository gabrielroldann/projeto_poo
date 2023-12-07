package projeto_tarefas;

public class TarefaSimples extends Tarefa {

	private Responsavel responsavel;
	
	public TarefaSimples(String nome, boolean concluido, int prioridade, Responsavel responsavel) {
		super(nome, concluido, prioridade);
		this.responsavel = responsavel;
	}
	
	@Override
	public void verTarefa() {
		System.out.println("Descrição: " + nome);
		String status = null;
		
		if (concluido) {
			status = "Concluído";
		} else {
			status = "Pendente";
		}
		
		System.out.println("Status: " + status);
		System.out.println("Prioridade: " + verPrioridade());
		System.out.println("Responsável: " + responsavel.getNome());
		System.out.println("Cargo do Responsável: " + responsavel.getCargo());
	}
	
	@Override
	public void estadoTarefa() {
		if (!concluido) {
			concluido = true;
		} else {
			concluido = false;
		}
	}
	
	@Override
	public void definirPrioridade(int prioridade) {
		try {
			if (prioridade == 1) {
				this.prioridade = 1;
			} else {
				this.prioridade = 0;
			}
		} catch (Exception e) {
			throw new Error(e + "\nO valor da prioridade deve ser 0 ou 1.");
		}
	}
	
	@Override
	public String verPrioridade() {
		String stringPrioridade = null;
		if (prioridade == 0){
			stringPrioridade = "Não Urgente";
		} else if (prioridade == 1) {
			stringPrioridade = "Urgente";
		}
		
		return stringPrioridade;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	
	
}
