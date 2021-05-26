/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ProdutoDAO;
import View.EditarProduto;
import Dao.Conexao;
import model.Produto;
import java.sql.Connection;
import java.text.ParseException;
import javax.swing.JOptionPane;
/**
 *
 * @author ferna
 */
public class EditarProdutoController {
    private EditarProduto view;

    public EditarProdutoController(EditarProduto view) {
        this.view = view;
    }
    
    public void editarProduto() throws java.sql.SQLException, ParseException{
        
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
            quant = quantU;
        }
        String validade = view.getjTextFieldValidade().getText();
        String marca = view.getjTextFieldMarca().getText();
        
        Produto produto = new Produto(categoria, nome, preco, codigo, ml, quant, validade, marca);
        
        
        Connection conexao = new Conexao().getConnection();
        ProdutoDAO produtoDao = new ProdutoDAO(conexao);
        produtoDao.update(produto);

        JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
        
    }
}
