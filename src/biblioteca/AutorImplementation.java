package biblioteca;

//ROLE, sobreposição incompleta
public class AutorImplementation implements AutorMixin {
    private String biografia;

    public AutorImplementation(String biografia){
        super();
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
