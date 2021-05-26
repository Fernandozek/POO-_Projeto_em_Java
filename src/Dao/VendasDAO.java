package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Produto;
import model.Venda;

public class VendasDAO {
    
    private final Connection connection;

    public VendasDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(String nome,double preco, double peso, int quantidade, int ml) throws SQLException, ParseException{
       
        String sql = "insert into venda(data,colaborador,quantidade,peso,produto,valor) values(?,?,?,?,?,?);";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "28/05/2021");
        statement.setString(2, "João");
        statement.setInt(3, quantidade);
        statement.setDouble(4, peso);
        statement.setString(5, nome);
        double valor = quantidade*preco;
        statement.setDouble(6, valor);
        statement.execute();
        
    }
    public ArrayList<Venda> selectAll() throws SQLException{
        String sql = "select * from venda";
        PreparedStatement statement = connection.prepareStatement(sql);

        return pesquisa(statement);
      }
    
    private ArrayList<Venda> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Venda> Vendas = new ArrayList<Venda>();
        
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            String data = resultSet.getString("data");
            String colaborador = resultSet.getString("colaborador");
            String quantidade = resultSet.getString("quantidade");
            double peso = resultSet.getDouble("peso");
            String produto = resultSet.getString("produto");
            double valor = resultSet.getDouble("valor");
            
            Venda vendaComDadosDoBanco = new Venda(data, colaborador, quantidade, peso, produto, valor);
            Vendas.add(vendaComDadosDoBanco);
        }
        
        return Vendas;
    }
}
