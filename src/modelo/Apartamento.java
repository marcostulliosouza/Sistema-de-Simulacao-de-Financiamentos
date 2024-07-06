package modelo;

public class Apartamento extends Financiamento{

    // Construtor
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    @Override
    public double pagamentoMensal(){
     double taxaJurosMensal = getTaxaJurosAnual() / 100 / 12;
     int meses = getPrazoFinanciamento() * 12;
     return (getValorImovel()*Math.pow(1 + taxaJurosMensal, meses) * taxaJurosMensal) / (Math.pow(1 + taxaJurosMensal, meses) - 1);
    }
}
