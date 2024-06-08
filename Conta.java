import java.util.Scanner;

public abstract class Conta implements IConta {
    Scanner sc = new Scanner(System.in);
    // DEFINIR UM VALOR PADRÃO DE AGENCIA
    private static final int AGENCIA_PADRAO = 1;

    private static final String SIM = null;

    // IMPLEMENTAR ADD NUMERO SEQUENCIAL
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected double investir;
    protected String opcao = SIM, NÃO;

    // CONSTRUTOR
    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.investir = 1.3;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);

    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %2f", this.saldo));

        if (saldo > 0) {

            System.out.println("Temos uma linha de investimento 103% do CDI para você, deseja conhecer?");
            System.out.println("Escolha uma opção:SIM, NÃO");

            String opcao = sc.nextLine();

            switch (opcao) {
                case "SIM":
                    this.saldo = saldo * investir;
                    System.out.println(saldo);
                    break;
                case "NÃO":
                    break;
                default:
            }

        } else {
            System.out.println("Acreditamos que tem potencial, continue interagindo em nosso Banco");

        }
    }
}
