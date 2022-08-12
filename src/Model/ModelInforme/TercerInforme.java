package Model.ModelInforme;

import Model.ConsultaInformes;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TercerInforme extends AbstractTableModel {

    private List<Object[]> _informe = new ArrayList();
    private final String[] COLUMN_NAMES = {"ID Compra","Constructora","Banco Vinculado"};
    private ConsultaInformes _consulta = new ConsultaInformes();

    public TercerInforme(){
        GetValues();
    }

    private void GetValues(){
        var result = _consulta.GetResultTercerInforme();

        try{
            while (result.next()){
                Object[] row = {
                        result.getInt("ID_Compra"),
                        result.getString("Constructora"),
                        result.getString("Banco_Vinculado")
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
