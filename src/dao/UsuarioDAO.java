/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java. sql.ResultSet;

import model.Usuario;


/**
 *
 * @author Didi
 */
public class UsuarioDAO {
    private final Connection connection;
    
    public UsuarioDAO(Connection connection){
        this.connection = connection;
    }
    
    public void insert(Usuario usuario) throws SQLException{
        
            
            String sql = "insert into usuario(usuario,senha) values('" + usuario.getUsuario() +"','" + usuario.getSenha()+ "')";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            
            
            
        
    }

   

    public boolean autenticarUsuario(Usuario usuario) throws SQLException {
       String sql = "select * from usuario where usuario = '"+usuario.getUsuario()+"' and senha = '"+usuario.getSenha()+"'";
       PreparedStatement statement = connection.prepareStatement(sql);
       statement.execute();
       ResultSet resultset = statement.getResultSet();     
       return resultset.next();
    }
    
}
