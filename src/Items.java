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
    public void setArmorRating(int rating){
        this.armorRating = rating;
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

// Base Gear
class Fist extends Items{
    public Fist(){
        this.setDamage(1);
        this.setItemCost(0);
        this.setWeaponType("Melee");
        this.setItemName("Fist");
    }
}
class Clothes extends Items {
    public Clothes(){
        this.setArmorRating(5);
        this.setItemName("Clothes");
    }
}
// Melee Weapons
class WoodenSword extends Items{

    public WoodenSword(){
        this.setDamage(10);
        this.setItemCost(25);
        this.setWeaponType("Melee");
        this.setItemName("Wooden Sword");
    }
}


class SteelSword extends Items{

    public SteelSword(){
        this.setDamage(25);
        this.setItemCost(100);
        this.setWeaponType("Melee");
        this.setItemName("Steel Sword");
    }
}

class TitaniumSword extends Items{
    
    public TitaniumSword(){
        this.setDamage(75);
        this.setItemCost(200);
        this.setWeaponType("Melee");
        this.setItemName("Titanium Sword");
    }
}

class TungstenSword extends Items{

    public TungstenSword(){
        this.setDamage(150);
        this.setItemCost(450);
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
        this.setItemCost(25);
        this.setWeaponType("Melee");
        this.setItemName("Knives");
    }
}

class Kyokestu extends Items{

    public Kyokestu(){
        this.setDamage(20);
        this.setItemCost(100);
        this.setWeaponType("Melee");
        this.setItemName("Kyokestu");
    }
}

class DualKatanas extends Items{

    public DualKatanas(){
        this.setDamage(77);
        this.setItemCost(200);
        this.setWeaponType("Melee");
        this.setItemName("Dual Katanas");
    }
}

class DragonsBlade extends Items{

    public DragonsBlade(){
        this.setDamage(150);
        this.setItemCost(500);
        this.setWeaponType("Melee");
        this.setItemName("Dragons Blade");
    }
}

// Archer Weapons
class WoodenBow extends Items{

    public WoodenBow(){
        this.setDamage(10);
        this.setItemCost(25);
        this.setWeaponType("Range");
        this.setItemName("Wooden Bow");
    }
}

class LongBow extends Items {

    public LongBow(){
        this.setDamage(25);
        this.setItemCost(100);
        this.setWeaponType("Range");
        this.setItemName("Long Bow");
    }
}

class JaguarStrike extends Items {
    
    public JaguarStrike(){
        this.setDamage(72);
        this.setItemCost(200);
        this.setWeaponType("Range");
        this.setItemName("The Jaguars Strike");
    }
}

class Yumi extends Items {

    public Yumi(){
        this.setDamage(180);
        this.setItemCost(600);
        this.setWeaponType("Range");
        this.setItemName("Yumi");
    }
}

// Mage and Priest Weapons
class WoodenStaff extends Items {

    public WoodenStaff(){
        this.setDamage(10);
        this.setItemCost(25);
        this.setWeaponType("Magic");
        this.setItemName("Wooden Staff");
    }
}

class SteelScepter extends Items {

    public SteelScepter(){
        this.setDamage(20);
        this.setItemCost(100);
        this.setWeaponType("Magic");
        this.setItemName("Steel Scepter");
    }
}

class GoldenScepter extends Items {

    public GoldenScepter(){
        this.setDamage(80);
        this.setItemCost(220);
        this.setWeaponType("Magic");
        this.setItemName("Golden Scepter");
    }
}

class BookofOmniscience extends Items {

    public BookofOmniscience(){
        this.setDamage(140);
        this.setItemCost(460);
        this.setWeaponType("Magic");
        this.setItemName("Book of Omniscience");
    }
}

// Armor
class LeatherArmor extends Items {
    public LeatherArmor(){
        this.setArmorRating(10);
        this.setItemCost(35);
        this.setItemName("Leather Armor");
    }
}

class IronArmor extends Items {
    public IronArmor(){
        this.setArmorRating(15);
        this.setItemCost(80);
        this.setItemName("Iron Armor");
    }
}

class DragonArmor extends Items {
    public DragonArmor(){
        this.setArmorRating(25);
        this.setItemCost(120);
        this.setItemName("Dragon Armor");
    }
}

class ZSTArmor extends Items {
    public ZSTArmor(){
        this.setArmorRating(35);
        this.setItemCost(250);
        this.setItemName("ZST Armor");
    }
}

class RastArmor extends Items {
    public RastArmor(){
        this.setArmorRating(50);
        this.setItemCost(400);
        this.setItemName("Rast Armor");
    }
}

class BakiArmor extends Items{
    public BakiArmor(){
        this.setArmorRating(100);
        this.setItemCost(600);
        this.setItemName("Baki Armor");
    }
}

class GodsTouch extends Items{
    public GodsTouch(){
        this.setArmorRating(999999);
        this.setItemName("God's Touch");
    }
}