/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ColaboradorDAO;
import Dao.ProdutoDAO;
import View.ExcluirColaborador;
import Dao.Conexao;
import Dao.UsuarioDAO;
import model.Produto;
import java.sql.Connection;
import java.text.ParseException;
import javax.swing.JOptionPane;
import model.Colaborador;
import model.Usuario;
/**
 *
 * @author ferna
 */
public class ExcluirColaboradorController {
    private ExcluirColaborador view;

    public ExcluirColaboradorController(ExcluirColaborador view) {
        this.view = view;
    }
    
    public void excluirColaborador() throws java.sql.SQLException, ParseException{
        
        
        int codigo = Integer.parseInt(view.getjTextFieldCodigo().getText());
        
        if(codigo>1){
        
            Colaborador colaborador = new Colaborador( codigo-1,"", "", "");
            Usuario usuario = new Usuario(codigo, "", "", "");

            Connection conexao = new Conexao().getConnection();
            ColaboradorDAO colaboradorDao = new ColaboradorDAO(conexao);
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            
            colaboradorDao.delete(colaborador);
            usuarioDao.delete(usuario);
            JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!!!");
        }else{
            JOptionPane.showMessageDialog(null, "Você não pode excluir o administrador!");
        }
        
    }
}
