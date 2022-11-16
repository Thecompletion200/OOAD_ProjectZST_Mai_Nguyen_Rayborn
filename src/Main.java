package src;

public class Main {
    public static void main(String[] args) {
        
        monsterFactory creatureFac = new monsterFactory();
    
        Monster creatureTest = creatureFac.spawnBandit();
        creatureTest.getMonsterName();

    }
}