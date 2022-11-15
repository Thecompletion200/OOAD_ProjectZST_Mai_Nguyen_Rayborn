package src.monsters;

import src.creatureInterface;

public class Zombie implements creatureInterface {
   
   public Integer damage = 10;
   public String creatureName = "Zombie";
   public Integer exp = 5;
   public Integer healthPoints = 25;
   public String monsterType = "Melee";

   @Override
   public void creature() {
      System.out.println("Creating Zombie");
   }

   @Override
   public void callout() {
      System.out.println("You've encountered a " + creatureName);
   }

   @Override
   public void die() {
      System.out.println(creatureName + "has fallen!");
      
   }

   @Override
   public Integer attack() {
      return damage;
   }
   
}