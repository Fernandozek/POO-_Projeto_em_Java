
package Dao;

import model.Colaborador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;
import java.sql.ResultSet;
public class ColaboradorDAO {
    
    private final Connection connection;

    public ColaboradorDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void inset(Colaborador colaborador) throws SQLException{
       
        String sql = "insert into colaborador(cpf,email,celular) values(?,?,?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, colaborador.getCpf());
        statement.setString(2, colaborador.getEmail());
        statement.setString(3, colaborador.getCelular());
        statement.execute();
    }
    public void delete(Colaborador colaborador) throws SQLException{
        String sql = "delete from colaborador where id_usuario = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
       
        statement.setInt(1, colaborador.getId());
        statement.execute();
    }
    
    public void update (Colaborador colaborador, int id) throws SQLException{
        String sql = "update colaborador set cpf = ?, email = ?, celular = ? where id_usuario = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, colaborador.getCpf());
        statement.setString(2, colaborador.getEmail());
        statement.setString(3, colaborador.getCelular());
        statement.setInt(4, id-1);
        statement.execute();
    }
    public ArrayList<Colaborador> selectAll() throws SQLException{
        String sql = "select * from colaborador";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        return pesquisa(statement);
    }

    private ArrayList<Colaborador> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
        
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            String cpf = resultSet.getString("cpf");
            String email = resultSet.getString("email");
            String celular = resultSet.getString("celular");
            
            Colaborador colaboradorComDadosDoBanco = new Colaborador(cpf, email, celular);
            colaboradores.add(colaboradorComDadosDoBanco);
        }
        
        return colaboradores;
    }
    
    
}

