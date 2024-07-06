package modelo;

public class Terreno extends Financiamento{
    public Terreno (double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    @Override
    public double pagamentoMensal(){
        return super.pagamentoMensal() * 1.02; // Adicionando 2% ao valor da parcela mensal
    }
}
