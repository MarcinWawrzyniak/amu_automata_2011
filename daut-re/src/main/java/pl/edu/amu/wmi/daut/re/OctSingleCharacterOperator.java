package pl.edu.amu.wmi.daut.re;

import java.util.logging.Level;
import java.util.logging.Logger;
import pl.edu.amu.wmi.daut.base.AutomatonSpecification;
import pl.edu.amu.wmi.daut.base.NaiveAutomatonSpecification;
import java.util.List;

/**
 * Klasa reprezentująca pojedynczy konkretny znak o kodzie Unicode podany w zapisie ósemkowym.
 */
public class OctSingleCharacterOperator extends NullaryRegexpOperator {

    private String octValue;
    static final int BASE = 8;

    /**
     * Konstruktor.
     */
    public OctSingleCharacterOperator(String a) {
       this.setOctValue(a);
    }

    /**
     * Metoda, ustawia nową wartość ( sprawdza czy jest w kodzie ósemkowym).
     */
    private void setOctValue(String i) {
        if (isOctal(i))
            this.octValue = i;
        else throw new RuntimeException();
    }

    /**
     * Metoda zwraca aktualną wartość (w kodzie ósemkowym).
     */
    public String getOctValue() {
        return octValue;
    }

    /**
     * Metoda zwraca znak odpowiadający aktualnej wartości octValue.
     */
    public char getCharacter() {
        return (char) Integer.parseInt(octValue, BASE);
    }

    /**
     * Metoda sprawdza, czy wartość jest w kodzie ósemkowym.
     */
    private boolean isOctal(String number) {

        try {
                Integer.parseInt(number, BASE);
            } catch (Exception ex) {
                return false;
            }
            return true;
    }

    @Override
    public AutomatonSpecification createFixedAutomaton() {

        int intValue = Integer.parseInt(octValue, BASE);

        return new NaiveAutomatonSpecification()
                .makeOneTransitionAutomaton((char) intValue);
    }

    /**
     * Fabryka operatora.
     */
    public static class Factory extends NullaryRegexpOperatorFactory {

        @Override
        public int numberOfParams() {
            return 1;
        }

        @Override
        protected RegexpOperator doCreateOperator(List<String> params) {
            OctSingleCharacterOperator oper = null;

            try {
                oper = new OctSingleCharacterOperator(params.get(0));
            } catch (Exception ex) {
                throw new RuntimeException();
            }
            return oper;
        }
    }
}
