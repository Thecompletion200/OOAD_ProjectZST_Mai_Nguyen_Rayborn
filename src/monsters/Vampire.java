package src.monsters;

import src.Monster;

public class Vampire implements Monster {
   
   public Integer damage = 10;
   public String creatureName = "Vampire";
   public Integer exp = 5;
   public Integer healthPoints = 25;
   public String monsterType = "Magic";

   @Override
   public void creature() {
      System.out.println("Creating Vampire");
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