/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FormCadastroView;

/**
 *
 * @author Didi
 */
public class FormCadastroController {
    private FormCadastroView view;

    public FormCadastroController(FormCadastroView view) {
        this.view = view;
    }
    
    public void salvaUsuario(){
        Usuario usuario = new Usuario(view.getTxtCadUsuario().getText() ,view.getTxtCadSenha().getText());
        
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.insert(usuario);
            JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(FormCadastroView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
