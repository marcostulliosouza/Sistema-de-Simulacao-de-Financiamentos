package modelo;

public class Casa extends Financiamento {
    private double tamanhoAreaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double tamanhoAreaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tamanhoAreaConstruida = tamanhoAreaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    @Override
    public double pagamentoMensal() {
        double valorMensal = (valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 100) / 12);
        return valorMensal + 80; // Adiciona taxa extra de R$ 80
    }

    @Override
    public double pagamentoTotal() {
        return pagamentoMensal() * prazoFinanciamento * 12;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.printf("Casa - Valor do Imóvel: R$ %.2f, Valor Mensal: R$ %.2f, Valor Total do Financiamento: R$ %.2f%n",
                valorImovel, pagamentoMensal(), pagamentoTotal());
    }
}
