package src.view;

import src.model.Conta;
import src.model.ContaEspecial;
import src.model.ContaPoupanca;

import java.util.Scanner;

public class Main {
    private final static Scanner myScanner = new Scanner(System.in);
    private static Conta minhaConta;
    public static void main(String[] args) {

        do {
            System.out.println("BEM VINDO AO SISTEMA\n1. Criar conta\n2. Scar\n3. Depositar\n4. Imprimir tipo conta\n5. Sair");
            int escolha = myScanner.nextInt();

            switch (escolha){
                case 1:
                    criarConta();
                    break;
                case 2:
                    if (contaExiste()){
                        System.out.println("seu saldo é: " + minhaConta.getSaldo());
                        System.out.println("Informe um valor a sacar: ");
                        double valor = myScanner.nextDouble();

                        if (!minhaConta.sacar(valor)) System.err.println("Erro ao sacar, valor não pode ser sacado.");
                    }
                    break;
                case 3:
                    if (contaExiste()){
                        System.out.println("seu saldo é: " + minhaConta.getSaldo());
                        System.out.println("Informe um valor a depositar: ");
                        double valor = myScanner.nextDouble();

                        if (valor > 0){
                            minhaConta.depositar(valor);
                        }else {
                            System.err.println("Erro ao depositar.");
                        }
                    }
                    break;
                case 4:
                    if (contaExiste()){
                        System.out.println(minhaConta.toString());;
                    }
                    break;
                case 5: System.exit(1); break;
            }
        }while(true);
    }

    private  static void criarConta(){
        System.out.println("Informe o numero da conta: ");
        int numero = myScanner.nextInt();

        myScanner.nextLine();

        System.out.println("Informe o nome do titular");
        String nome = myScanner.nextLine();

        System.out.println("Informe o tipo da conta\n1. Poupança\n2. Especial");
        int escolhaConta = myScanner.nextInt();

        switch (escolhaConta){
            case 1:
                minhaConta = new ContaPoupanca(numero, nome);
                break;
            case 2:
                System.out.println("Informe o seu limite: ");
                double limite = myScanner.nextInt();

                while (limite <= 0){
                    System.out.println("Informe um limite válido: ");
                    limite = myScanner.nextInt();
                }
                minhaConta = new ContaEspecial(limite,numero,nome);
                break;
            default:
                System.err.println("Erro ao criar conta");
        }
    }

    private static boolean contaExiste(){
        return minhaConta.getClass() != null;
    }
}
