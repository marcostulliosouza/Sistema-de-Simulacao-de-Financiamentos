package modelo;

import util.DescontoMaiorDoQueJurosException;

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

    public double aplicarDesconto(double desconto) throws DescontoMaiorDoQueJurosException {
        double valorMensal = pagamentoMensal();
        double jurosMensal = (valorImovel * (taxaJurosAnual / 100) / 12);
        if (desconto > jurosMensal) {
            throw new DescontoMaiorDoQueJurosException("O desconto não pode ser maior que o valor dos juros da mensalidade.");
        }
        return valorMensal - desconto;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.printf("Financiamento [Casa] - Valor do Imóvel: R$ %.2f, Valor Mensal: R$ %.2f, Valor Total do Financiamento: R$ %.2f%n",
                valorImovel, pagamentoMensal(), pagamentoTotal());
    }
}
