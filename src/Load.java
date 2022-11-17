package src;

// Main function for loading all data, This is implempented for clean code and encapsulation
public class Load {
    
    public Heroes hero(String userData){

        System.out.println("Loading Hero...");

        if(userData.equals("Knight")){
            Heroes returnKnight = new Knight();
            return returnKnight;
        }
        else if(userData.equals("Archer")){
            Heroes returnArcher = new Archer();
            return returnArcher;

        }
        else if(userData.equals("Rouge")){
            Heroes returnRogue = new Rogue();
            return returnRogue;
        }
        else if(userData.equals("Mage")){
            Heroes returnMage = new Mage();
            return returnMage;
        }
        else{
            Heroes returnPriest = new Priest();
            return returnPriest;
        }
    }

    public void weapon(Heroes advHero, String userData){

        if(userData.equals("Sword")){
            Sword returnWeapon = new Sword();
            return;
        }

    }
}
