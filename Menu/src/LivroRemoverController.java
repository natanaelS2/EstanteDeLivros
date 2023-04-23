import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivroRemoverController implements ActionListener {
    private final InterfaceDeLivros interfaceDeLivros;
    private final JFrame JanelaPrincial;

    public LivroRemoverController(InterfaceDeLivros interfaceDeLivros, JFrame janelaPrincial){
        this.interfaceDeLivros = interfaceDeLivros;
        this.JanelaPrincial = janelaPrincial;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nomeAuto = JOptionPane.showInputDialog("Qual o Nome Do Autor? ");

        boolean remover = interfaceDeLivros.removeLivro(nomeAuto);
        if (remover){
            JOptionPane.showMessageDialog(JanelaPrincial,
                    "Livros removido ");
        }else {
            JOptionPane.showMessageDialog(JanelaPrincial,
                    "Livros não foi encontrado." +
                    "Operação não realizada");
        }

    }
}
