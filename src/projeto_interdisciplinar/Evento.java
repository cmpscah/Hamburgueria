package projeto_interdisciplinar;

import java.sql.Date;

public class Evento {
    private int cod_evento;
    private String nome_evento;
    private String nome_tema;
    private String atracoes;
    private double valor_ingresso;


    public int getCod_evento() {
        return cod_evento;
    }

    public void setCod_evento(int cod_evento) {
        this.cod_evento = cod_evento;
    }

    public String getNome_evento() {
        return nome_evento;
    }

    public void setNome_evento(String nome_evento) {
        this.nome_evento = nome_evento;
    }

    public String getNome_tema() {
        return nome_tema;
    }

    public void setNome_tema(String nome_tema) {
        this.nome_tema = nome_tema;
    }

    public String getAtracoes() {
        return atracoes;
    }

    public void setAtracoes(String atracoes) {
        this.atracoes = atracoes;
    }

    public double getValor_ingresso() {
        return valor_ingresso;
    }

    public void setValor_ingresso(double valor_ingresso) {
        this.valor_ingresso = valor_ingresso;
    }
    
    @Override
    public String toString() {
        return getNome_evento();
    }
}
