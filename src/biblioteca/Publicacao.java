package biblioteca;

public abstract class Publicacao extends DomainObject{
    private String titulo;
    private int numExemplares;
    private int numExemplaresEmprestados;
    private Area area;

    public Publicacao(long id, String titulo, int numExemplares, Area area){
        super(id);
        this.atualizarTitulo(titulo);
        this.atualizarNumExemplares(numExemplares);
        this.atualizarArea(area);
    }

    public final void atualizarTitulo(String titulo){
        if(titulo == null || titulo.trim().isEmpty())
            throw new IllegalArgumentException("O titulo passado não pode ser nulo ou vazio.");
        this.titulo = titulo;
    }

    public final void atualizarArea(Area area){
        if(area == null)
            throw new IllegalArgumentException("Área não pode ser nula.");
        this.area = area;
    }

    public int obterNumExemplaresDisponiveis(){
        return this.numExemplares - this.numExemplaresEmprestados;
    }

    public int obterNumExemplares(){
        return this.numExemplares;
    }

    public final void atualizarNumExemplares(int numExemplares){
        if(numExemplares<0)
            throw new IllegalArgumentException("O número de exemplares não pode ser inferior a zero.");
        this.numExemplares = numExemplares;
    }

    public void entregarExemplaresEmprestados(int numeroExemplaresEntregues){
        if((this.obterNumExemplaresDisponiveis()+numeroExemplaresEntregues)>this.numExemplares)
            throw new IllegalStateException("O número de exemplares disponíveis somado ao número de exemplares entregues não pode ser maior que o número de exemplares totais.");
        this.numExemplaresEmprestados += numeroExemplaresEntregues;
    }

    public void emprestarExemplares(int numeroNovosExemplaresEmprestados){
        if(this.obterNumExemplaresDisponiveis()<numeroNovosExemplaresEmprestados)
            throw new IllegalStateException("Não há exemplares disponíveis para esta operação.");
        this.numExemplaresEmprestados += numeroNovosExemplaresEmprestados;
    }

    public Area obterArea(){
        return this.area;
    }

    public String obterTitulo(){
        return this.titulo;
    }
}
