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

public class EventoDAO {

    public String cadastrarEvento(Evento evento) {
        String resp = "";
        try {
            Connection con = Conexao.getConexao();
            String sql = "INSERT INTO EVENTO (CD_EVENTO, NM_EVENTO, NM_TEMA, DS_ATRACOES, VL_INGRESSO) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, evento.getCod_evento());
            stmt.setString(2, evento.getNome_evento());
            stmt.setString(3, evento.getNome_tema());
            stmt.setString(4, evento.getAtracoes());
            stmt.setDouble(5, evento.getValor_ingresso());


            stmt.execute();
            stmt.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }

    public Evento consultarEvento(int codigo) {
        Evento evento = new Evento();
        try {
            Connection con = Conexao.getConexao();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM EVENTO WHERE CD_EVENTO=" + codigo + "";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                evento.setCod_evento(rs.getInt("cd_evento"));
                evento.setNome_evento(rs.getString("nm_evento"));
                evento.setNome_tema(rs.getString("nm_tema"));
                evento.setAtracoes(rs.getString("ds_atracoes"));
                evento.setValor_ingresso(rs.getDouble("vl_ingresso"));
      
            } else {
                evento = null;
            }
            stmt.executeUpdate(sql);
            rs.close();
            con.close();
        } catch (Exception e) {

        }
        return evento;
    }

    public String alterarEvento(Evento evento) {
        String resp = "";
        try {
            Connection con = Conexao.getConexao();
            Statement stmt = con.createStatement();
            String sql = "UPDATE EVENTO SET CD_EVENTO=" + evento.getCod_evento()
                    + ", NM_EVENTO='" + evento.getNome_evento()
                    + "', NM_TEMA ='" + evento.getNome_tema()
                    + "', DS_ATRACOES ='" + evento.getAtracoes()
                    + "', VL_INGRESSO =" + evento.getValor_ingresso()
                    + " WHERE CD_EVENTO=" + evento.getCod_evento() + "";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "Ok";

        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }

    public String deletarEvento(int codigo) {
        String resp = "";
        try {
            Connection con = Conexao.getConexao();
            Statement stmt = con.createStatement();
            String sql = "DELETE FROM EVENTO WHERE CD_EVENTO=" + codigo + "";

            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }
    
    public List<Evento> ler(){
            Connection con = Conexao.getConexao();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List<Evento> eventos = new ArrayList<>();
            
           try {            
            stmt = con.prepareStatement("SELECT NM_EVENTO FROM EVENTO");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Evento evento = new Evento();
                
                evento.setNome_evento(rs.getString("NM_EVENTO"));               
                eventos.add(evento);
                
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(PratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           return eventos;
       }
}
