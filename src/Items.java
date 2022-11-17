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

    public int weaponDamage = 0;
    public int armorRating = 0;
    public String weaponType = "";

    public int getDamage(){
        return weaponDamage;
    }

    public int getArmorRating(){
        return armorRating;
    }
    
}

class Sword extends Items{

    public int weaponDamage = 100;
    public int armorRating = 0;
}

class HELLBRINGER extends Items{

    public int weaponDamage = 1000000000;
    public int armorRating = 1000000000;
}


class Armor extends Items{
    
    public int weaponDamage = 0;
    public int armorRating = 50;
    
}
