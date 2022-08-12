package View;

import Controller.InformesController;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{
    InformesController controller = new InformesController();
    TableInforme tablePrimerInforme = new TableInforme(controller.GetPrimerInforme());
    TableInforme tableSegundoInforme = new TableInforme(controller.GetSegundoInforme());
    TableInforme tableTercerInforme = new TableInforme(controller.GetTercerInforme());
    JTabbedPane pestanas = new JTabbedPane();

    public MainWindow(){
        pestanas.add("Informe 1",tablePrimerInforme);
        pestanas.add("Informe 2",tableSegundoInforme);
        pestanas.add("Informe 3",tableTercerInforme);

        JFrame frame = new JFrame("Informes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(pestanas, BorderLayout.CENTER);
        frame.setSize(700, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

}
