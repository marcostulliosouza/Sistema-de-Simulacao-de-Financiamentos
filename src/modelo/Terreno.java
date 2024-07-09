package modelo;

public class Terreno extends Financiamento {
    private static final long serialVersionUID = 1L; // Adicionando serialVersionUID

    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
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
        System.out.printf("Financiamento [Terreno] - Valor do Imóvel: R$ %.2f, Valor Mensal: R$ %.2f, Valor Total do Financiamento: R$ %.2f%n",
                valorImovel, pagamentoMensal(), pagamentoTotal());
    }

    public String getTipoZona() {
        return tipoZona;
    }
}
