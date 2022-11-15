package src.monsters;

import src.Monster;

public class DiseasedCow implements Monster {
   
   public Integer damage = 5;
   public String creatureName = "DiseasedCow";
   public Integer exp = 2;
   public Integer healthPoints = 15;
   public String monsterType = "Melee";


   @Override
   public void creature() {
      System.out.println("Creating DiseasedCow");
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