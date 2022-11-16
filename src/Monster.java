package src;

public class Monster {
    // Monster Variables
    private String monsterName = null;
    private Integer damage = 0;
    private Integer exp = 0;
    private Integer healthPoints = 0;
    private String monsterType = null;
    
    //Monster Getters/Setters
    public String getMonsterName() {
        return monsterName;
    }
    public Integer getDamage(){
        return damage;
    }
    public Integer getExp(){
        return exp;
    }
    public Integer getHealthPoints(){
        return healthPoints;
    }
    public String getMonsterType(){
        return monsterType;
      }
    public void damageMonster(Integer damageTaken){
      this.healthPoints = this.healthPoints - damageTaken;
    }

    public void die() {
        System.out.println(monsterName + "has fallen!");
    }
    public void encounter(){
    System.out.println("You've encountered a " + monsterName);
    }
}

// Level 1 Monsters
class Bandit extends Monster {
    private Integer damage = 5;
    private String monsterName = "Bandit";
    private Integer exp = 5;
    private Integer healthPoints = 30;
    private String monsterType = "Range";
}

class DiseasedCow extends Monster {
    private Integer damage = 5;
    private String monsterName = "Diseased Cow";
    private Integer exp = 2;
    private Integer healthPoints = 15;
    private String monsterType = "Melee";
}

class Snake extends Monster {
    private Integer damage = 5;
    private String monsterName = "Snake";
    private Integer exp = 2;
    private Integer healthPoints = 15;
    private String monsterType = "Melee";
}

class Apprentice extends Monster {
    private Integer damage = 5;
    private String monsterName = "Apprentice";
    private Integer exp = 2;
    private Integer healthPoints = 15;
    private String monsterType = "Magic";
}

// Level 1 Boss
class BanditKing extends Monster {
    private Integer damage = 12;
    private String monsterName = "Bandit King";
    private Integer exp = 15;
    private Integer healthPoints = 40;
    private String monsterType = "Range";
}

// Level 2 Monsters
class SkeletonArcher extends Monster {
    private Integer damage = 10;
    private String monsterName = "Skeleton Archer";
    private Integer exp = 5;
    private Integer healthPoints = 25;
    private String monsterType = "Range";
}

class Troll extends Monster {
    private Integer damage = 10;
    private String monsterName = "Troll";
    private Integer exp = 5;
    private Integer healthPoints = 25;
    private String monsterType = "Melee";
}

class Zombie extends Monster {
    private Integer damage = 10;
    private String monsterName = "Zombie";
    private Integer exp = 5;
    private Integer healthPoints = 25;
    private String monsterType = "Melee";
}

class Vampire extends Monster {
    private Integer damage = 10;
    private String monsterName = "Vampire";
    private Integer exp = 5;
    private Integer healthPoints = 25;
    private String monsterType = "Magic";
}
// Second Boss
class Dracula extends Monster {
    private Integer damage = 15;
    private String monsterName = "Dracula";
    private Integer exp = 5;
    private Integer healthPoints = 25;
    private String monsterType = "Magic";
}

// Level 3 Monsters
class InfernalDragon extends Monster {
    private Integer damage = 10;
    private String monsterName = "Infernal Dragon";
    private Integer exp = 5;
    private Integer healthPoints = 25;
    private String monsterType = "Magic";
}

class Giant extends Monster {
    private Integer damage = 100;
    private String monsterName = "Giant";
    private Integer exp = 5;
    private Integer healthPoints = 250;
    private String monsterType = "Melee";
}

class Witch extends Monster {
    private Integer damage = 10;
    private String monsterName = "Witch";
    private Integer exp = 5;
    private Integer healthPoints = 25;
    private String monsterType = "Magic";
}

class MolotovMan extends Monster {
    private Integer damage = 10;
    private String monsterName = "Molotov Man";
    private Integer exp = 5;
    private Integer healthPoints = 25;
    private String monsterType = "Range";
}

// Third Boss
class Rardinos extends Monster {
    private Integer damage = 10;
    private String monsterName = "Rardinos, Lord of Fire";
    private Integer exp = 5;
    private Integer healthPoints = 25;
    private String monsterType = "Magic";
}

// Level 4 Monsters
class Parasite extends Monster {
    private Integer damage = 10;
    private String monsterName = "Parasite";
    private Integer exp = 5;
    private Integer healthPoints = 25;
    private String monsterType = "Melee";
}

class VenusMantrap extends Monster {
    private Integer damage = 10;
    private String monsterName = "Venus Mantrap";
    private Integer exp = 5;
    private Integer healthPoints = 25;
    private String monsterType = "Magic";
}

class OldDrunkMan extends Monster {
    private Integer damage = 10;
    private String monsterName = "Old Drunk Man";
    private Integer exp = 5;
    private Integer healthPoints = 25;
    private String monsterType = "Magic";
}

class Regi extends Monster {
    private Integer damage = 10;
    private String monsterName = "Regi";
    private Integer exp = 5;
    private Integer healthPoints = 25;
    private String monsterType = "Melee";
}

// Fourth Boss
class Nokira extends Monster {
    private Integer damage = 10;
    private String monsterName = "Nokira";
    private Integer exp = 5;
    private Integer healthPoints = 25;
    private String monsterType = "Magic";
}

// Final Boss
class SwordsmanOog extends Monster {
    private Integer damage = 10;
    private String monsterName = "Swordman Oog";
    private Integer exp = 5;
    private Integer healthPoints = 25;
    private String monsterType = "Melee";
}
