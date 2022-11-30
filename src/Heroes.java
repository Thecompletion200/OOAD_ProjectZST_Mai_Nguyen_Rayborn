package src;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.plaf.metal.MetalLabelUI;

import src.Maps;

public class Heroes implements Serializable{

    private int maxHealth = 150;
    private int healthPoints = 150;
    private String heroType = "Knight";
    public String damageType = "Melee";
    private String heroName;
    // all of these we don't need to override
    private int experiencePoints = 0;
    private int level = 1;
    private int gold = 50;
    public Items weapon;
    public Items armor;
    public int meleeDmg = 10;
    public int rangedDmg = 10;
    public int magicDmg = 10;
    public int critMult = 1;
    private Maps currLocation;
    public ArrayList<Maps> availMaps = new ArrayList<Maps>();

    public Heroes(){
        super();
    }

    // Getters and Setters and Methods
    // Name
    public void setName(String name){
        this.heroName = name;
    }
    public String getHeroName(){
        return heroName;
    }
    // Hero Type
    public void setHeroType(String hType){
        this.heroType = hType;
    }
    public String getHeroType(){
        return heroType;
    }
    // Damage Type
    public void setDamageType(String dType){
        this.damageType = dType;
    }
    public String getDamgeType(){
        return damageType;
    }
    // Location
    public Maps getLocation(){
        return currLocation;
    }
    public void move(Maps mapToMove){
        currLocation = mapToMove;
        mapToMove.setHasHero(true);
    }
    public String getLocationName(){
        return currLocation.getLocationName();
    }
    public void addMap(ArrayList<Maps> allMaps){
        // Map Boss defeated
        ArrayList<Maps> tempAvailMaps = new ArrayList<Maps>();
        // Add Elden
        tempAvailMaps.add(allMaps.get(0));
        for(int i = 1; i < allMaps.size(); i++){
            if(allMaps.get(i).getBossDefeated())
            {   
                tempAvailMaps.add(allMaps.get(i));
            }
        }
        this.availMaps = tempAvailMaps;
        System.out.println("Congratulations! You've unlocked a new map!");
    }
    // EXP
    public Integer getExp(){
        return experiencePoints;
    }
    public void setExp(Integer exp){
        this.experiencePoints = exp;
    }
    // Health
    public Integer getMaxHealthPoints(){
        return this.maxHealth;
    }
    public void setMaxHealth(Integer mHp){
        this.maxHealth = mHp;
    }
    public Integer getHealthPoints(){
        return this.healthPoints;
    }
    public void setHealthPoints(Integer hp){
        this.healthPoints = hp;
    }
    // Weapons and Damage
    public void equipWeapon(Items weapon){
        this.weapon = weapon;
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
    // public void levelUp(){
    //     if(experiencePoints == (level * 10)){
    //         this.meleeDmg += 10;
    //         this.healthPoints = this.maxHealth;
    //         this.gold += 100;
    //     }
    // }
}

class Knight extends Heroes{
    
}

class Archer extends Heroes{
    
    public Archer(){
        this.setHeroType("Archer");
        this.setDamageType("Range");
        this.setMaxHealth(120);
        this.setHealthPoints(120);

    }
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

    public Rogue(){
        this.setHeroType("Rogue");
        this.setDamageType("Melee");
        this.setMaxHealth(125);
        this.setHealthPoints(125);

    }
    // public void levelUp(){
    //     if(experiencePoints == (level * 10)){
    //         this.meleeDmg += 10;
    //         this.healthPoints = this.maxHealth;
    //         this.gold += 100;
    //     }
    // }
}

class Mage extends Heroes{
    public Mage(){
        this.setHeroType("Mage");
        this.setDamageType("Magic");
        this.setMaxHealth(100);
        this.setHealthPoints(100);

    }
    // public void levelUp(){
    //     if(experiencePoints == (level * 10)){
    //         this.magicDmg += 10;
    //         this.healthPoints = this.maxHealth;
    //         this.gold += 100;
    //     }
    // }
}

class Priest extends Heroes{
    public Priest(){
        this.setHeroType("Priest");
        this.setDamageType("Range");
        this.setMaxHealth(80);
        this.setHealthPoints(80);

    }
    // public void levelUp(){
    //     if(experiencePoints == (level * 10)){
    //         this.magicDmg += 10;
    //         this.healthPoints = this.maxHealth;
    //         this.gold += 100;
    //     }
    // }
}