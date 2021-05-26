/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ProdutoDAO;
import View.ExcluirProduto;
import Dao.Conexao;
import model.Produto;
import java.sql.Connection;
import java.text.ParseException;
import javax.swing.JOptionPane;
/**
 *
 * @author ferna
 */
public class ExcluirProdutoController {
    private ExcluirProduto view;

    public ExcluirProdutoController(ExcluirProduto view) {
        this.view = view;
    }
    
    public void excluirProduto() throws java.sql.SQLException, ParseException{
        
        
        int codigo = Integer.parseInt(view.getjTextFieldCodigo().getText());
        
        
        Produto produto = new Produto("", "", 0, codigo, 0, 0, "", "");
        
        
        Connection conexao = new Conexao().getConnection();
        ProdutoDAO produtoDao = new ProdutoDAO(conexao);
        boolean existe = produtoDao.existeProdutoPorCodigo(produto);
        if(existe){
            produtoDao.delete(produto);
            JOptionPane.showMessageDialog(null, "Produto Removido com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Produto não existe");
        }
        
        
    }
}
