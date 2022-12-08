package src;

import java.io.Serializable;
import java.util.List;

public class Maps implements Serializable{
    private boolean hasHero = false;
    private Monster currMonster;
    private boolean hasShop = false;
    private boolean bossDefeated = false;
    private int monstersDefeated = 0;
    private String locationName;
    

    public void setLocationName(String lName){
        this.locationName = lName;
    }
    public String getLocationName(){
        return locationName;
    }
    public void setHasHero(Boolean hasHero){
        this.hasHero = hasHero;
    }
    public Boolean getHasHero(){
        return hasHero;
    }

    public void setCurrMonster(Monster currMonster){
        this.currMonster = currMonster;
    }
    public Monster getCurrMonster(){
        return this.currMonster;
    }
    
    public void setBossDefeated(boolean bd)
    {
        this.bossDefeated = bd;
    }

    public Boolean getBossDefeated(){
        return bossDefeated;
    }
    public void setMonstersDefeated(int mD){
        this.monstersDefeated = mD;
    }
    public int getMonstersDefeated(){
        return this.monstersDefeated;
    }
    public void increaseMonstersDefeated(){
        this.monstersDefeated++;
    }

    public void fight(FightStrategy fightMethod){
 
    } 
}

// Town
class Elden extends Maps {
    
    public Elden(){
        this.setBossDefeated(true);
        this.setLocationName("Elden");
    }
}

// Shop
class EldenPawn extends Maps {
    // Shopping
    public void setUpShop(){
        
    }
    public EldenPawn(){
        this.setBossDefeated(true);
        this.setLocationName("The Elden Pawn");
    }

}

// First Map
class Fiji extends Maps {

    public Fiji(){
        this.setLocationName("Fiji");
    }
}

// Second Map
class RedSea extends Maps {

    public RedSea(){
        this.setLocationName("Red Sea");
    }
}

// Third map
class FireLinkShrine extends Maps {

    public FireLinkShrine(){
        this.setLocationName("The Fire Link Shrine");
    }

}

// Fourth Map
class Indicapower extends Maps {

    public Indicapower(){
        this.setLocationName("Indicapower");
    }
}

// Final Map
class Sativatoff extends Maps {
    
    public Sativatoff(){
        this.setLocationName("Sativatoff");
    }
}
