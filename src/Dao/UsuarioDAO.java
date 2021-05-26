
package Dao;

import model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;

public class UsuarioDAO {
    
    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Usuario usuario) throws SQLException{
       
        String sql = "insert into usuario(nome,login,senha) values(?,?,?);";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getLogin());
        statement.setString(3, usuario.getSenha());
        statement.execute();
        
    }

    public void update (Usuario usuario, int id) throws SQLException{
        String sql = "update usuario set nome = ?, login = ?, senha = ? where id_usuario = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getLogin());
        statement.setString(3, usuario.getSenha());
        statement.setInt(4, id);
        statement.execute();
    }
    
    public void insertOrUpdate(Usuario usuario) throws SQLException{
        if(usuario.getId() > 0){
            update(usuario,2);
        }else{
            insert(usuario);
        }
    }
    
    public void delete(Usuario usuario) throws SQLException{
        String sql = "delete from usuario where id_usuario = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
       
        statement.setInt(1, usuario.getId());
        statement.execute();
    }
    
    public ArrayList<Usuario> selectAll() throws SQLException{
        String sql = "select * from usuario";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        return pesquisa(statement);
    }

    private ArrayList<Usuario> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            int id = resultSet.getInt("id_usuario");
            String login = resultSet.getString("login");
            String senha = resultSet.getString("senha");
            
            Usuario usuarioComDadosDoBanco = new Usuario(id, login, senha);
            usuarios.add(usuarioComDadosDoBanco);
        }
        
        return usuarios;
    }
    
    public Usuario selectPorId(Usuario usuario) throws SQLException{
        String sql = "select * from usuario whiere id_usuario = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, usuario.getId());
 
        return pesquisa(statement).get(0);
    }
    
    public boolean existeUsuarioPorLoginESenha(Usuario usuario) throws SQLException {
        String sql = "select * from usuario where login = ? and senha = ? ";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, usuario.getLogin());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        return resultSet.next();
    }
   
}

