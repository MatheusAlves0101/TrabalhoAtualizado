
package projetojdbc;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus
 */
public class ProjetoJDBC_View extends JFrame {
        JTextField cTexto1,cTexto2;
        JComboBox combobox;
        JLabel label1,label2;
        JPanel painelBox,painel3,fundo, painelCard,painelSec,painelbox3, gridbag,flowla,painelbox4;
               
        JButton botao1,botao2;
        JTable tabela,tabela2;
        JScrollPane scrollpane,scrollpane2;
        DefaultTableModel modelo;
        CardLayout c1 = new CardLayout();
        String query = "SELECT books.title, authors.name, books.prince " +
                            "FROM authors, books, booksauthors " +
                            "WHERE booksauthors.isbn = books.isbn " +
                            "  AND booksauthors.author_id = authors.author_id " +
                            "  AND LOWER(books.title) LIKE LOWER(?) ";
        
        public ProjetoJDBC_View() throws SQLException{
            super("Buscar Livros");
            criaTabela();
            cTexto1 = new JTextField(20);
            painelBox = new JPanel();
            painelBox.setLayout(new BoxLayout(painelBox, BoxLayout.LINE_AXIS));  
            botao1 = new JButton("Pesquisar");
            botao1.addActionListener(new Botao1Busca());
            botao2 = new JButton("Modificar");
            
           
           
               
            painelBox.add(cTexto1);
            painelBox.add(botao1);
            painelBox.add(botao2);
            
          
            
                
            
            
            tabela = new JTable(modelo);
            scrollpane = new JScrollPane(tabela);
            
            fundo = new JPanel();
            fundo.setLayout(new BorderLayout());
            fundo.add(BorderLayout.NORTH, painelBox);
            fundo.add(BorderLayout.CENTER,scrollpane);
            
            painelCard = new JPanel();
            painelCard.setLayout(c1);
            painelCard.add(fundo,"1");
            painelSec = new JPanel();
            painelSec.setLayout(new BorderLayout());
            painelCard.add(painelSec,"2");
       
            c1.show(painelCard, "1");
            ProjetoJDBC_SegView seg = new ProjetoJDBC_SegView();
           
            getContentPane().add(painelCard,BorderLayout.CENTER);
            
            botao2.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                   setVisible(false);
                   seg.setVisible(true);
                   seg.setDefaultCloseOperation(EXIT_ON_CLOSE);
                }
            
            
            
        });
     //    SegundaView();   
             
        }
        
        
        public void criaTabela(){
            modelo = new DefaultTableModel();
            modelo.addColumn("Titulo");
            modelo.addColumn("Autor");
            modelo.addColumn("Preço");
        }
        
        public void criaBusca(String keyWord) throws SQLException{
            try{
                
               Connection conexao = ConexaoBanco.getConnection();
            
               PreparedStatement ps = conexao.prepareStatement(query);
               ps.setString(1, "%"+keyWord+"%");
               ResultSet rs = ps.executeQuery();
               modelo.setNumRows(0);
               while(rs.next()){
                  modelo.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getDouble(3)});
                   System.out.println(rs.getString(1)+"|"+rs.getString(2));
               }
               conexao.close();
               rs.close();
               ps.close();
               
                 
            }catch(Exception e){
                e.printStackTrace();
            }
                
            }
        public class Botao1Busca implements ActionListener{
            
        

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                criaBusca(cTexto1.getText());
                    
                
                }
                
             catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        }   
    
            
             
             
             
            
              
             
             
             
             
             
             
             
         }
              

            
                    
            
            
        
        
        
    

