import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class GravarLivros {

    private final String arquivosDosLivros;
    public GravarLivros(){
        this.arquivosDosLivros = "C:\\Users\\naelb\\Estudo\\Java\\Menu\\src\\DadosDosLivros.dat";
    }
    public GravarLivros(String arquivosDosLivros ){
        this.arquivosDosLivros = arquivosDosLivros;
    }

    public void gravaLivro(Collection<DadosDosLivros> dadosDosLivros) throws IOException{
        try(ObjectOutputStream gravarLivros= new ObjectOutputStream(new FileOutputStream(this.arquivosDosLivros))){
            ArrayList<DadosDosLivros> perfumesNovos = new ArrayList<>(dadosDosLivros);
            gravarLivros.writeObject(perfumesNovos);

        }
    }

    public Collection<DadosDosLivros> recuperaLivro() throws IOException {
        try (ObjectInputStream gravarLivros= new ObjectInputStream(new FileInputStream(arquivosDosLivros))){
            ArrayList<DadosDosLivros> LivrosRecuperados = (ArrayList<DadosDosLivros>) gravarLivros.readObject();
            return LivrosRecuperados;
        }catch (ClassNotFoundException e){
            throw  new IOException(e);
        }


    }

}

