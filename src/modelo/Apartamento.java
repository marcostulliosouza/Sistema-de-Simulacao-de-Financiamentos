package modelo;

public class Apartamento extends Financiamento {
    private static final long serialVersionUID = 1L; // Adicionando serialVersionUID

    private int numeroVagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numeroVagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numeroVagasGaragem = numeroVagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double pagamentoMensal() {
        double valorMensal = (valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 100) / 12);
        return valorMensal;
    }

    @Override
    public double pagamentoTotal() {
        return pagamentoMensal() * prazoFinanciamento * 12;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.printf("Financiamento [Apartamento] - Valor do Imóvel: R$ %.2f, Valor Mensal: R$ %.2f, Valor Total do Financiamento: R$ %.2f%n",
                valorImovel, pagamentoMensal(), pagamentoTotal());
    }

    public int getNumeroVagasGaragem() {
        return numeroVagasGaragem;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }
}
