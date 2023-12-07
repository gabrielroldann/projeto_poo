package projeto_tarefas;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		// Instanciando responsaveis
		Responsavel gabriel = new Responsavel("Gabriel", "Dev. Junior");
		Responsavel rommel = new Responsavel("Rommel", "Dev. Senior");
		gabriel.verResponsavel();
		System.out.println();
		rommel.verResponsavel();
		
		// Criando lista de responsaveis
		ArrayList<Responsavel> responsaveis = new ArrayList<Responsavel>();
		responsaveis.add(gabriel);
		responsaveis.add(rommel);
		
		System.out.println();
		// Instanciando tarefas
		Tarefa tarefa01 = new TarefaSimples("Codigo AV3 em Java", false, 1, gabriel);
		Tarefa tarefa02 = new TarefaSimples("Programa Containers", false, 0, rommel);
		// Tarefa tarefa03 = new TarefaConjunta("Corrigir Código AV3", false, 0, new ArrayList<Responsavel>());
		Tarefa tarefa03 = new TarefaConjunta("Corrigir Código AV3", false, 0, responsaveis);
		tarefa01.verTarefa();
		System.out.println();
		tarefa02.verTarefa();
		System.out.println();
		tarefa03.verTarefa();
		
		// Concluindo tarefa
		System.out.println();
		tarefa02.estadoTarefa();
		tarefa02.verTarefa();
		
		// Criando lista de tarefas
		ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
		tarefas.add(tarefa01);
		tarefas.add(tarefa02);
		tarefas.add(tarefa03);
		
		// Instanciando um projeto
		Projeto projetoUnifor = new Projeto("Projeto Unifor", tarefas, responsaveis, false, 1);
		System.out.println();
		projetoUnifor.verProjeto();
		
		// Adicionando uma tarefa com metodo
		projetoUnifor.adicionarTarefa(new TarefaSimples("Revisar Código AV3", false, 1, gabriel));
		System.out.println();
		projetoUnifor.verProjeto();
		
		// Definindo prioridade com metodo
		projetoUnifor.definirPrioridade(0);
		System.out.println();
		projetoUnifor.verProjeto();
		
		Tarefa tarefaSimples02 = new TarefaConjunta("Concluir Código AV3 em Java", false, 0, responsaveis);
		projetoUnifor.adicionarTarefa(tarefaSimples02);
		System.out.println();
		projetoUnifor.verProjeto();
		projetoUnifor.removerTarefa(tarefaSimples02);
		System.out.println();
		projetoUnifor.verProjeto();
		
	}
}
