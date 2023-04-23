import java.util.Collection;

public interface InterfaceDeLivros {

    public  boolean cadastraLivross(String nomeLivro, String NomeAutor , int diaDeixadoLivro);
    public Collection<DadosDosLivros> pesquisaLivros(String nomeLivro, String NomeAutor);
    public boolean removeLivro(String NomeAutor);
    public Collection<DadosDosLivros> getLivros();
    public void setLivross(Collection<DadosDosLivros> dadosDosLivros);
}

