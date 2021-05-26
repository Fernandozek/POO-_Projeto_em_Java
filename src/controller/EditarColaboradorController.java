
package controller;

import Dao.ColaboradorDAO;
import Dao.UsuarioDAO;
import Dao.Conexao;
import View.EditarColaborador;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Colaborador;
import model.Usuario;

public class EditarColaboradorController {
    private EditarColaborador view;

    public EditarColaboradorController(EditarColaborador view) {
        this.view = view;
    }
        
    public void editarColaborador(){
        
        
        String nome = view.getjTextFieldNome().getText();
        String login = view.getjTextFieldLogin().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        int id = Integer.parseInt(view.getjTextFieldCodigo().getText());
        Usuario usuario = new Usuario(nome, login, senha);
        
        if(id>1){
            try {
            Connection conexaoUser = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexaoUser);
            usuarioDao.update(usuario,id);
            
            JOptionPane.showMessageDialog(null, "Colaborador Editado com sucesso!");
            } catch (SQLException ex) {
                Logger.getLogger(EditarColaborador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Você não pode alterar o administrador!");
        }
        
        
    }  
}
