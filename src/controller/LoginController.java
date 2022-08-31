/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import model.Usuario;

import view.LoginView;
import view.MenuView;

/**
 *
 * @author Didi
 */
public class LoginController {
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
      String usuario = view.getTxtUsuario().getText();
      String senha = view.getTxtSenha().getText();
      
      Usuario usuarioAutenticar = new Usuario(usuario, senha);
      
    
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            boolean existe = usuarioDao.autenticarUsuario(usuarioAutenticar);
            if(existe){
              MenuView telaDeMenu = new MenuView();
              telaDeMenu.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Usuario e senha incorretos");
            }
       
      
      
//      telaDeMenu.setVisible(true);
    }
    
    
    
}
