package Model;

import Tools.JDBCUtilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaInformes {
    private Connection _connection = null;
    private Statement _statement = null;
    private ResultSet _result;

    public ConsultaInformes(){
        try{
            this._connection = JDBCUtilities.getConnection();
            this._statement=this._connection.createStatement();
        }catch (SQLException e){

        }
    }

    private void QueryPrimerInforme(){
        try{
            String query = "select ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia\n" +
                    "from Lider\n" +
                    "order by Ciudad_Residencia";

            this._result = this._statement.executeQuery(query);


        }catch (SQLException e){

        }

    }

    public ResultSet GetResultPrimerInforme(){
        QueryPrimerInforme();
        return this._result;
    }

    private void QuerySegundoInforme(){
        try{
            String query = "select ID_Lider, Constructora, Numero_Habitaciones, Ciudad\n" +
                    "from Proyecto\n" +
                    "where Proyecto.Clasificacion = 'Casa Campestre' and Ciudad in ('Cartagena','Santa Marta','Barranquilla')";

            this._result = this._statement.executeQuery(query);


        }catch (SQLException e){

        }

    }

    public ResultSet GetResultSegundoInforme(){
        QuerySegundoInforme();
        return this._result;
    }

    private void QueryTercerInforme(){
        try{
            String query = "select ID_Compra,Constructora, Banco_Vinculado\n" +
                    "from Compra\n" +
                    "inner join Proyecto on Compra.ID_Proyecto = Proyecto.ID_Proyecto\n" +
                    "where proveedor = 'Homecenter' and Ciudad = 'Salento'";
            this._result = this._statement.executeQuery(query);



        }catch (SQLException e){

        }
    }

    public  ResultSet GetResultTercerInforme(){
        QueryTercerInforme();
        return this._result;
    }
}
