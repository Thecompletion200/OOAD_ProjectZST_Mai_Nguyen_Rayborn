package src;

public class Heroes extends Character{
    int healthPoint = 150;
    int experiencePoint = 0;
    int level = 1;
    int gold = 50;

    int meleeDmg = 10;
    int rangedDmg = 10;
    int magicDmg = 10;
    int critDmg = 10;

    void move()
    void purchase(Integer cost){
        gold = gold - cost;
    }
    void mine()
    void loot()
    void craft()
    void levelUp(){
        if(experiencePoint == level * 10){
            meleeDmg = meleeDmg + 10;
        }
    }
}

class Knight extends Heroes{
    
}

class Archer extends Heroes{
    @Override
    int healthPoint = 100;
    
    @Override
    void levelUp(){
        expriencePoint = experiencePoint + 1;
        if(experiencePoint == 10){
            rangedDmg = rangedDmg + 15;
        }
    }
}

class Rogue extends Heroes{
    @Override
    int healthPoint = 120;

    @Override
    void levelUp(){
        expriencePoint = experiencePoint + 1;
        if(experiencePoint == 10){
            critDmg = critDmg + 20;
        }
    }
}

class Mage extends Heroes{
    @Override
    int healthPoint = 80;

    @Override
    void levelUp(){
        expriencePoint = experiencePoint + 1;
        if(experiencePoint == 10){
            magicDmg = magicDmg + 25;
        }
    }
}

class Priest extends Heroes{
    @Override
    int healthPoint = 80;

    @Override
    void levelUp(){
        expriencePoint = experiencePoint + 1;
        if(experiencePoint == 10){
            magicDmg = magicDmg + 25;
        }
    }
}