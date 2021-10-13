package biblioteca;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
//SUB-KIND
public class Livro extends Publicacao {
    private String ISBN;
    private Set<Autor> autores;

    public Livro(long id, String titulo, int numExemplares, Area area, String ISBN){
        super(id, titulo, numExemplares, area);
		this.autores = new HashSet<Autor>();
        this.atualizarISBN(ISBN);
    }

	private void atualizarISBN(String isbn){
        if(isbn == null || isbn.trim().isEmpty())
            throw new IllegalArgumentException("O ISBN passado não pode ser nulo ou vazio.");
        this.ISBN = isbn;
    }

    public int getNumeroDeAutores()
	{
		return this.autores.size();
	}

    public final void adicionarAutor(Autor autor)
	{
		if (autor == null)
			throw new IllegalArgumentException("Autor não pode ser nulo!");
		this.autores.add(autor);
	}

    public void removerAutor(Autor autor)
	{
		if (autor == null) 
            return;
		this.autores.remove(autor);
	}

    public Iterator<Autor> autores()
	{
		return Collections.unmodifiableSet(this.autores).iterator();
	}

    public String obterISBN(){
        return this.ISBN;
    }
}
