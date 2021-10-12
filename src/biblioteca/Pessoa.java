package biblioteca;

public abstract class Pessoa extends DomainObject{
    public String nome;

    public Pessoa(long id, String nome){
        super(id);
        this.atualizarNome(nome);
    }

    private void atualizarNome(String nome){
        if(nome == null || nome.trim().isEmpty())
            throw new IllegalArgumentException("O nome passado não pode ser nulo ou vazio.");
        this.nome = nome;
    }
}
