package src.model;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(int numero, String nomeTitular){
        super(numero, nomeTitular);
    }

    public void reajustar(double percentual){
        this.depositar(this.getSaldo() * percentual);
    }
}
