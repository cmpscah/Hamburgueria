package projeto_interdisciplinar;

public class Cliente {
    private int cod_cliente;
    private String nome_cliente;
    private String cpf_cliente;
    private String endereco_cliente;
    private String bairro_cliente;
    private String cep_cliente;
    private String celular_cliente;
    private String email_cliente;
    
    private Evento evento_cliente;
    private Funcionario funcionario;

    public int getCod_cliente() {
        return cod_cliente;
    }

    public Evento getEvento_cliente() {
        return evento_cliente;
    }

    public void setEvento_cliente(Evento evento_cliente) {
        this.evento_cliente = evento_cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFunc_cliente(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getEndereco_cliente() {
        return endereco_cliente;
    }

    public void setEndereco_cliente(String endereco_cliente) {
        this.endereco_cliente = endereco_cliente;
    }

    public String getBairro_cliente() {
        return bairro_cliente;
    }

    public void setBairro_cliente(String bairro_cliente) {
        this.bairro_cliente = bairro_cliente;
    }

    public String getCep_cliente() {
        return cep_cliente;
    }

    public void setCep_cliente(String cep_cliente) {
        this.cep_cliente = cep_cliente;
    }

    public String getCelular_cliente() {
        return celular_cliente;
    }

    public void setCelular_cliente(String celular_cliente) {
        this.celular_cliente = celular_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }
    
    
}
