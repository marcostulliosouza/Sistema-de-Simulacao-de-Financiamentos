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

}
