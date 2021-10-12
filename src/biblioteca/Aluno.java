package biblioteca;

public class Aluno extends Pessoa {
    private String matricula;

    public Aluno(long id, String nome,String matricula){
        super(id, nome);
        this.atualizarMatricula(matricula);
    }

    private void atualizarMatricula(String matricula){
        if(matricula == null || matricula.trim().isEmpty())
            throw new IllegalArgumentException("A matrícula passado não pode ser nulo ou vazio.");
        this.matricula = matricula;
    }

    public String obterMatricula(){
        return this.matricula;
    }
}
