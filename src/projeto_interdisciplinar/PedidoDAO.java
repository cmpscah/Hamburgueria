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

public class PedidoDAO {
    public String cadastrarPedido(Pedido pedido){
        String resp = "";
        try{
            Connection con = Conexao.getConexao();
            String sql = "INSERT INTO PEDIDOS (CD_PEDIDO, VL_PEDIDO, CLIENTE_CD_CLIENTE, PRATO_CD_PRATO) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, pedido.getCod_pedido());
            stmt.setDouble(2, pedido.getValor_pedido());
            stmt.setInt(3, pedido.getClientePedido().getCod_cliente());
            stmt.setInt(4, pedido.getPratoPedido().getCod_prato());

            stmt.execute();
            stmt.close();
            resp = "OK";
        }
        catch(Exception e){
            resp = e.toString();
        }
        return resp;
    }
    
    public Pedido consultarPedido(int codigo){
        Pedido pedido = new Pedido();
        try{
            Connection con = Conexao.getConexao();
            Statement stmt = con.createStatement();
            String sql = "SELECT CD_PEDIDO, VL_PEDIDO FROM PEDIDOS WHERE CD_PEDIDO=" + codigo + "";
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next()){
                pedido.setCod_pedido(rs.getInt("cd_pedido"));
                pedido.setValor_pedido(rs.getDouble("vl_pedido"));
            }else{
                pedido = null;
            }stmt.executeUpdate(sql);
            rs.close();
            con.close();
        }catch(Exception e){
            
        }
        return pedido;
    }
    
        public String alterarPedido (Pedido pedido){
        String resp = "";
        try{
            Connection con = Conexao.getConexao();
            Statement stmt = con.createStatement();
            String sql = "UPDATE PEDIDOS SET CD_PEDIDO=" + pedido.getCod_pedido()                    
                    + ", VL_PEDIDO =" + pedido.getValor_pedido()
                    + " WHERE CD_PEDIDO=" + pedido.getCod_pedido()+ "";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "Ok";
            
        }catch(Exception e){
            resp = e.toString();
        }
        return resp;
    }
        
        public String deletarPedido(int codigo){
        String resp = "";
        try{
            Connection con = Conexao.getConexao();
            Statement stmt =con.createStatement();
            String sql = "DELETE FROM PEDIDO WHERE CD_PEDIDO= " +codigo + "";
            
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "OK";
        }catch(Exception e){
            resp = e.toString();
    }
        return resp;
    }
        public List<Pedido> ler(){
            Connection con = Conexao.getConexao();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List<Pedido> pedidos = new ArrayList<>();
            
           try {            
            stmt = con.prepareStatement("SELECT cd_pedido, vl_pedido, PE.Prato_cd_prato AS COD_PRATO FROM PEDIDOS PE INNER JOIN PRATO PR ON PR.cd_prato = PE.Prato_cd_prato;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Pedido pedido = new Pedido();
                
                pedido.setCod_pedido(rs.getInt("cd_pedido"));
                pedido.setValor_pedido(rs.getDouble("vl_pedido"));
                
                Prato prato = new Prato();
                prato.setCod_prato(rs.getInt("COD_PRATO"));
                pedido.setPratoPedido(prato);
                pedidos.add(pedido);
                
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(PratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           return pedidos;
       }
        public List<Pedido> lerPedidoCliente(){
            Connection con = Conexao.getConexao();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List<Pedido> pedidos = new ArrayList<>();
            
           try {            
            stmt = con.prepareStatement("SELECT cd_pedido, PE.Cliente_cd_cliente AS COD_CLIENTE FROM PEDIDOS PE INNER JOIN CLIENTE C ON C.cd_cliente = PE.Cliente_cd_cliente;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Pedido pedido = new Pedido();
                
                pedido.setCod_pedido(rs.getInt("cd_pedido"));
                
                
                Cliente cliente = new Cliente();
                cliente.setCod_cliente(rs.getInt("COD_CLIENTE"));
                pedido.setClientePedido(cliente);
                pedidos.add(pedido);
                
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(PratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           return pedidos;
       }
}
