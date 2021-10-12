package biblioteca;

public class Area extends DomainObject{
    private String nome;

    public Area(long id, String nome){
        super(id);
        this.atualizarnome(nome);
    }

    public final void atualizarnome(String nome){
        if(nome == null || nome.trim().isEmpty())
            throw new IllegalArgumentException("O nome passado não pode ser nulo ou vazio.");
        this.nome = nome;
    }

    public String obterNome(){
        return this.nome;
    }
}
