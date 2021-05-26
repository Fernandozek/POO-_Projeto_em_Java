
package controller;

import Dao.ColaboradorDAO;
import Dao.UsuarioDAO;
import View.CadastrarColaborador;
import Dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Colaborador;
import model.Usuario;

public class FormColaboradorController {
    private CadastrarColaborador view;

    public FormColaboradorController(CadastrarColaborador view) {
        this.view = view;
    }
        
    public void salvaColaborador(){
        
        
        String nome = view.getjTextFieldNome().getText();
        String cpf = view.getjTextFieldCpf().getText();
        String email = view.getjTextFieldEmail().getText();
        String celular = view.getjTextFieldCelular().getText();
        String login = view.getjTextFieldLogin().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        
        Colaborador colaborador =  new Colaborador(cpf, email, celular);
        Usuario usuario = new Usuario(nome, login, senha);
        
        try {
            Connection conexao = new Conexao().getConnection();
            ColaboradorDAO colaboradorDao = new ColaboradorDAO(conexao);
            colaboradorDao.inset(colaborador);
            
            Connection conexaoUser = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexaoUser);
            usuarioDao.insert(usuario);
            
            JOptionPane.showMessageDialog(null, "Usuário Salvo com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarColaborador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
}
