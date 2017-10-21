package Persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Persistence.*;
import Controller.Usuario;
import View.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class UsuarioDAO implements IDAO {
    
    Connection conUsuario;
    
    public UsuarioDAO(Connection conUsuario)
    {
        this.conUsuario = conUsuario;
    }
    
    
    public void validar(String user, String pass) throws Exception{
        Connection conn = null;
        
        try {
             conn = new ConexaoFactory().getMysqlConnection();
        } catch (Exception ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
                 String sql = "SELECT * from usuario";
                 PreparedStatement ps;
                try {
                    ps = conn.prepareStatement(sql);
                    ResultSet rs;
                    rs = ps.executeQuery();
                     while (rs.next()) {
                       
                        if (rs.getString("login").equals(user) && rs.getString("senha").equals(pass)) {
                            JOptionPane.showMessageDialog(null,"Usuário logado com sucesso!");
                            break;
                            
                        }
                        
                        else
                           
                            
                            if (!rs.getString("login").equals(user) && !rs.getString("senha").equals(pass)) 
                        {
                            JOptionPane.showMessageDialog(null,"Usuário inválido!");
                          
                        }  
                    }
                }
                
                catch (SQLException ex) {
                    
         }       
    }             
    }
    
    

