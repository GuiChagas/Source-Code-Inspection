package core;

import exception.PapelMoedaInvalidaException;
import exception.SaldoInsuficienteException;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[i] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException(500, "Nenhum papel moeda válido foi encontrado");
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return saldo;
    }

    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException(500, "Seu saldo não é suficiente");
        }
        String result = "*****************\n";
        result += "*** R$ " + valor + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}
