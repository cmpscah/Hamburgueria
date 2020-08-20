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

public class FuncionarioDAO {

    public String cadastrarFuncionario(Funcionario func){
        String resp = "";
        try{
            Connection con = Conexao.getConexao();
            String sql = "INSERT INTO FUNCIONARIO(CD_FUNCIONARIO, NM_FUNCIONARIO, NR_CPF, DS_ENDERECO, DS_BAIRRO, NR_CEP, NR_CELULAR, DS_EMAIL, NM_CARGO, NR_SALARIO) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, func.getCod_funcionario());
            stmt.setString(2, func.getNome_funcionario());
            stmt.setString(3, func.getCpf_funcionario());
            stmt.setString(4, func.getEndereco_funcionario());
            stmt.setString(5, func.getBairro_funcionario());
            stmt.setString(6, func.getCep_funcionario());
            stmt.setString(7, func.getCelular_funcionario());
            stmt.setString(8, func.getEmail_funcionario());
            stmt.setString(9, func.getCargo());
            stmt.setDouble(10, func.getSalario());
            
            stmt.execute();
            stmt.close();
            resp = "OK";
        }
        catch(Exception e){
            resp = e.toString();
        }
        return resp;
    }
    
    public Funcionario consultarFuncionario(int codigo){
       Funcionario func = new Funcionario();
        try{
            Connection con = Conexao.getConexao();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM FUNCIONARIO WHERE CD_FUNCIONARIO=" + codigo + "";
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next()){
                func.setCod_funcionario(rs.getInt("cd_funcionario"));
                func.setNome_funcionario(rs.getString("nm_funcionario"));
                func.setCpf_funcionario(rs.getString("nr_cpf"));
                func.setEndereco_funcionario(rs.getString("ds_endereco"));
                func.setBairro_funcionario(rs.getString("ds_bairro"));
                func.setCep_funcionario(rs.getString("nr_cep"));
                func.setCelular_funcionario(rs.getString("nr_celular"));
                func.setEmail_funcionario(rs.getString("ds_email"));
                func.setCargo(rs.getString("nm_cargo"));
                func.setSalario(rs.getDouble("nr_salario"));
            }else{
                func = null;
            }stmt.executeUpdate(sql);
            rs.close();
            con.close();
        }catch(Exception e){
            
        }
        return func;
    }
    
        public String alterarFuncionario (Funcionario func){
        String resp = "";
        try{
            Connection con = Conexao.getConexao();
            Statement stmt = con.createStatement();
            String sql = "UPDATE FUNCIONARIO SET CD_FUNCIONARIO=" + func.getCod_funcionario()                    
                    + ", NM_FUNCIONARIO='" + func.getNome_funcionario()
                    + "', NR_CPF ='" + func.getCpf_funcionario()
                    + "', DS_ENDERECO='" + func.getEndereco_funcionario()
                    + "', DS_BAIRRO='" +func.getBairro_funcionario()
                    + "', NR_CEP='" +func.getCep_funcionario()
                    + "', NR_CELULAR='" +func.getCelular_funcionario()
                    + "', DS_EMAIL='" +func.getEmail_funcionario()
                    + "', NM_CARGO='" +func.getCargo()
                    + "', NR_SALARIO=" +func.getSalario()
                    + " WHERE CD_FUNCIONARIO=" + func.getCod_funcionario()+ "";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "Ok";
            
        }catch(Exception e){
            resp = e.toString();
        }
        return resp;
    }
        
        public String deletarFuncionario(int codigo){
        String resp = "";
        try{
            Connection con = Conexao.getConexao();
            Statement stmt =con.createStatement();
            String sql = "DELETE FROM FUNCIONARIO WHERE CD_FUNCIONARIO= " +codigo + "";
            
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "OK";
        }catch(Exception e){
            resp = e.toString();
    }
        return resp;
    } 
}
