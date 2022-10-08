package br.calebe.ticketmachine.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

public class TrocoIteratorTest {

    @ParameterizedTest
    @ValueSource(ints = { 100, 50, 20, 10, 5, 2})
    public void TrocoIterator_MustReturnNull_WhenPapeisMoedaIsNull(int vPapelMoeda)
    {
        Troco troco = new Troco(vPapelMoeda);
        Arrays.fill(troco.papeisMoeda, null);
        Troco.TrocoIterator ti = troco.new TrocoIterator(troco);
        Assertions.assertThat(ti.next()).isEqualTo(null);
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 5, 10, 20, 50, 100 })
    public void TrocoIterator_MustReturnFalse_WhenPapeisMoedaisNull(int valor)
    {
        Troco troco = new Troco(valor);
        Arrays.fill(troco.papeisMoeda, null);
        Troco.TrocoIterator ti = troco.new TrocoIterator(troco);
        Assertions.assertThat(ti.hasNext()).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(ints = { 100, 50, 20, 10, 5, 2})
    public void TrocoIterator_MustReturnoTroco_WhenPapeisMoedaIsNotNull(int vPapelMoeda)
    {
        Troco troco = new Troco(vPapelMoeda);

        int count = valorPapelMoeda / 100;
        Troco.TrocoIterator ti = troco.new TrocoIterator(troco);
        PapelMoeda compare = new PapelMoeda(100, count);
        PapelMoeda retorno = ti.next();
        boolean result = retorno.quantidade == compare.quantidade && retorno.valor == compare.valor;
        Assertions.assertThat(result).isEqualTo(true);
    }

    
    @ParameterizedTest
    @ValueSource(ints = { 2, 5, 10, 20, 50, 100 })
    public void TrocoIterator_MustReturnTrue_WhenPapeisMoedaisNotNull(int valor)
    {
        Troco troco = new Troco(valor);
        Troco.TrocoIterator ti = troco.new TrocoIterator(troco);
        Assertions.assertThat(ti.hasNext()).isEqualTo(true);
    }
}
