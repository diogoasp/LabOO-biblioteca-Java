package biblioteca;

import java.util.Calendar;

public class Emprestimo extends DomainObject {
    private Calendar inicio;
    private Calendar previsaoEntrega;
    private Calendar entrega;
    private Aluno aluno;
    private Publicacao publicacao;
    private int numeroPublicacoes = 0;

    public Emprestimo(long id, Publicacao publicacao, int numeroPublicacoes, Aluno aluno, Calendar previsaoEntrega){
        super(id);
        inicio = Calendar.getInstance();
        this.atualizarPrevisaoDeEntrega(previsaoEntrega);
        this.atualizarAluno(aluno);
        this.atualizarPublicacao(publicacao);
        this.atualizarNumeroPublicacoes(numeroPublicacoes);
    }

    public final void atualizarAluno(Aluno aluno){
        if(aluno == null)
            throw new IllegalArgumentException("O aluno não pode ser nulo!");
        this.aluno = aluno;
    }

    public final void atualizarPublicacao(Publicacao publicacao){
        if(publicacao == null)
            throw new IllegalArgumentException("A publicação não pode ser nulo!");
        this.publicacao = publicacao;
    }

    //Acho que exagerei aqui... Estava divagando sobre as possibilidades
    public final void atualizarNumeroPublicacoes(int numeroExemplaresEmprestados){
        if(numeroExemplaresEmprestados<1)
            throw new IllegalArgumentException("O número de exemplares emprestado não pode ser menor do que 1.");
        if(this.numeroPublicacoes != 0)
            publicacao.entregarExemplaresEmprestados(this.numeroPublicacoes);
        this.numeroPublicacoes = numeroExemplaresEmprestados;
        publicacao.emprestarExemplares(this.numeroPublicacoes);
    }

    public final void atualizarPrevisaoDeEntrega(Calendar data){
        if(data == null)
            throw new IllegalArgumentException("Deve existir uma previsão de entrega.");
        if(this.inicio.compareTo(data)<=0)
            throw new IllegalArgumentException("A data da entrega deve ser no futuro em relação a de início.");
        this.previsaoEntrega = (Calendar) data.clone();
    }

    public int obterDiasEmAtraso(){
        DateManagement date = new DateManagement();
        Calendar firstDate = (Calendar) previsaoEntrega.clone();
        return date.daysBetweenDates(firstDate, Calendar.getInstance());
    }

    private void atualizarEntrega(Calendar data){
        if(data == null)
            throw new IllegalArgumentException("A data de entrega não pode ser nula.");
        if(this.inicio.compareTo(data)<=0)
            throw new IllegalArgumentException("A data da entrega deve ser no futuro em relação a de início.");
        this.entrega = (Calendar) data.clone();
    }

    public void entregarEmprestimo(Calendar entrega){
        this.atualizarEntrega(entrega);
        publicacao.entregarExemplaresEmprestados(this.numeroPublicacoes);
    }

    public Aluno obterAluno(){
        return this.aluno;
    }

    public Calendar obterPrevisaoEntrega(){
        return (Calendar) this.previsaoEntrega.clone();
    }

    public Calendar obterEntrega(){
        return (Calendar) this.entrega.clone();
    }

    public Calendar obterInicio(){
        return (Calendar) this.inicio.clone();
    }
}
