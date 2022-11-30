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
    
    // public void setCurrMonster(String currMonster){
    //     this.currMonster = currMonster;
    // }
    // public String getCurrMonster(){
    //     return currMonster;
    // } 

    public void setHasShop(Boolean hs)
    {
        this.hasShop = hs;
    }
    public Boolean getHasShop(){
        return hasShop;
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
    // Heals hero when entering map
    public Elden(){
        this.setHasShop(true);
        this.setBossDefeated();
        this.setLocationName("Elden");
    }
    public void healHero(Heroes currHero){
        currHero.healHero();
    }
}

// First Map
class Fiji extends Maps {
}

// Second Map
class RedSea extends Maps {

}

// Third map
class FireLinkShrine extends Maps {

}

// Fourth Map
class Indicapower extends Maps {

}

// Final Map
class Sativatoff extends Maps {
    
}
