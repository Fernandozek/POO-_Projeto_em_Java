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

public class VendasDAO {
    
    private final Connection connection;

    public VendasDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(String nome, double peso, int quantidade, int ml) throws SQLException, ParseException{
       
        String sql = "insert into vendas(data,colaborador,quantidade,peso,produto) values(?,?,?,?,?);";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "28/05/2021");
        statement.setString(2, "João");
        statement.setInt(3, quantidade);
        statement.setDouble(4, peso);
        statement.setString(5, nome);
        statement.execute();
        
    }

    
}
