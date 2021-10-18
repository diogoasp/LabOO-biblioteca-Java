package biblioteca;

//KIND
//Implementa as interfaces Aluno, Autor e, implicitamente, Pessoa
public class PessoaImplementation extends DomainObject implements Aluno, Autor{
    public String nome;
    //Poderia usar o Factory!
    Aluno aluno;
    Autor autor;

    public PessoaImplementation(long id, String nome){
        super(id);
        this.aluno = null;
        this.autor = null;
        this.atualizarNome(nome);
    }

    public final void atualizarNome(String nome){
        if(nome == null || nome.trim().isEmpty())
            throw new IllegalArgumentException("O nome passado não pode ser nulo ou vazio.");
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    public boolean isAluno(){
        return this.aluno != null;
    }

    public boolean isAutor(){
        return this.autor != null;
    }

    public void sejaUmAluno(String matricula){
        if(this.isAluno())
            throw new IllegalStateException("Já sou Aluno.");
        this.aluno = PessoaFactory.obterAluno(matricula);
    }
    public void sejaUmAutor(String biografia){
        if(this.isAutor())
            throw new IllegalStateException("Já sou Autor.");
        this.autor = PessoaFactory.obterAutor(biografia);
    }

    @Override
    public void atualizarBiografia(String biografia) {
        if(!this.isAutor())
            throw new IllegalStateException("Não sou Autor.");
        this.autor.atualizarBiografia(biografia);
    }

    @Override
    public String obterBiografia() {
        if(!this.isAutor())
            throw new IllegalStateException("Não sou Autor.");
        return this.autor.obterBiografia();
    }

    @Override
    public String obterMatricula() {
        if(!this.isAluno())
            throw new IllegalStateException("Não sou Aluno.");
        return this.aluno.obterMatricula();
    }


}
