import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        GerenciadorAlunos gerenciador = new GerenciadorAlunos();
        System.out.println(gerenciador.getNotaAluno("Rick"));
        System.out.println(gerenciador.getNotaAluno("Morty"));

        Map<String, List<Aluno>> alunosPorNota;
        alunosPorNota = gerenciador.agruparAlunosPorNota();
        System.out.println(alunosPorNota);
        System.out.println(alunosPorNota.get("B"));
    }
}