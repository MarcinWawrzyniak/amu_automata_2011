package pl.edu.amu.wmi.daut.re;

import pl.edu.amu.wmi.daut.base.AutomataOperations;
import pl.edu.amu.wmi.daut.base.AutomatonSpecification;
/**
 * Klasa reprezentująca operator '|' z wyrażeń regularnych (alternatywa).
 */
public class AlternativeOperator extends BinaryRegexpOperator {
    @Override
    public final AutomatonSpecification createAutomatonFromTwoAutomata(
            AutomatonSpecification leftSubautomaton,
            AutomatonSpecification rightSubautomaton) {
        return AutomataOperations.sum(leftSubautomaton, rightSubautomaton);
    }

}
