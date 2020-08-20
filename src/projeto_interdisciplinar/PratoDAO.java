package projeto_interdisciplinar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PratoDAO {
    public String cadastrarPrato(Prato prato){
        String resp = "";
        try{
            Connection con = Conexao.getConexao();
            String sql = "INSERT INTO PRATO (CD_PRATO, NM_PRATO, DS_INGREDIENTES, VL_PRATO) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, prato.getCod_prato());
            stmt.setString(2, prato.getNome_prato());
            stmt.setString(3, prato.getIngredientes());
            stmt.setDouble(4, prato.getValor_prato());
            
            stmt.execute();
            stmt.close();
            resp = "OK";
        }
        catch(Exception e){
            resp = e.toString();
        }
        return resp;
    }

    public Prato consultarPrato(int codigo){
        Prato prato = new Prato();
        try{
            Connection con = Conexao.getConexao();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM PRATO WHERE CD_PRATO=" + codigo + "";
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next()){
                prato.setCod_prato(rs.getInt("cd_prato"));
                prato.setNome_prato(rs.getString("nm_prato"));
                prato.setIngredientes(rs.getString("ds_ingredientes"));
                prato.setValor_prato(rs.getDouble("vl_prato"));
            }else{
                prato = null;
            }stmt.executeUpdate(sql);
            rs.close();
            con.close();
        }catch(Exception e){
            
        }
        return prato;
    }
    
        public String alterarPrato (Prato prato){
        String resp = "";
        try{
            Connection con = Conexao.getConexao();
            Statement stmt = con.createStatement();
            String sql = "UPDATE PRATO SET CD_PRATO=" + prato.getCod_prato()                    
                    + ", NM_PRATO='" + prato.getNome_prato()
                    + "', DS_INGREDIENTES='" + prato.getIngredientes()
                    + "', VL_PRATO =" + prato.getValor_prato()
                    + " WHERE CD_PRATO=" + prato.getCod_prato()+ "";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "Ok";
            
        }catch(Exception e){
            resp = e.toString();
        }
        return resp;
    }
        
        public String deletarPrato(int codigo){
        String resp = "";
        try{
            Connection con = Conexao.getConexao();
            Statement stmt =con.createStatement();
            String sql = "DELETE FROM PRATO WHERE CD_PRATO=' " +codigo + "'";
            
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "OK";
        }catch(Exception e){
            resp = e.toString();
    }
        return resp;
    }
        
       public List<Prato> ler(){
            Connection con = Conexao.getConexao();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List<Prato> pratos = new ArrayList<>();
            
           try {            
            stmt = con.prepareStatement("SELECT * FROM PRATO");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Prato prato = new Prato();
                
                prato.setCod_prato(rs.getInt("cd_prato"));
                prato.setNome_prato(rs.getString("nm_prato"));
                prato.setIngredientes(rs.getString("ds_ingredientes"));               
                prato.setValor_prato(rs.getDouble("vl_prato"));
                pratos.add(prato);
                
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(PratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           return pratos;
       }
       
       
}
