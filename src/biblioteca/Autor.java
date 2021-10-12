package biblioteca;

public class Autor extends Pessoa {
    private String biografia;

    public Autor(long id, String nome, String biografia){
        super(id, nome);
        this.atualizarBiografia(biografia);
    }

    public final void atualizarBiografia(String biografia){
        if(biografia == null || biografia.isEmpty())
            throw new IllegalArgumentException("O texto de biografia passado não pode ser nulo ou vazio.");
        this.biografia = biografia;
    }

    public String obterBiografia(){
        return this.biografia;
    }
}
