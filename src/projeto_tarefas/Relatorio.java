package projeto_tarefas;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Relatorio {
	void lerTarefaSimples(String filename) throws FileNotFoundException;
	void exportarTarefas(String filename) throws IOException;
	void exportarProjeto(String filename) throws IOException;
}
