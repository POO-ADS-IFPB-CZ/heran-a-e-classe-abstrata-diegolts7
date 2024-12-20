package src.model;

public abstract class Conta {
    private final int numero;
    private String nome_titular;
    protected double saldo;

    public Conta(int numero, String nome_titular, double saldo) {
        this.numero = numero;
        this.nome_titular = nome_titular;
        this.saldo = saldo;
    }

    public Conta(int numero, String nome_titular) {
        this.numero = numero;
        this.nome_titular = nome_titular;
        this.saldo = 0;
    }

    public void depositar(double valor){
        this.saldo+= valor;
    }

    @Override
    public String toString(){
        return "Conta " + this.getClass().getSimpleName() + " numero " + this.getNumero();
    }

    public boolean sacar(double valor){
        if (this.getSaldo() >= valor){
            this.saldo-= valor;
            return true;
        }
        return false;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome_titular() {
        return nome_titular;
    }

    public void setNome_titular(String nome_titular) {
        this.nome_titular = nome_titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
