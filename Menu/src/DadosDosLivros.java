import java.io.Serializable;
import java.util.Objects;

public class DadosDosLivros implements Serializable {

    private String nomeDoLivro;
    private String nomeAutor;
    private  int diaQueDepositou;

    public DadosDosLivros(String nomeDoLivro, String nomeAutor, int diaQueDepositou){
        this.nomeDoLivro = nomeDoLivro;
        this.nomeAutor = nomeAutor;
        this.diaQueDepositou = diaQueDepositou;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DadosDosLivros dadosDosLivros)) return false;
        return diaQueDepositou == dadosDosLivros.diaQueDepositou && Objects.equals(nomeDoLivro, dadosDosLivros.nomeDoLivro) && Objects.equals(nomeAutor, dadosDosLivros.nomeAutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeDoLivro, nomeAutor, diaQueDepositou);
    }

    public String getNomeDoLivro() {
        return nomeDoLivro;
    }

    public void setNomeDoLivro(String nomeDoLivro) {
        this.nomeDoLivro = nomeDoLivro;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public int getDiaQueDepositou() {
        return diaQueDepositou;
    }

    public void setDiaQueDepositou(int diaQueDepositou) {
        this.diaQueDepositou = diaQueDepositou;
    }

    @Override
    public String toString() {
        return  "\nNome do Livro: " + nomeDoLivro + "\nNome Do Autor: " + nomeAutor + "\nDia Que Depositou: " + diaQueDepositou;
    }
}
