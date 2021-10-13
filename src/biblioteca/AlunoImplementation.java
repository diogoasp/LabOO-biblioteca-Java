package biblioteca;

//Mixin
public class AlunoImplementation implements AlunoMixin {
    private String matricula;

    public AlunoImplementation(String matricula){
        super();
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
