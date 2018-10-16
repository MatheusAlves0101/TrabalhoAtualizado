/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetojdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class ModeloTabela extends AbstractTableModel {

    Connection conexao;
  
    private ArrayList linhas = null;
    private String[] colunas = null;

    public ModeloTabela(ArrayList lin, String[] col) {
        setLinhas(lin);
        setColunas(col);

    }
 
    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
        
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
        
    }
    public String getColumnName(int numCol){
        return colunas[numCol];
    }

    @Override
    public Object getValueAt(int i, int i1) {
        
        Object[] linha = (Object[])getLinhas().get(i);
        return linha[i1];
    }

}
