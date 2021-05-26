/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ProdutoDAO;
import View.Colaborador;
import Dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import model.Produto;
import Dao.VendasDAO;
import java.text.ParseException;
import javax.swing.JOptionPane;
/**
 *
 * @author ferna
 */
public class ColaboradorController {
    private Colaborador view;

    public ColaboradorController(Colaborador view) {
        this.view = view;
    }
    
    public void efetuarVenda() throws SQLException, ParseException{
        
        int codigo = Integer.parseInt(view.getjTextFieldCodigo().getText());
        double peso = Double.parseDouble(view.getjTextFieldPeso().getText());
        int ml = Integer.parseInt(view.getjComboBoxML().getSelectedItem().toString());
        int quantidade = Integer.parseInt(view.getQuantidade().getText());
        
        Produto produto = new Produto("", "", 0, codigo, 0, 0, "", "");
        
        Connection conexao = new Conexao().getConnection();
        ProdutoDAO produtoDao = new ProdutoDAO(conexao);
        boolean existe = produtoDao.existeProdutoPorCodigo(produto);
        if(existe){
            produto = produtoDao.selectPorId(produto);
            VendasDAO venda =  new VendasDAO(conexao);
            produto = produtoDao.selectPorId(produto);
            venda.insert(produto.getNome(),produto.getPreco(),peso,quantidade,ml);
            JOptionPane.showMessageDialog(null,"Venda efetuada com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null,"Erro ao efetuar a venda!");
        }
        
        
    }
    
    public void limpaCampos(){
        view.setjTextFieldCodigo(null);
    }
}
