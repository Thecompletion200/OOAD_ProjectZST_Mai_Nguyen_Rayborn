package src;

public class Main {
    public static void main(String[] args) {
        
        creatureFactory creatureFac = new creatureFactory();
    
        creatureInterface creatureTest = creatureFac.getCreature("bandit");
        creatureTest.callout();
    }
}