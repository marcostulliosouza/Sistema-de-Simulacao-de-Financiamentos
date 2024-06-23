package modelo;

public class Financiamento {
    // Atributos
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    // Método Construtor
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // Métodos para Pagamento
    public double pagamentoMensal(){
        return ((valorImovel / (prazoFinanciamento * 12)) * (1 + ((taxaJurosAnual / 100) / 12)));
    }

    public double pagamentoTotal(){
        return (pagamentoMensal() * (prazoFinanciamento) * 12);
    }

    // Getters
    public double getValorImovel(){
        return valorImovel;
    }
    public int getPrazoFinanciamento(){
        return prazoFinanciamento;
    }
    public double getTaxaJurosAnual(){
        return taxaJurosAnual;
    }

    public void mostrarInformacoes(){
        System.out.printf("Valor do Imóvel: R$ %.2f%n", valorImovel);
        System.out.printf("Prazo do Financiamento: %d anos%n", prazoFinanciamento);
        System.out.printf("Taxa de Juros Anual: %.2f%%%n", taxaJurosAnual);
        System.out.printf("Pagamento Mensal: R$ %.2f%n", pagamentoMensal());
        System.out.printf("Total do Pagamento: R$ %.2f%n", pagamentoTotal());
    }
}
