package src;

import java.io.Serializable;
import java.util.List;

public class Maps implements Serializable{
    private boolean hasHero = false;
    private Monster currMonster;
    private boolean hasShop = false;
    private boolean bossDefeated = false;
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
    
    public void setBossDefeated()
    {
        this.bossDefeated = true;
    }

    public Boolean getBossDefeated(){
        return bossDefeated;
    }

    public void fight(FightStrategy fightMethod){
 
    } 
}

// Town
class Elden extends Maps {
    
    public Elden(){
        this.setBossDefeated();
        this.setLocationName("Elden");
    }
    // Heals hero for sum of gold
    public void healHero(Heroes currHero){
        currHero.healHero();
    }
}

// Shop
class EldenPawn extends Maps {
    // Shopping
    public void setUpShop(){
        
    }
    public EldenPawn(){
        this.setBossDefeated();
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
        this.setLocationName("Rea Sea");
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
