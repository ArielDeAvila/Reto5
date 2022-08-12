package Model.ModelInforme;

import Model.ConsultaInformes;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SegundoInforme extends AbstractTableModel {

    private List<Object[]> _informe = new ArrayList();
    private final String[] COLUMN_NAMES = {"ID Lider","Constructora","Numero Habitaciones","Ciudad"};
    private ConsultaInformes _consulta = new ConsultaInformes();

    public SegundoInforme(){
        GetValues();
    }

    private void GetValues(){
        var result = _consulta.GetResultSegundoInforme();

        try{
            while (result.next()){
                Object[] row = {
                        result.getInt("ID_Lider"),
                        result.getString("Constructora"),
                        result.getString("Numero_Habitaciones"),
                        result.getString("Ciudad")
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
