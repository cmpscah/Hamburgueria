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

public class ClienteDAO {
    
    public String cadastrarCliente(Cliente cliente){
        String resp = "";
        try{
            Connection con = Conexao.getConexao();
            String sql = "INSERT INTO CLIENTE (CD_CLIENTE, NM_CLIENTE, NR_CPF, DS_ENDERECO, DS_BAIRRO, NR_CEP, NR_CELULAR, DS_EMAIL, "
                    + "EVENTO_CD_EVENTO, FUNCIONARIO_CD_FUNCIONARIO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cliente.getCod_cliente());
            stmt.setString(2, cliente.getNome_cliente());
            stmt.setString(3, cliente.getCpf_cliente());
            stmt.setString(4, cliente.getEndereco_cliente());
            stmt.setString(5, cliente.getBairro_cliente());
            stmt.setString(6, cliente.getCep_cliente());
            stmt.setString(7, cliente.getCelular_cliente());
            stmt.setString(8, cliente.getEmail_cliente());
            
            stmt.setInt(9, cliente.getEvento_cliente().getCod_evento());
            stmt.setInt(10, cliente.getFuncionario().getCod_funcionario());
            
            stmt.execute();
            stmt.close();
            resp = "OK";
        }
        catch(Exception e){
            resp = e.toString();
        }
        return resp;
    }
    
    public Cliente consultarCliente(int codigo){
        Cliente cliente = new Cliente();
        try{
            Connection con = Conexao.getConexao();
            Statement stmt = con.createStatement();
            String sql = "SELECT CD_CLIENTE, NM_CLIENTE, NR_CPF, DS_ENDERECO, DS_BAIRRO, NR_CEP, NR_CELULAR, DS_EMAIL FROM CLIENTE WHERE CD_CLIENTE=" + codigo + "";
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next()){
                cliente.setCod_cliente(rs.getInt("cd_cliente"));
                cliente.setNome_cliente(rs.getString("nm_cliente"));
                cliente.setCpf_cliente(rs.getString("nr_cpf"));
                cliente.setEndereco_cliente(rs.getString("ds_endereco"));
                cliente.setBairro_cliente(rs.getString("ds_bairro"));
                cliente.setCep_cliente(rs.getString("nr_cep"));
                cliente.setCelular_cliente(rs.getString("nr_celular"));
                cliente.setEmail_cliente(rs.getString("ds_email"));                
            }else{
                cliente = null;
            }stmt.executeUpdate(sql);
            rs.close();
            con.close();
        }catch(Exception e){
            
        }
        return cliente;
    }
    
        public String alterarCliente (Cliente cliente){
        String resp = "";
        try{
            Connection con = Conexao.getConexao();
            Statement stmt = con.createStatement();
            String sql = "UPDATE CLIENTE SET CD_CLIENTE=" + cliente.getCod_cliente()
                    + ", NM_CLIENTE='" + cliente.getNome_cliente()
                    + "', NR_CPF ='" + cliente.getCpf_cliente()
                    + "', DS_ENDERECO='" + cliente.getEndereco_cliente()
                    + "', DS_BAIRRO='" +cliente.getBairro_cliente()
                    + "', NR_CEP='" +cliente.getCep_cliente()
                    + "', NR_CELULAR='" +cliente.getCelular_cliente()
                    + "', DS_EMAIL='" +cliente.getEmail_cliente()
                    + "', EVENTO_CD_EVENTO=" +cliente.getEvento_cliente().getCod_evento()
                    + ", FUNCIONARIO_CD_FUNCIONARIO=" +cliente.getFuncionario().getCod_funcionario()
                    + " WHERE CD_CLIENTE=" + cliente.getCod_cliente()+ "";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "Ok";
            
        }catch(Exception e){
            resp = e.toString();
        }
        return resp;
    }
        
        public String deletarCliente(int codigo){
        String resp = "";
        try{
            Connection con = Conexao.getConexao();
            Statement stmt =con.createStatement();
            String sql = "DELETE FROM CLIENTE WHERE CD_CLIENTE=" +codigo + "";
            
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "OK";
        }catch(Exception e){
            resp = e.toString();
    }
        return resp;
    }
        public List<Cliente> ler(){
            Connection con = Conexao.getConexao();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List<Cliente> clientes = new ArrayList<>();
            
           try {            
            stmt = con.prepareStatement("SELECT CD_CLIENTE, NM_CLIENTE, NR_CELULAR, C.Evento_cd_evento AS COD_EVENTO FROM CLIENTE C INNER JOIN EVENTO E ON C.Evento_cd_evento = E.cd_evento");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                
                cliente.setCod_cliente(rs.getInt("cd_cliente"));
                cliente.setNome_cliente(rs.getString("nm_cliente"));
                cliente.setCelular_cliente(rs.getString("nr_celular"));
                
                
                Evento evento = new Evento();
                evento.setCod_evento(rs.getInt("COD_EVENTO"));
                cliente.setEvento_cliente(evento);
                clientes.add(cliente);
                
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(PratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           return clientes;
       }
        
        
}
