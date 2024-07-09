import java.util.*;
import java.util.stream.Collectors;

public class GerenciadorAlunos {

    private Map<String, Aluno> alunos;

    public GerenciadorAlunos() {
        this.alunos = new HashMap<>();
        alunos.put("Morty", new Aluno("Morty", 86.3));
        alunos.put("Rick", new Aluno("Rick", 92.5));
        alunos.put("Summer", new Aluno("Summer", 78.4));
        alunos.put("Beth", new Aluno("Beth", 88.7));
        alunos.put("Jerry", new Aluno("Jerry", 70.2));

    }

    public String getNotaAluno(String nome) {
        Aluno aluno = this.alunos.get(nome);
        if (aluno != null) return "Nota de "+aluno.getNome()+ ": "+aluno.getNota();
        else return "Aluno"+nome+" não encontrado";
    }

    public List<String> filtrarAlunosPorNota(double notaMinima){
        return alunos.values().stream()
                .filter(aluno -> aluno.getNota() > notaMinima)
                .map(Aluno::getNome)// referencia de método
                .collect(Collectors.toList()); // colletor coleta e transforma em lista
    }

    public List<Aluno> removerAlunosPorNota(double notaMinima){
        List<Aluno> removidos = new ArrayList<>();

        this.alunos.values().removeIf(aluno -> {
            if(aluno.getNota() > notaMinima) {
                removidos.add(aluno);
                return true;
            }
            return false;
        });

        return removidos;
    }

    public  Map<String, Aluno> classificarAlunosPorNota() {
        Map<String, Aluno> alunosOrdenados = new LinkedHashMap<>();
        alunos.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e1.getValue().getNota(), e2.getValue().getNota()))
                .forEach(aluno -> alunosOrdenados.put(aluno.getKey(), aluno.getValue()));

        return alunosOrdenados;
    }

    //   public static void exibirAlunosOrdenadosPorNota(Map<String, Aluno> alunos) {
//
//        List<Map.Entry<String, Aluno>> listaDeEntradas = new ArrayList<>(alunos.entrySet());
//        listaDeEntradas.sort((entry1, entry2) -> Double.compare(entry2.getValue().getNota(), entry1.getValue().getNota()));
//
//        for (Map.Entry<String, Aluno> entry : listaDeEntradas) {
//            System.out.println(entry.getValue());
//        }
//    }
}
