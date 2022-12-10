package src;
import java.util.*;

public class RogueCombat implements FightStrategy{

    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    String userChoice = "";

    @Override
    public void fight(Heroes hero, Monster monster){

        hero.ran = false;
        while((monster.getHealthPoints() > 0)){
            System.out.printf("%-40s %-10s\n", "\nHero", monster.getMonsterName());
            System.out.printf("%-40s %-10s\n", "--------------------", "--------------------");
            System.out.printf("%-40s %-10s\n", hero.getHealthPoints() + "/" + hero.getMaxHealthPoints() +  "HP", monster.getHealthPoints() + " HP");
            System.out.println("\n\nMake your move...\n1. Attack\n2. Run");
            userChoice = sc.nextLine();
            if(userChoice.equals("1")){

                // MELEE COMBAT SPECIFIC
                // x% chance we will crit
                if(rand.nextInt(100) < hero.getCritChance()){
                    // Special Attack
                    System.out.println("You have inflicted a critical hit to the enemy! You inflicted " + hero.attack() * hero.critMult + " damage!");
                    monster.damageMonster(hero.attack() * hero.critMult);
                    // Enemy Attack
                    System.out.println(monster.getMonsterName() + " has attacked you for " + monster.getDamage() + " HP!");
                    hero.damageHero(monster.getDamage());
                }
                else{
                    monster.damageMonster(hero.attack());
                    System.out.println("You attack the " + monster.getMonsterName() + " with " + hero.getWeapon().getItemName() + " for " + hero.attack() + " HP!");
                    if(monster.getHealthPoints() <= 0){
                        break;
                    }
                    else{
                        hero.damageHero(monster.getDamage());
                        System.out.println(monster.getMonsterName() + " has attacked you for " + monster.getDamage() + " HP!");
                        hero.checkIsDead();
                        if(hero.getIsDead()){
                            System.out.println("You have died!");
                            return;
                        }
                    }
                }
                
            }
            else if(userChoice.equals("2"))
            {
                hero.ran = true;
                return;
            }
        }
        hero.giveExp(monster.getExp());
        System.out.println("You have slain " + monster.getMonsterName() + "!");
        hero.getLocation().increaseMonstersDefeated();
        // Check for level up
        hero.levelUp();
    }
    
}
