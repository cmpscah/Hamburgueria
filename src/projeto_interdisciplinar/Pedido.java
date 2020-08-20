package projeto_interdisciplinar;
// FK cliente e prato

public class Pedido {
    private double valor_pedido;    
    private Cliente clientePedido;
    private Prato pratoPedido;
    private int cod_pedido;

    public Cliente getClientePedido() {
        return clientePedido;
    }

    public void setClientePedido(Cliente clientePedido) {
        this.clientePedido = clientePedido;
    }

    public Prato getPratoPedido() {
        return pratoPedido;
    }

    public void setPratoPedido(Prato pratoPedido) {
        this.pratoPedido = pratoPedido;
    }
    

    public int getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(int cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    public double getValor_pedido() {
        return valor_pedido;
    }

    public void setValor_pedido(double valor_pedido) {
        this.valor_pedido = valor_pedido;
    }
}
