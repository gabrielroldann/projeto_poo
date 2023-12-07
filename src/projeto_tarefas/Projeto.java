package projeto_tarefas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Projeto implements Relatorio, Prioridade {
	
	private String nomeProjeto;
	private ArrayList<Tarefa> tarefas;
	private ArrayList<Responsavel> responsaveis;
	private boolean concluido;
	private int prioridade;
	
	public Projeto(String nomeProjeto, ArrayList<Tarefa> tarefas, ArrayList<Responsavel> responsaveis, boolean concluido,
			int prioridade) {
		
		this.nomeProjeto = nomeProjeto;
		this.tarefas = tarefas;
		this.responsaveis = responsaveis;
		this.concluido = concluido;
		this.prioridade = prioridade;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}
	
	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}
	
	public ArrayList<Tarefa> getTarefas() {
		return tarefas;
	}
	
	public void setTarefas(ArrayList<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
	public ArrayList<Responsavel> getResponsaveis() {
		return responsaveis;
	}
	
	public void setResponsaveis(ArrayList<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}
	
	public boolean isConcluido() {
		return concluido;
	}
	
	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}
	
	public void verProjeto() {
		System.out.println("Nome do Projeto: " + nomeProjeto);
		
		String status = null;
		if (concluido) {
			status = "Concluído";
		} else {
			status = "Pendente";
		}
		
		System.out.println("Status: " + status);
		System.out.println("Prioridade: " + verPrioridade());
		//System.out.println("");
		System.out.println("\nTarefas: ");
		for (Tarefa tarefa : tarefas) {
			if (tarefa instanceof TarefaSimples) {
				TarefaSimples tarefaSimples = (TarefaSimples) tarefa;
				System.out.println("- TAREFA: " + tarefaSimples.getNome() + " (Simples)");
				
				Responsavel responsavelSimples = tarefaSimples.getResponsavel();
				System.out.println("- RESPONSAVEL: " + responsavelSimples.getNome()
									+ " (" + responsavelSimples.getCargo() + ")");
				System.out.println();
			} else {
				TarefaConjunta tarefaConjunta = (TarefaConjunta) tarefa;
				System.out.println("- TAREFA: " + tarefaConjunta.getNome() + " (Conjunta)");
				
				ArrayList<Responsavel> listaResponsaveisTarefa = tarefaConjunta.getResponsaveis();
				System.out.println("- RESPONSAVEIS: ");
				int i = 1;
				for (Responsavel responsavel : listaResponsaveisTarefa) {
					System.out.println("  " + i + " " + responsavel.getNome()
										+ " (" + responsavel.getCargo() + ")");
					i++;
				}
			}
			
		}
	}
	
	public void adicionarTarefa(Tarefa tarefa) {
		tarefas.add(tarefa);
	}
	
	public void removerTarefa(Tarefa tarefa) {
		tarefas.remove(tarefa);
	}
	
	public void adicionarResponsavel(Responsavel responsavel) {
		responsaveis.add(responsavel);
	}
	
	public void removerResponsavel(Responsavel responsavel) {
		responsaveis.remove(responsavel);
	}
	
	public void estadoProjeto() {
		if (!concluido) {
			concluido = true;
		} else {
			concluido = false;
		}
	}
	
	@Override
	public void definirPrioridade(int prioridade) {
	    try {
	        if (prioridade == 0 || prioridade == 1) {
	            this.prioridade = prioridade;
	        } else {
	            throw new Error("Erro ao definir uma piroridade. Prioridade deve ser 0 ou 1.");
	        }
	    } catch (Exception e) {
	        throw new Error(e.getMessage());
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
	
	public ArrayList<Tarefa> clonarTarefasProjeto() {
		ArrayList<Tarefa> tarefasNovas = (ArrayList<Tarefa>) tarefas.clone();
		return tarefasNovas;
	}
	
	@Override
	public void lerTarefaSimples(String filename) throws FileNotFoundException {
		
		try {
			File file = new File(filename);
			Scanner sc = new Scanner(file);
			
			while (sc.hasNext()) {
				String nome = sc.next();
				boolean concluido = sc.nextBoolean();
				String nomeResponsavel = sc.next();
				String cargoResponsavel = sc.next();
				Responsavel responsavel = new Responsavel(nomeResponsavel, cargoResponsavel);
				int prioridade = sc.nextInt();
				Tarefa tarefa = new TarefaSimples(nome, concluido, prioridade, responsavel);
				tarefas.add(tarefa);
			}
		} catch (Exception e) {
			throw new Error("Não foi possivel ler o arquivo.\n", e);
		}
	}
	
	@Override
	public void exportarTarefas(String filename) throws IOException {
		File file = new File(filename);
		FileWriter filewriter = new FileWriter(file);
		
		for (Tarefa tarefa : tarefas) {
			String status = null;
			if (tarefa.isConcluido()) {
				status = "Concluído";
			} else {
				status = "Pendente";
			}
			
			filewriter.write("Tarefas: \nNome da tarefa: " + tarefa.getNome() + 
							"\nStatus da tarefa: " + status +
							"\nPrioridade: " + tarefa.verPrioridade());
		}
	}
	
	@Override
	public void exportarProjeto(String filename) throws IOException {
		File file = new File(filename);
		FileWriter filewriter = new FileWriter(file);
		
		for (Tarefa tarefa : tarefas) {
			String status = null;
			if (tarefa.isConcluido()) {
				status = "Concluído";
			} else {
				status = "Pendente";
			}
			
			filewriter.write("Tarefas: \nNome da tarefa: " + tarefa.getNome() + 
							"\nStatus da tarefa: " + status +
							"\nPrioridade: " + tarefa.verPrioridade());
		}
		
		for (Responsavel responsavel : responsaveis) {
			filewriter.write("Responsaveis: \n" +responsavel.getNome() + "( Cargo: " + responsavel.getCargo() + ")\n");
		}
	}
}
