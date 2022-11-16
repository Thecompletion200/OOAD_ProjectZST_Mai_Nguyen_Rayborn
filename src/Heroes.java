package src;

import src.Maps;

public class Heroes{
    private int maxHealth = 150;
    private int healthPoints = 150;
    private int experiencePoints = 0;
    private int level = 1;
    private int gold = 50;

    private int meleeDmg = 10;
    private int rangedDmg = 10;
    private int magicDmg = 10;
    private int critDmg = 10;
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
    
    @Override
    public void levelUp(){
        experiencePoint = experiencePoint + 1;
        if(experiencePoint == 10){
            rangedDmg = rangedDmg + 15;
        }
    }

    @Override
    public int attack(){
        return rangedDmg;
    }
}

class Rogue extends Heroes{

    int healthPoint = 120;
    // private String heroType = "Melee";

    @Override
    public void levelUp(){
        experiencePoint = experiencePoint + 1;
        if(experiencePoint == 10){
            critDmg = critDmg + 20;
        }
    }
    
}

class Mage extends Heroes{

    int healthPoint = 80;
    private String heroType = "Magic";

    @Override
    public void levelUp(){
        experiencePoint = experiencePoint + 1;
        if(experiencePoint == 10){
            magicDmg = magicDmg + 25;
        }
    }
    @Override
    public int attack(){
        return magicDmg;
    }
}

class Priest extends Heroes{

    int healthPoint = 80;
    private String heroType = "Magic";

    @Override
    public void levelUp(){
        experiencePoint= experiencePoint + 1;
        if(experiencePoint == 10){
            magicDmg = magicDmg + 25;
        }
    }

    //Mage only ability
    @Override
    public int attack(){
        return magicDmg;
    }
}