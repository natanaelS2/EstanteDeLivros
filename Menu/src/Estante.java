import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Estante implements InterfaceDeLivros {

    private Map<String, DadosDosLivros> LivroMap;

    public Estante(){
        this.LivroMap = new HashMap<>();
    }


    @Override
    public boolean cadastraLivross(String nomeLivro, String NomeAutor, int diaDeixadoLivro) {
        if (!this.LivroMap.containsKey(NomeAutor)){
            this.LivroMap.put(NomeAutor,new DadosDosLivros(nomeLivro, NomeAutor, diaDeixadoLivro));
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Collection<DadosDosLivros> pesquisaLivros(String nomeLivro, String NomeAutor) {
        Collection<DadosDosLivros> dadosDosLivros = new ArrayList<>();
        for (DadosDosLivros p : this.LivroMap.values()){
            if (p.getNomeDoLivro().equals(nomeLivro) && p.getNomeAutor().equals(NomeAutor)){
                dadosDosLivros.add(p);
            }

        }
        return dadosDosLivros;
    }

    @Override
    public boolean removeLivro(String NomeAutor){
        if (this.LivroMap.containsKey(NomeAutor)){
            this.LivroMap.remove(NomeAutor);
            return true;
        }else {
            return false;
        }
    }
    public Collection<DadosDosLivros> getLivros(){
         return this.LivroMap.values();
    }
    public void setLivross(Collection<DadosDosLivros> dadosDosLivros) {
        for (DadosDosLivros p : dadosDosLivros) {
                this.LivroMap.put(p.getNomeAutor(), p);
        }
    }
}

