/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ProdutoDAO;
import View.CadastrarProdutos;
import View.Produtos;
import Dao.Conexao;
import model.Produto;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author ferna
 */
public class ProdutoController {
    private CadastrarProdutos view;

    public ProdutoController(CadastrarProdutos view) {
        this.view = view;
    }

    public ProdutoController(Produtos cp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void salvaProduto() throws ParseException{
        
        String categoria = view.getjComboBoxCategoria().getSelectedItem().toString();
        String nome = view.getjTextFieldNome().getText();
        double preco = Double.parseDouble(view.getjTextFieldPreco().getText());
        int codigo = Integer.parseInt(view.getjTextFieldCodigo().getText());
        int ml = Integer.parseInt(view.getjTextFieldMl().getText());
        double quant;
        double quantL = Double.parseDouble(view.getjTextFieldQuantL().getText());
        double quantU = Double.parseDouble(view.getjTextFieldQuantU().getText());
        if(quantL >0){
            quant = quantL;
        }else{
            if(quantU>0){
                quant = quantU;
            }else{
                quant =1;
            }
        }
        String validade = view.getjTextFieldValidade().getText();
        String marca = view.getjTextFieldMarca().getText();
        
        Produto produto = new Produto(categoria, nome, preco, codigo, ml, quant, validade, marca);
        
        try {
            Connection conexao = new Conexao().getConnection();
            ProdutoDAO produtoDao = new ProdutoDAO(conexao);
            produtoDao.insert(produto);
            
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
}

