package src;

import java.io.Serializable;

import javax.swing.plaf.metal.MetalLabelUI;

import src.Maps;

public class Heroes implements Serializable{

    private int maxHealth = 150;
    private int healthPoints = 150;
    private int experiencePoints = 0;
    private int level = 1;
    private int gold = 50;
    private String heroType = "Knight";
    private String heroName;

    public int meleeDmg = 10;
    public int rangedDmg = 10;
    public int magicDmg = 10;
    public int critMult = 1;
    public String damageType = "Melee";
    public Items weapon;
    public Items armor;

    private Maps currLocation;

    public Heroes(){
        super();
    }

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
        if(weapon.weaponType.equals("Melee")){
            return meleeDmg + weapon.getDamage();
        }
        else if(weapon.weaponType.equals("Range")){
            return rangedDmg + weapon.getDamage();

        } 
        else if(weapon.weaponType.equals("Magic")){
            return magicDmg + weapon.getDamage();
        }
        // no weapon
        else{
            return meleeDmg;
        }
    }
    public void healHero(){
        this.healthPoints = this.maxHealth;
    }
    public void damageHero(int monsterDamage){
        this.healthPoints-= monsterDamage; 
    }
    public void setName(String name){
        this.heroName = name;
    }
    public String getHeroName(){
        return heroName;
    }
    public String getHeroType(){
        return heroType;
    }
    public String getDamgeType(){
        return damageType;
    }
    // public void levelUp(){
    //     if(experiencePoints == (level * 10)){
    //         this.meleeDmg += 10;
    //         this.healthPoints = this.maxHealth;
    //         this.gold += 100;
    //     }
    // }
    public Maps getLocation(){
        return currLocation;
    }
    public Integer getExp(){
        return experiencePoints;
    }
    public Integer getHealthPoints(){
        return this.healthPoints;
    }

    public void equipWeapon(Items weapon){
        this.weapon = weapon;
    }
}

class Knight extends Heroes{
    int healthPoint = 130;
}

class Archer extends Heroes{
    int healthPoint = 100;
    private String heroType = "Range";
    // @Override
    // public void levelUp(){
    //     if(experiencePoints == (level * 10)){
    //         this.rangedDmg += 10;
    //         this.healthPoints = this.maxHealth;
    //         this.gold += 100;
    //     }
    // }
}

class Rogue extends Heroes{

    int healthPoint = 120;
    private String heroType = "Melee";
    // public void levelUp(){
    //     if(experiencePoints == (level * 10)){
    //         this.meleeDmg += 10;
    //         this.healthPoints = this.maxHealth;
    //         this.gold += 100;
    //     }
    // }
}

class Mage extends Heroes{
    int healthPoint = 80;
    private String heroType = "Magic";
    // public void levelUp(){
    //     if(experiencePoints == (level * 10)){
    //         this.magicDmg += 10;
    //         this.healthPoints = this.maxHealth;
    //         this.gold += 100;
    //     }
    // }
}

class Priest extends Heroes{
    int healthPoint = 80;
    private String heroType = "Magic";
    // public void levelUp(){
    //     if(experiencePoints == (level * 10)){
    //         this.magicDmg += 10;
    //         this.healthPoints = this.maxHealth;
    //         this.gold += 100;
    //     }
    // }
}