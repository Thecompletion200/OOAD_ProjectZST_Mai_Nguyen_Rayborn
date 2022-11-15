package src;

public class Heroes{
    public int healthPoint = 150;
    public int experiencePoint = 0;
    public int level = 1;
    public int gold = 50;

    public int meleeDmg = 10;
    public int rangedDmg = 10;
    public int magicDmg = 10;
    public int critDmg = 10;
    public String heroType = "Melee";

    public String currLocation;


    public void move(String mapToMove){
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
    public String getHeroType(){
        return heroType;
    }
    public void levelUp(){
        if(experiencePoint == (level * 10)){
            meleeDmg = meleeDmg + 10;
        }
    }
}

class Knight extends Heroes{
    
}

class Archer extends Heroes{

    int healthPoint = 100;
    public String heroType = "Range";
    
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
    // public String heroType = "Melee";

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
    public String heroType = "Magic";

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
    public String heroType = "Magic";

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