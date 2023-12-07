package projeto_tarefas;

import java.util.ArrayList;

public class TarefaConjunta extends Tarefa{
	
	private ArrayList<Responsavel> responsaveis;

	public TarefaConjunta(String nome, boolean concluida, int prioridade, ArrayList<Responsavel> responsaveis) {
		super(nome, concluida, prioridade);
		
		try {
			if (responsaveis.size() != 0) {
				this.responsaveis = responsaveis;
			} else {
				throw new Error("Esta tarefa precisa de pelo menos 1 responsavel.");
			}
		} catch (Exception e) {
			throw new Error(e.getMessage());
		}
	}

	public ArrayList<Responsavel> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(ArrayList<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}
	
	public void adicionarResponsavel(Responsavel responsavel) {
		responsaveis.add(responsavel);
	}
	
	public void removerResponsavel(Responsavel responsavel) {
		responsaveis.remove(responsavel);
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
	public void verTarefa() {
		
		System.out.println("Descrição: " + nome);
		String status = null;
		
		if (concluido) {
			status = "Concluído";
		} else {
			status = "Pendente";
		}
		
		System.out.println("Status: " + status);
		System.out.println("Responsaveis: ");
		for(Responsavel responsavel : responsaveis) {
			System.out.println(responsavel.getNome() + " Cargo: " + responsavel.getCargo());
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
			throw new Error("O valor de prioridade deve ser 0 ou 1");
		}
	}
	
	@Override
	public String verPrioridade() {
		String stringPrioridade = null;
		if (prioridade == 0){
			stringPrioridade = "Padrão";
		} else if (prioridade == 1) {
			stringPrioridade = "Urgente";
		}
		
		return stringPrioridade;
	}
}
