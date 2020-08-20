package projeto_interdisciplinar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

  public class Conexao {
    public static Connection getConexao(){
        Connection con = null;
        try{
            String serverName = "localhost";
            String mydatabase = "projeto";
            String username = "root";
            String password = "sqlMy#20";
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(url, username, password);
        }catch(ClassNotFoundException e){
            System.out.println("Driver não foi encontrado"+ e.toString());
        }catch(SQLException ex){
            System.out.println("Erro ao conectar com BD"+ex.toString());
        }
        return con;        
    }
  }
