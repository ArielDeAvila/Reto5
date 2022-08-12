package Model.ModelInforme;

import Model.ConsultaInformes;
import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrimerInforme extends AbstractTableModel {
    private List<Object[]> _informe = new ArrayList();
    private final String[] COLUMN_NAMES = {"ID Lider", "Nombre", "Primer Apellido","Ciudad Residencia"};
    private ConsultaInformes _consulta = new ConsultaInformes();

    public PrimerInforme() {
        GetValuesInforme();

    }
    private void GetValuesInforme(){
        var result = _consulta.GetResultPrimerInforme();

        try{
            while (result.next()){

                Object[] row = {
                        result.getInt("ID_Lider"),
                        result.getString("Nombre"),
                        result.getString("Primer_Apellido"),
                        result.getString("Ciudad_Residencia")
                };

                this._informe.add(row);

            }
        }catch (SQLException e){

        }

    }

    @Override
    public String getColumnName(int col){
        return COLUMN_NAMES[col];
    }

    @Override
    public int getRowCount() {
        return _informe.size();
    }

    @Override
    public int getColumnCount() {
        return _informe.get(0).length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return _informe.get(rowIndex)[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int
            columnIndex) {
        _informe.get(rowIndex)[columnIndex] = aValue;
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int
            columnIndex) {
        return true;
    }
}
