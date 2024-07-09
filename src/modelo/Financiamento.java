package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    private static final long serialVersionUID = 1L; // Adicionando serialVersionUID

    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public abstract double pagamentoMensal();
    public abstract double pagamentoTotal();
    public abstract void mostrarInformacoes();

    // Getters
    public double getValorImovel() { return valorImovel; }
    public int getPrazoFinanciamento() { return prazoFinanciamento; }
    public double getTaxaJurosAnual() { return taxaJurosAnual; }
}
