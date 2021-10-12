package biblioteca;

public class Revista extends Publicacao {
    private int periodicidadeEmDias;

    public Revista(long id, String titulo, int numExemplares, Area area, int periodicidadeEmDias){
        super(id, titulo, numExemplares, area);
        this.definirPeriodicidadeEmDias(periodicidadeEmDias);
    }

    public final void definirPeriodicidadeEmDias(int dias){
        if(dias<1)
            throw new IllegalArgumentException("A periodicidade não pode ser menor do que 1 (um).");
        this.periodicidadeEmDias = dias;
    }

    public int obterPeriodicidadeEmDias(){
        return this.periodicidadeEmDias;
    }
}
