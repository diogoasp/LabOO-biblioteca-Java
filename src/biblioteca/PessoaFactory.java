package biblioteca;

public abstract class PessoaFactory {

    public static Aluno obterAluno(String matricula){
        Aluno aluno = (Aluno) new AlunoImplementation(matricula);
        return aluno;
    }

    public static Autor obterAutor(String biografia){
        Autor autor = (Autor) new AutorImplementation(biografia);
        return autor;
    }

}
