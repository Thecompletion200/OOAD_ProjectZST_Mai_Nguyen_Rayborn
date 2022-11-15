package src.monsters;

import src.Monster;

// This is a monster interface
public class Bandit implements Monster {
   
   public Integer damage = 10;
   public String creatureName = "Bandit";
   public Integer exp = 5;
   public Integer healthPoints = 30;
   public String monsterType = "Melee";

   @Override
   public void creature() {
      System.out.println("Creating Bandit");
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