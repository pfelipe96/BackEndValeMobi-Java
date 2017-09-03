package main;

import classes.Tb_Customer_Account;
import gerencia.GerenciarTB_Customer_Account;
import java.sql.SQLException;
import utilitarios.ConectaDB;

class MainValeMobi{
    
    private static ConectaDB connection = new ConectaDB();
  
        
    public static void main(String args[]){

        getInicializarDB();
              
        System.out.println("A média do saldo é: " + GerenciarTB_Customer_Account.mediaSaldoUser());
        
        System.out.println("_____________________________________________________\n");
        
        System.out.println("Usuários dentro do critério: \n"+"\n"+GerenciarTB_Customer_Account.listarTodosUserVerificado());
        
    }
    
    //Chama o banco de dados        
    private static void getInicializarDB(){
        
        connection.getConexao();
        
        connection.getExecutaSQL("select * from tb_customer_account");
        try {
            connection.rs.first();
            
            do{   
            int id = connection.rs.getInt("id_customer");
            String nome = connection.rs.getString("nm_customer");
            String cpf_cnpj = connection.rs.getString("cpf_cnpj");
            boolean cadastro = connection.rs.getBoolean("is_active");
            double saldo = connection.rs.getDouble("vl_total");
            
            // Preenchimento da Lista          
            GerenciarTB_Customer_Account.setLista(new Tb_Customer_Account(id, cpf_cnpj, nome,cadastro, saldo));
            
            }while(connection.rs.next());
            
        } catch (SQLException ex) {
            System.out.println("Erro ao mostra banco de dados, ERRO:"+ex.getMessage());
        }
    }
    
}



