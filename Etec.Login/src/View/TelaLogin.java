package View;

 // @autor: Danilo/Gabriel
import Persistence.ConexaoFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Persistence.*;


public class TelaLogin extends JFrame {
    
    public TelaLogin () {
        
        super ("Login");
        setLayout(null);
        
        Container tela = getContentPane();
        
        tela.setBackground(Color.WHITE);
        
        ImageIcon icone = new ImageIcon("user.png");
        setIconImage(icone.getImage());
        
        ImageIcon LoginRed = new ImageIcon("LoginRed.jpg");
        JLabel imgLogin = new JLabel (LoginRed);
        imgLogin.setBounds(25,0,200,200);
        tela.add(imgLogin);
        
        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setBounds(35,170,200,100);
        lblEmail.setFont(new Font("Calibri",Font.BOLD,15));
        tela.add(lblEmail);
        
        JTextField txfEmail = new JTextField();
        txfEmail.setBounds(35,230,165,22);
        tela.add(txfEmail);
        
        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setBounds(35,230,200,100);
        lblSenha.setFont(new Font("Calibri",Font.BOLD,15));
        tela.add(lblSenha);
        
        JPasswordField txfSenha = new JPasswordField();
        txfSenha.setBounds(35,290,165,22);
        tela.add(txfSenha);
        
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(65,320,100,35);
        btnEntrar.setFont(new Font("Arial",Font.BOLD,15));
        tela.add(btnEntrar);
        
        btnEntrar.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
                String user = txfEmail.getText();
                String pass = txfSenha.getText();
                try {
                    Connection conn = new ConexaoFactory().getMysqlConnection();
                    UsuarioDAO userDAO = new UsuarioDAO(conn);
                    userDAO.validar(user, pass);
                    
                } catch (Exception ex) {
                    Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                }   
          }
        });
       
        setVisible(true);
        setSize(250,400);
        setLocationRelativeTo(null);
        setResizable(false); 
        
                }
    
    public static void main(String[] args) {
        
        TelaLogin app = new TelaLogin();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    }  
}

                
                
