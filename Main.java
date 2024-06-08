
public class Main {

    public static void main(String[] args) {

        Cliente Test1 = new Cliente();
        Test1.setNome("Teste1");

        Conta cc = new ContaCorrente(Test1);
        cc.depositar(100);

        Conta poupanca = new ContaPoupanca(Test1);

        cc.transferir(50, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

    }
}
