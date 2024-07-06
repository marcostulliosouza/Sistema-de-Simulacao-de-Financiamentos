package modelo;

public class Apartamento extends Financiamento {
    private int numeroVagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numeroVagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numeroVagasGaragem = numeroVagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double pagamentoMensal() {
        double taxaMensal = (taxaJurosAnual / 100) / 12;
        int meses = prazoFinanciamento * 12;
        return (valorImovel * taxaMensal * Math.pow(1 + taxaMensal, meses)) / (Math.pow(1 + taxaMensal, meses) - 1);
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
}
