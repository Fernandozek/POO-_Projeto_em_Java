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
    
    public void insert(int codigo, double peso, int quantidade, int ml) throws SQLException, ParseException{
       
        String sql = "insert into vendas(data,colaborador,id_produto,quantidade,peso) values(?,?,?,?,?);";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "28/05/2021");
        statement.setInt(2, 1);
        statement.setInt(3, codigo);
        statement.setInt(4, quantidade);
        statement.setDouble(5, peso);
        statement.execute();
        
    }

    
}
