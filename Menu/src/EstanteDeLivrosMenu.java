import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Collection;

public class EstanteDeLivrosMenu extends JFrame {
    JLabel linha1, linha2;
    JMenuBar barraDeMenu = new JMenuBar();
    ImageIcon imagem = new ImageIcon();
    InterfaceDeLivros interfaceDeLivros = new Estante();
    GravarLivros gravador = new GravarLivros();

    public EstanteDeLivrosMenu(){

        try {
            Collection<DadosDosLivros> dadosDosLivrosRecuperados = gravador.recuperaLivro();
            interfaceDeLivros.setLivross(dadosDosLivrosRecuperados);
            for (DadosDosLivros p : dadosDosLivrosRecuperados){
                JOptionPane.showMessageDialog(null,"DadosDosLivros:" + p.getNomeDoLivro());
            }

        }catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Problema ao recuperar o Livros");
            e.printStackTrace();
        }
        setTitle("Estante de Livros");
        setSize(800,600);
        setLocation(150,150);
        setResizable(true);
        setBackground(Color.WHITE);
        linha1 = new JLabel("Minha Estante de Livros",JLabel.CENTER);
        linha1.setForeground(Color.BLACK);
        linha1.setFont(new Font("Serif",Font.BOLD,24));
        linha2 = new JLabel(imagem,JLabel.CENTER);
        setLayout(new GridLayout(3, 1));
        add(linha1);
        add(linha2);
        add(new JLabel());

        JMenu menuCadastra = new JMenu("Cadastra");
        JMenuItem menuCadastraLivro = new JMenuItem("Cadastra Livro");
        menuCadastra.add(menuCadastraLivro);

        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuRemoverLivro = new JMenuItem("Pesquisar Livro");
        menuPesquisar.add(menuRemoverLivro);

        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuPesquisarLivro = new JMenuItem("Remover Livro");
        menuRemover.add(menuPesquisarLivro);

        JMenu menuSalva = new JMenu("Salva");
        JMenuItem menuSalvaLivro = new JMenuItem("Salva Livro");
        menuSalva.add(menuSalvaLivro);
        menuPesquisarLivro.addActionListener(
               new LivroRemoverController(interfaceDeLivros, this));
        menuRemoverLivro.addActionListener(
               new LivroSearchController(interfaceDeLivros,this));
        menuCadastraLivro.addActionListener(
                new LivroAddController(interfaceDeLivros,this));
        menuSalvaLivro.addActionListener((ae)->{
            try{
                gravador.gravaLivro(interfaceDeLivros.getLivros());
                JOptionPane.showMessageDialog(this,"Livro foi salvo");
            }catch (IOException e) {
                JOptionPane.showMessageDialog(this,"Problema ao gravar o Livro");
                e.printStackTrace();
            }
        });
        barraDeMenu.add(menuCadastra);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuRemover);
        barraDeMenu.add(menuSalva);
        setJMenuBar(barraDeMenu);
    }

    public static void main(String []args){
        JFrame janela = new EstanteDeLivrosMenu();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
