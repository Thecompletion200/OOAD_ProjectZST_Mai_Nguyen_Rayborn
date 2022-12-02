package src;

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

public class Items{

    private int weaponDamage = 0;
    private int armorRating = 0;
    private String weaponType = "notAWeapon";
    private String itemName = "";
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
    public void setPotionStrength(Integer str){
        this.potionStrength = str;
    }
    public Integer getPotionStrength(){
        return this.potionStrength;
    }
    
}

class WoodenSword extends Items{

    public WoodenSword(){
        this.setDamage(10);
        this.setWeaponType("Melee");
        this.setItemName("Wooden Sword");
    }
}

class HELLBRINGER extends Items{

    public int weaponDamage = 1000000000;
    public int armorRating = 1000000000;
}


class Armor extends Items{
    
    public int weaponDamage = 0;
    public int armorRating = 50;
    
}
