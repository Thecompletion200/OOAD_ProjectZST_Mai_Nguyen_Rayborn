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
    private ArrayList<Items> inventory = new ArrayList<Items>();

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
    public void move(String mapToMove){
        for(int i = 0; i < this.availMaps.size(); i++){
            if(this.availMaps.get(i).getLocationName().equals(mapToMove)){
                this.currLocation = this.availMaps.get(i);
                this.availMaps.get(i).setHasHero(true);
                return;
            }
        }
        System.out.println("You've chosen a map you do not have access to or that doesn't exist!");
    }
    public String getLocationName(){
        return currLocation.getLocationName();
    }
    public void getAvailMoves(){
        System.out.println("Available Maps: ");
        for (int i = 0; i < this.availMaps.size(); i++){
            if(i == this.availMaps.size() - 1){
                System.out.print(this.availMaps.get(i).getLocationName() + "\n");
            }
            else{
                System.out.print(this.availMaps.get(i).getLocationName() + ", ");
            }
        }
    }
    public void addMap(ArrayList<Maps> allMaps){
        // Map Boss defeated
        ArrayList<Maps> tempAvailMaps = new ArrayList<Maps>();
        // Add Elden
        tempAvailMaps.add(allMaps.get(0));
        // Add other maps
        for(int i = 0; i < allMaps.size() - 1; i++){
            if(allMaps.get(i).getBossDefeated())
            {   
                tempAvailMaps.add(allMaps.get(i+1));
            }
        }
        this.availMaps = tempAvailMaps;
        System.out.println("Congratulations! You've unlocked a new map!");
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
    public void healHero(){
        this.healthPoints = this.maxHealth;
    }
    public void damageHero(int monsterDamage){
        this.healthPoints-= monsterDamage; 
    }
    // Weapons and Damage
    public void equipWeapon(Items w){
        this.weapon = w;
    }
    public Items getWeapon(){
        return this.weapon;
    }
    public void equipArmor(Items a){
        this.armor = a;
    }
    public Items getArmor(){
        return this.armor;
    }
    public int attack(){
        if(this.weapon.getWeaponType().equals("Melee")){
            return meleeDmg + this.weapon.getDamage();
        }
        else if(this.weapon.getWeaponType().equals("Range")){
            return rangedDmg + this.weapon.getDamage();

        } 
        else if(this.weapon.getWeaponType().equals("Magic")){
            return magicDmg + this.weapon.getDamage();
        }
        // no weapon
        else{
            return meleeDmg;
        }
    }
    // EXP and Gold and Inventory
    public Integer getExp(){
        return experiencePoints;
    }
    public void setExp(Integer exp){
        this.experiencePoints = exp;
    }
    public Integer getHeroLevel(){
        return this.level;
    }
    public void levelUp(){
        if(this.experiencePoints == (this.level * 10)){
            this.meleeDmg += 10;
            this.healthPoints = this.maxHealth;
            this.gold += this.level * 100;
        }
    }
    public Integer getGold(){
        return this.gold;
    }
    public void pickUpGold(Integer g){
        this.gold = gold + g;
    }
    public void purchase(Integer cost){
        this.gold = this.gold - cost;
    }
    public void addToHeroInventory(Items i){
        this.inventory.add(i);
    }
    public void getHeroInventory(){
        System.out.println("Inventory: ");
        for(int i = 0; i < this.inventory.size(); i++){
            if(i == this.inventory.size() - 1){
                System.out.print(this.inventory.get(i).getItemName());
            }
            else{
                System.out.print(this.inventory.get(i).getItemName() + ", ");
            }
        }
    }
    public void loot(){
        //do something
    }
    public void mine(){
        //do something
    }
    public void craft(){
        //do something
    }
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