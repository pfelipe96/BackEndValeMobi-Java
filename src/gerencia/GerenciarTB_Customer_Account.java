
package gerencia;

import classes.Tb_Customer_Account;
import java.util.ArrayList;
import java.util.Collections;


public class GerenciarTB_Customer_Account {
    
    // Armazenar os todos que venho do banco de dados para o ArrayList
    private static ArrayList <Tb_Customer_Account> listaUsuarios = new ArrayList();

    public static void setLista(Tb_Customer_Account tbUser){
        listaUsuarios.add(tbUser);
        Collections.sort(listaUsuarios);
        
    }   
    
    // Armazenar os usuário após a verificação dos critérios 
    private static ArrayList <Tb_Customer_Account> userOk = new ArrayList();

    public static void userOK(Tb_Customer_Account tbUser){
        userOk.add(tbUser);
        
    }
    
    // Retornar o saldo médio entre os usuários escolhidos
    public static Double mediaSaldoUser(){
        double media = 0;
        int count = 0;
        for(Tb_Customer_Account tbUser: listaUsuarios){
            if(tbUser.getVl_total() > 560  && tbUser.getId_customer() >= 1500 && tbUser.getId_customer() <= 2700 ){
                
                GerenciarTB_Customer_Account.userOk.add(new Tb_Customer_Account(tbUser.getId_customer(), tbUser.getCpf(),
                  tbUser.getNm_customer(), tbUser.getIs_active(), tbUser.getVl_total()));
                
                media = media + tbUser.getVl_total(); 
                count++;
            }
        }
        
        return media/count;
    }
    
    // Método que retorna todos os Usuários da Tb_Customer_Account   
    public static String listarTodosUser(){
        String saida = "";
        
        if(listaUsuarios.isEmpty()){
            saida = "Nenhum usuários encontrado";
        }
        else{
            for(Tb_Customer_Account tbUser: listaUsuarios){
                saida = saida + tbUser.imprimir();
            }
        }
        
        return saida;
    }
    
    // Retorna todos os usuários escolhidos
    public static String listarTodosUserVerificado(){
        String saida = "";
        
        if(userOk.isEmpty()){
            saida = "Nenhum usuários encontrado";
        }
        else{
            
            for(Tb_Customer_Account tbUser: userOk){
                saida = saida + tbUser.imprimir();
            }
        }
        
        return saida;
    }   
    
}
