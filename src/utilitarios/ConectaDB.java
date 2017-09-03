package utilitarios;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConectaDB {
    // Responsavel por preparar e realizar pesquisas no banco de dados  
    public Statement stm;
    // Responsavel por armazenar o resultado de uma pesquisa passada para o Statement    
    public ResultSet rs; 
    // Responsável por identificar o serviço de banco de dados   
    private String driver = "org.postgresql.Driver";
    // Responsavel por set o caminho de dados
    private String caminho = "jdbc:postgresql://localhost:5432/valeMobiDB";
    private String usuario = "postgres";
    private String senha = "";
    // Responsavel por realizar a conexão com o banco de dados   
    public Connection conn;
    
    // Método responsavel por realizar a conexão com o banco de dados
    public void getConexao(){
        // Tentativa inicial       
        try {
            // Configurar a propriedade do driver de conexão            
            System.setProperty("jdbc.Drivers", driver);
            // Realiza a conexão com o banco de dados;
            conn = DriverManager.getConnection(caminho, usuario, senha);
            System.out.println("Conectado com sucesso ao Banco de Dados\n");
        // caso de não ter certo o que vai ser realizado no try   
        } catch (SQLException ex) {
            Logger.getLogger(ConectaDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro de conexão!\n Erro:" + ex.getMessage() + "\n");
        }
    }
    
    public void getExecutaSQL(String sql){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Erro ao Executa SQL!\n Erro:" + ex.getMessage()+ "\n");
        }
    }
    
    // Método para fechar a conexão do banco de dados
    public void getDesconecta(){
        try {
            conn.close();
            System.out.println("Banco desconectado \n");
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar a conexão! Erro:" + ex.getMessage()+ "\n");
        }
    }
}
