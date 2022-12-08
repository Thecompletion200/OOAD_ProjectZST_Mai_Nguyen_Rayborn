package src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.plaf.metal.MetalLabelUI;

import src.Maps;

public class Heroes implements Serializable{

    private float maxHealth = 150;
    private float healthPoints = 150;
    private boolean isDead = false;
    private String heroType = "Knight";
    public String damageType = "Melee";
    private String heroName;
    private float resistance = 0;
    // all of these we don't need to override
    private int experiencePoints = 0;
    private int level = 1;
    private int gold = 25;
    public Items weapon;
    public Items armor;
    public int meleeDmg = 10;
    public int rangedDmg = 10;
    public int magicDmg = 10;
    public float critMult = (float)1.5;
    public float critChance = 0;
    public boolean ran = false;
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
    public String getDamageType(){
        return damageType;
    }
    // Location
    public Maps getLocation(){
        return currLocation;
    }
    public void move(String mapToMove){
        for(int i = 0; i < this.availMaps.size(); i++){
            if(this.availMaps.get(i).getLocationName().equalsIgnoreCase(mapToMove)){
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
    public void addMap(Maps map){
        // Map Boss defeated
        if(map.getBossDefeated()){
            switch(map.getLocationName()){
                case "Elden":
                    Fiji fiji = new Fiji();
                    this.availMaps.add(fiji);
                    System.out.println("Congratulations! You've unlocked a new map: Fiji!");
                    break;
                case "Fiji":
                    RedSea redSea = new RedSea();
                    this.availMaps.add(redSea);
                    System.out.println("Congratulations! You've unlocked a new map: The Red Sea!");
                    break;
                case "Red Sea":
                    FireLinkShrine fireLinkShrine = new FireLinkShrine();
                    this.availMaps.add(fireLinkShrine);
                    System.out.println("Congratulations! You've unlocked a new map: The Fire Link Shrine!");
                    break;
                case "The Fire Link Shrine":
                    Indicapower indicapower = new Indicapower();
                    this.availMaps.add(indicapower);
                    System.out.println("Congratulations! You've unlocked a new map: Indicapower!");
                    break;
                case "Indicapower":
                    Sativatoff sativatoff = new Sativatoff();
                    this.availMaps.add(sativatoff);
                    System.out.println("Congratulations! You've unlocked the final map: Sativatoff!");
                    break;
                default:
                    break;
            }
        }
    }
    // Health
    public float getMaxHealthPoints(){
        return this.maxHealth;
    }
    public void setMaxHealth(float mHp){
        this.maxHealth = mHp;
    }
    public float getHealthPoints(){
        return this.healthPoints;
    }
    public void setHealthPoints(float hp){
        this.healthPoints = hp;
    }
    public void setIsDead(boolean t){
        this.isDead = t;
    }
    public boolean getIsDead(){
        return this.isDead;
    }
    public void checkIsDead(){
        if(this.healthPoints <= 0){
            this.isDead = true;
        }
    }
    public void setResistance(int r){
        this.resistance = r;
    }
    public float getResistance(){
        // Percentage
        this.resistance = this.armor.getArmorRating()/100;
        return this.resistance;
    }
    public void healHero(){
        this.healthPoints = this.maxHealth;
        System.out.println("You have been restored to full health!");
    }
    public void damageHero(float monsterDamage){
        float totalDmg = monsterDamage * (1-this.resistance);
        this.healthPoints-= totalDmg; 
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
        // if the player does not have weapon
        if(this.weapon == null){
            return meleeDmg;
        }

        // Melee damage
        if(this.getWeapon().getWeaponType().equalsIgnoreCase("Melee")){
            return meleeDmg + this.weapon.getDamage();
        }
        // Ranged Damage
        else if(this.getWeapon().getWeaponType().equalsIgnoreCase("Range")){
            return rangedDmg + this.weapon.getDamage();
        }
        // Magic Damage
        else{
            return magicDmg + this.weapon.getDamage();
        }
    }
    public void setCritChance(float cc){
        this.critChance = cc;
    }
    public float getCritChance(){
        return this.critChance;
    }
    // EXP and Gold and Inventory
    public Integer getExp(){
        return experiencePoints;
    }
    public void setExp(Integer exp){
        this.experiencePoints = exp;
    }
    public void giveExp(int exp){
        this.experiencePoints += exp;
    }
    public Integer getHeroLevel(){
        return this.level;
    }
    public void setHeroLevel(int l){
        this.level = l;
    }
    public void levelUp(){
        // In order to level up, we need to reach exp equivalent to level*10
        // We will repeat 10 times in case we level up more than once
        for(int i = 0; i < 10; i++){
            if(this.experiencePoints >= (this.level * 10)){
                // Increase Stats
                this.level++;
                this.meleeDmg *= 1.25;
                this.maxHealth *= 1.25;
                this.healthPoints = this.maxHealth;
                this.gold += this.level * 100;
                System.out.println("Congratulations! You have leveled up! You are now level " + this.level + "!\nDamage and Health have been increased.\n100 gold has been added to your inventory.\n ");
            }
        }
    }
    public Integer getGold(){
        return this.gold;
    }
    public void setGold(int g){
        this.gold = g;
    }
    public void pickUpGold(Integer g){
        this.gold = gold + g;
    }
    public boolean purchase(Integer cost){
        // If you don't have enough money...
        if((this.gold - cost) < 0){
            System.out.println("You do not have enough gold for this purchase...");
            return false;
        }
        // otherwise
        else{
            this.gold = this.gold - cost;
            return true;
        }
    }
    public void addToHeroInventory(Items i){
        this.inventory.add(i);
    }
    public String getHeroInventory(){
        String output = "Inventory: ";
        for(int i = 0; i < this.inventory.size(); i++){
            if(i == this.inventory.size() - 1){
                output = output + this.inventory.get(i).getItemName();
            }
            else{
                output = output + this.inventory.get(i).getItemName() + ", ";
            }
        }

        return output;
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
        this.setMaxHealth(110);
        this.setHealthPoints(110);

    }
    @Override
    public void levelUp(){
        if(this.getExp() == (this.getHeroLevel() * 10)){
            // Increase Stats
            this.setHeroLevel(this.getHeroLevel() + 1);
            this.rangedDmg *= 1.25;
            this.setMaxHealth(this.getMaxHealthPoints() * (float)1.25);
            this.setHealthPoints(this.getMaxHealthPoints());
            this.setGold(this.getGold() + 100);
            System.out.println("Congratulations! You have leveled up! You are now level " + this.getHeroLevel() + "!\nDamage and Health have been increased.\n100 gold has been added to your inventory.\n ");
        }
    }
}

class Rogue extends Heroes{

    public Rogue(){
        this.setHeroType("Rogue");
        this.setDamageType("Melee");
        this.setMaxHealth(125);
        this.setHealthPoints(125);
        this.critChance = 5;
        this.critMult = (float)1.5;
    }
    @Override
    public void levelUp(){
        if(this.getExp() == (this.getHeroLevel() * 10)){
            // Increase Stats
            this.setHeroLevel(this.getHeroLevel() + 1);
            this.meleeDmg *= 1.25;
            this.critChance *= 1.25;
            this.setMaxHealth(this.getMaxHealthPoints() * (float)1.25);
            this.setHealthPoints(this.getMaxHealthPoints());
            this.setGold(this.getGold() + 100);
            System.out.println("Congratulations! You have leveled up! You are now level " + this.getHeroLevel() + "!\nDamage and Health have been increased.\n100 gold has been added to your inventory.\n ");
        }
    }
}

class Mage extends Heroes{
    public Mage(){
        this.setHeroType("Mage");
        this.setDamageType("Magic");
        this.setMaxHealth(100);
        this.setHealthPoints(100);
    }
    @Override
    public void levelUp(){
        if(this.getExp() == (this.getHeroLevel() * 10)){
            // Increase Stats
            this.setHeroLevel(this.getHeroLevel() + 1);
            this.magicDmg *= 1.25;
            this.setMaxHealth(this.getMaxHealthPoints() * (float)1.25);
            this.setHealthPoints(this.getMaxHealthPoints());
            this.setGold(this.getGold() + 100);
            System.out.println("Congratulations! You have leveled up! You are now level " + this.getHeroLevel() + "!\nDamage and Health have been increased.\n100 gold has been added to your inventory.\n ");
        }
    }
}

class Priest extends Heroes{
    public Priest(){
        this.setHeroType("Priest");
        this.setDamageType("Range");
        this.setMaxHealth(80);
        this.setHealthPoints(80);

    }
    @Override
    public void levelUp(){
        if(this.getExp() == (this.getHeroLevel() * 10)){
            // Increase Stats
            this.setHeroLevel(this.getHeroLevel() + 1);
            this.magicDmg *= 1.25;
            this.setMaxHealth(this.getMaxHealthPoints() * (float)1.25);
            this.setHealthPoints(this.getMaxHealthPoints());
            this.setGold(this.getGold() + 100);
            System.out.println("Congratulations! You have leveled up! You are now level " + this.getHeroLevel() + "!\nDamage and Health have been increased.\n100 gold has been added to your inventory.\n ");
        }
    }
}