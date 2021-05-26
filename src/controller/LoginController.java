
package controller;

import Dao.UsuarioDAO;
import View.LoginView;
import View.Principal;
import View.Colaborador;
import Dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;

public class LoginController {
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        
        String login = view.getjTextFieldLogin().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        
        Usuario usuarioAutenticar = new Usuario(login, senha);
        
        Connection conexaoUser = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexaoUser);
        
        boolean existe = usuarioDao.existeUsuarioPorLoginESenha(usuarioAutenticar);
        
        if(existe && login.equals("admin") && senha.equals("admin")){
            Principal telaDeMenu = new Principal();
            telaDeMenu.setVisible(true);
            view.dispose();
        }else{
            if(existe){
                Colaborador telaColaborador = new Colaborador();
                telaColaborador.setVisible(true);
                view.dispose();
            }else{
                JOptionPane.showMessageDialog(view, "Usuario ou senha inválidos");
            }
            
        }
        
        
    }
    
}
