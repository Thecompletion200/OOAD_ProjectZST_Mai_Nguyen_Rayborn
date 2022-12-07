package src;

public class Monster {
    // Monster Variables
    private String monsterName = null;
    private Integer damage = 0;
    private Integer exp = 0;
    private float healthPoints = 0;
    private String monsterType = null;
    private Boolean isBoss = false;
    //option to fight bosses after 10 creatures in the map

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
    public float getHealthPoints(){
        return healthPoints;
    }
    public String getMonsterType(){
        return monsterType;
      }
    public void damageMonster(float damageTaken){
      this.healthPoints = this.healthPoints - damageTaken;
    }
    public void setMonsterName(String newName)
    {
        this.monsterName = newName;
    }
    public void setDmg(int dmg)
    {
        this.damage = dmg;
    }
    public void setExp(int experience)
    {
        this.exp = experience;
    }
    public void setHealthPoint(float hp)
    {
        this.healthPoints = hp;
    }
    public void setMonsterType(String type)
    {
        this.monsterType = type;
    }
    public void setIsBoss(){
        this.isBoss = true;
    }
    public Boolean getIsBoss(){
        return isBoss;
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
    
    public Bandit() {
        this.setMonsterName("Bandit");
        this.setDmg(5);
        this.setExp(5);
        this.setHealthPoint(12);
        this.setMonsterType("Melee");
    }
}

class DiseasedCow extends Monster {
    
    public DiseasedCow() {
        this.setMonsterName("Diseased Cow");
        this.setDmg(5);
        this.setExp(5);
        this.setHealthPoint(12);
        this.setMonsterType("Melee");
    }
}

class Snake extends Monster {
    
    public Snake() {
        this.setMonsterName("Snake");
        this.setDmg(5);
        this.setExp(5);
        this.setHealthPoint(12);
        this.setMonsterType("Range");
    };
}

class EvilApprentice extends Monster {

    public EvilApprentice() {
        this.setMonsterName("Evil Apprentice");
        this.setDmg(5);
        this.setExp(5);
        this.setHealthPoint(12);
        this.setMonsterType("Magic");
    }
}

// Level 1 Boss
class BanditKing extends Monster {

    public BanditKing() {
        this.setMonsterName("Bandit King");
        this.setDmg(12);
        this.setExp(15);
        this.setHealthPoint(40);
        this.setMonsterType("Range");
        this.setIsBoss();
    }
}

// Level 2 Monsters
class SkeletonArcher extends Monster {

    public SkeletonArcher() {
        this.setMonsterName("Skeleton Archer");
        this.setDmg(10);
        this.setExp(5);
        this.setHealthPoint(25);
        this.setMonsterType("Range");
    }
}

class Troll extends Monster {

    public Troll() {
        this.setMonsterName("Troll");
        this.setDmg(10);
        this.setExp(5);
        this.setHealthPoint(25);
        this.setMonsterType("Melee");
    }
}

class Zombie extends Monster {

    public Zombie() {
        this.setMonsterName("Zombie");
        this.setDmg(10);
        this.setExp(5);
        this.setHealthPoint(25);
        this.setMonsterType("Melee");
    }
}

class Vampire extends Monster {
    public Vampire() {
        this.setMonsterName("Vampire");
        this.setDmg(10);
        this.setExp(5);
        this.setHealthPoint(25);
        this.setMonsterType("Magic");
    }
}
// Second Boss
class Dracula extends Monster {
    public Dracula() {
        this.setMonsterName("Dracula");
        this.setDmg(15);
        this.setExp(5);
        this.setHealthPoint(25);
        this.setMonsterType("Magic");
        this.setIsBoss();
    }
}

// Level 3 Monsters
class InfernalDragon extends Monster {
    public InfernalDragon() {
        this.setMonsterName("Infernal Dragon");
        this.setDmg(10);
        this.setExp(5);
        this.setHealthPoint(25);
        this.setMonsterType("Magic");
    }
}

class Giant extends Monster {
    public Giant() {
        this.setMonsterName("Giant");
        this.setDmg(100);
        this.setExp(5);
        this.setHealthPoint(250);
        this.setMonsterType("Melee");
    }
}

class Witch extends Monster {
    public Witch() {
        this.setMonsterName("Witch");
        this.setDmg(10);
        this.setExp(5);
        this.setHealthPoint(25);
        this.setMonsterType("Magic");
    }
}

class MolotovMan extends Monster {
    public MolotovMan() {
        this.setMonsterName("MolotovMan");
        this.setDmg(10);
        this.setExp(5);
        this.setHealthPoint(25);
        this.setMonsterType("Range");
    }
}

// Third Boss
class Rardinos extends Monster {
    public Rardinos() {
        this.setMonsterName("Rardinos, Lord of Fire");
        this.setDmg(10);
        this.setExp(5);
        this.setHealthPoint(25);
        this.setMonsterType("Magic");
        this.setIsBoss();
    }
}

// Level 4 Monsters
class Parasite extends Monster {
    public Parasite() {
        this.setMonsterName("Parasite");
        this.setDmg(10);
        this.setExp(5);
        this.setHealthPoint(25);
        this.setMonsterType("Melee");
    }
}

class VenusMantrap extends Monster {
    public VenusMantrap() {
        this.setMonsterName("Venus Mantrap");
        this.setDmg(10);
        this.setExp(5);
        this.setHealthPoint(25);
        this.setMonsterType("Magic");
    }
}

class OldDrunkMan extends Monster {
    
    public OldDrunkMan() {
        this.setMonsterName("Old Drunk Man");
        this.setDmg(10);
        this.setExp(5);
        this.setHealthPoint(25);
        this.setMonsterType("Magic");
    }
}

class Regi extends Monster {
    public Regi() {
        this.setMonsterName("Regi");
        this.setDmg(10);
        this.setExp(5);
        this.setHealthPoint(25);
        this.setMonsterType("Range");
    }
}

// Fourth Boss
class Nokira extends Monster {

    public Nokira() {
        this.setMonsterName("Nokira");
        this.setDmg(10);
        this.setExp(5);
        this.setHealthPoint(25);
        this.setMonsterType("Range");
        this.setIsBoss();
    }
}

// Final Boss
class SwordsmanOog extends Monster {

    public SwordsmanOog() {
        this.setMonsterName("Swordsman Oog");
        this.setDmg(10);
        this.setExp(5);
        this.setHealthPoint(25);
        this.setMonsterType("Melee");
        this.setIsBoss();
    }
}
