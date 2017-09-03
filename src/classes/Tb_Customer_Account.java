package classes;


public class Tb_Customer_Account implements Comparable{
    
    private int id_customer;
    private String cpf_cnpj;
    private String nm_customer;
    private boolean is_active;
    private double vl_total;
    
    // Construtor   
    public Tb_Customer_Account(int id_customer, String cpf_cnpj, String nm_customer, boolean is_active, double vl_total) {
        this.id_customer = id_customer;
        this.cpf_cnpj = cpf_cnpj;
        this.nm_customer = nm_customer;
        this.is_active = is_active;
        this.vl_total = vl_total;
    }
    
    // Getters e Setters
    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getCpf() {
        return cpf_cnpj;
    }

    public void setCpf(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNm_customer() {
        return nm_customer;
    }

    public void setNm_customer(String nm_customer) {
        this.nm_customer = nm_customer;
    }

    public boolean getIs_active() {
        return is_active == true;
        
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public double getVl_total() {
        return vl_total;
    }

    public void setVl_total(double vl_total) {
        this.vl_total = vl_total;
    }
    
    public String getAtivoInativo(){
        if(!getIs_active()){
            return "Desativado";
        }
         
        return "Ativado";
    }
    
    // Método para ordenar o ArrayList Tb_Customer_Account pelo saldo maior ao menor
    @Override
    public int compareTo(Object o){
        
    Tb_Customer_Account tbUser = (Tb_Customer_Account) o;
		
	if(getVl_total() < tbUser.getVl_total()){
		return 1;
            }else{
		if(getVl_total() > tbUser.getVl_total()){                    
                return -1;
            }else{                            
                return 0;
            }
	}
    }
    
    // Print os dados do usuário    
    public String imprimir(){
        return "ID: "+id_customer+" | Nome do Usuário: "+nm_customer+" | CPF ou CPNJ: "+cpf_cnpj+
                " | Cadastro: "+getAtivoInativo() + " | Saldo: "+vl_total + "\n";
    }
    
}
