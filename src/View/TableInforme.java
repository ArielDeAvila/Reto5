package View;

import Model.ModelInforme.PrimerInforme;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class TableInforme extends JPanel {

    public TableInforme(AbstractTableModel tableModel){
        setLayout(new BorderLayout());
        JTable tabla = new JTable(tableModel);
        JScrollPane panel = new JScrollPane(tabla);
        add(panel,BorderLayout.CENTER);
    }
}
