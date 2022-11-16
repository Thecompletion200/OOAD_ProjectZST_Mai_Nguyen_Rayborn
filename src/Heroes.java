package src;

import src.Maps;

public class Heroes{
    private int maxHealth = 150;
    private int healthPoints = 150;
    private int experiencePoints = 0;
    private int level = 1;
    private int gold = 50;

    public int meleeDmg = 10;
    public int rangedDmg = 10;
    public int magicDmg = 10;
    public int critDmg = 10;
    private String heroType = "Melee";

    private Maps currLocation;


    public void move(Maps mapToMove){
        currLocation = mapToMove;
    }
    public void purchase(Integer cost){
        gold = gold - cost;
    }
    public void mine(){
        //do something
    }
    public void loot(){
        //do something
    }
    public void craft(){
        //do something
    }
    public int attack(){
        return meleeDmg;
    }
    public void healHero(){
        this.healthPoints = this.maxHealth;
    }
    public String getHeroType(){
        return heroType;
    }
    public void levelUp(){
        if(experiencePoints == (level * 10)){
            this.meleeDmg += 10;
            this.healthPoints = this.maxHealth;
            this.gold += 100;
        }
    }
    public Maps getLocation(){
        return currLocation;
    }
    public Integer getExp(){
        return experiencePoints;
    }
}

class Knight extends Heroes{
    
}

class Archer extends Heroes{

    int healthPoint = 100;
    private String heroType = "Range";
    
}

class Rogue extends Heroes{

    int healthPoint = 120;
    // private String heroType = "Melee";
    
}

class Mage extends Heroes{

    int healthPoint = 80;
    private String heroType = "Magic";

}

class Priest extends Heroes{

    int healthPoint = 80;
    private String heroType = "Magic";
}