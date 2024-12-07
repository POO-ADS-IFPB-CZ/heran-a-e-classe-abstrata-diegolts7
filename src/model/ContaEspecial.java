package src.model;

public class ContaEspecial extends  Conta{
    private double limite;

    public  ContaEspecial(double limite, int numero, String nomeTitular){
        super(numero,nomeTitular);
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor){
        if (valor <= this.getSaldo() + this.limite){
            this.saldo -= valor;
            return true;
        }
        return  false;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
