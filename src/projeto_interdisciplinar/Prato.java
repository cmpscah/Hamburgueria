package projeto_interdisciplinar;

public class Prato {
    private int cod_prato;
    private String nome_prato;
    private String ingredientes;
    private double valor_prato;

    public int getCod_prato() {
        return cod_prato;
    }

    public void setCod_prato(int cod_prato) {
        this.cod_prato = cod_prato;
    }

    public String getNome_prato() {
        return nome_prato;
    }

    public void setNome_prato(String nome_prato) {
        this.nome_prato = nome_prato;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public double getValor_prato() {
        return valor_prato;
    }

    public void setValor_prato(double valor_prato) {
        this.valor_prato = valor_prato;
    }
}
