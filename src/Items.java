package src;

import java.io.Serializable;

/*
Weapons:
Melee: sword, longsword, sword of 1000 truths
Range: shortbow, crossbow, longbow, bow of deceit 
Magic: wood staff, iron staff, dragon staff
Armor:
Melee:
Ranged:
Magic:
*/

public class Items implements Serializable{

    private int weaponDamage = 0;
    private int armorRating = 0;
    private String weaponType = "notAWeapon";
    private String itemName = "";
    private int itemCost = 0;
    private int potionStrength = 0;

    public void setDamage(Integer dmg){
        this.weaponDamage = dmg;
    }
    public int getDamage(){
        return this.weaponDamage;
    }
    public void setWeaponType(String type){
        this.weaponType = type;
    }
    public String getWeaponType(){
        return this.weaponType;
    }
    public int getArmorRating(){
        return armorRating;
    }
    public void setItemName(String iName){
        this.itemName = iName;
    }
    public String getItemName(){
        return this.itemName;
    }
    public void setItemCost(int cost){
        this.itemCost = cost;
    }
    public int getItemCost(){
        return this.itemCost;
    }
    public void setPotionStrength(Integer str){
        this.potionStrength = str;
    }
    public Integer getPotionStrength(){
        return this.potionStrength;
    }
    
}

// Melee Weapons
class WoodenSword extends Items{

    public WoodenSword(){
        this.setDamage(10);
        this.setItemCost(15);
        this.setWeaponType("Melee");
        this.setItemName("Wooden Sword");
    }
}


class SteelSword extends Items{

    public SteelSword(){
        this.setDamage(20);
        this.setWeaponType("Melee");
        this.setItemName("Steel Sword");
    }
}

class TitaniumSword extends Items{
    
    public TitaniumSword(){
        this.setDamage(30);
        this.setWeaponType("Melee");
        this.setItemName("Titanium Sword");
    }
}

class TungstenSword extends Items{

    public TungstenSword(){
        this.setDamage(45);
        this.setWeaponType("Melee");
        this.setItemName("Tungsten Sword");
    }
}

// TEST WEAPON
class HELLBRINGER extends Items{

    public HELLBRINGER(){
        this.setDamage(999999);
        this.setWeaponType("Melee");
        this.setItemName("Hellbringer");
    }
}
// Rougue Weapons
class Knives extends Items{

    public Knives(){
        this.setDamage(10);
        this.setWeaponType("Melee");
        this.setItemName("Knives");
    }
}

class Kyokestu extends Items{

    public Kyokestu(){
        this.setDamage(20);
        this.setWeaponType("Melee");
        this.setItemName("Kyokestu");
    }
}

class DualKatanas extends Items{

    public DualKatanas(){
        this.setDamage(30);
        this.setWeaponType("Melee");
        this.setItemName("Dual Katanas");
    }
}

class DragonsBlade extends Items{

    public DragonsBlade(){
        this.setDamage(45);
        this.setWeaponType("Melee");
        this.setItemName("Dragons Blade");
    }
}

// Archer Weapons
class WoodenBow extends Items{

    public WoodenBow(){
        this.setDamage(10);
        this.setWeaponType("Range");
        this.setItemName("Wooden Bow");
    }
}

class LongBow extends Items {

    public LongBow(){
        this.setDamage(20);
        this.setWeaponType("Range");
        this.setItemName("Long Bow");
    }
}

class JaguarStrike extends Items {
    
    public JaguarStrike(){
        this.setDamage(30);
        this.setWeaponType("Range");
        this.setItemName("The Jaguars Strike");
    }
}

class Yumi extends Items {

    public Yumi(){
        this.setDamage(45);
        this.setWeaponType("Range");
        this.setItemName("Yumi");
    }
}

// Mage and Priest Weapons
class WoodenStaff extends Items {

    public WoodenStaff(){
        this.setDamage(10);
        this.setWeaponType("Magic");
        this.setItemName("Wooden Staff");
    }
}

class SteelScepter extends Items {

    public SteelScepter(){
        this.setDamage(20);
        this.setWeaponType("Magic");
        this.setItemName("Steel Scepter");
    }
}

class GoldenScepter extends Items {

    public GoldenScepter(){
        this.setDamage(30);
        this.setWeaponType("Magic");
        this.setItemName("Golden Scepter");
    }
}

class BookofOmniscience extends Items {

    public BookofOmniscience(){
        this.setDamage(45);
        this.setWeaponType("Magic");
        this.setItemName("Book of Omniscience");
    }
}

class Armor extends Items {
    
    public int weaponDamage = 0;
    public int armorRating = 50;
    
}
