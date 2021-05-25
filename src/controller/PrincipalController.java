/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.Principal;
import View.Produtos;
import static View.Produtos.preencherTabela;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ferna
 */
public class PrincipalController {
    private Principal view;

    public PrincipalController(Principal view) {
        this.view = view;
    }
    
    public void exibeProdutos() throws SQLException{
        Produtos p = new Produtos();
        p.setVisible(true);
        view.dispose();
    }
}
