package src.monsters;

import src.creatureInterface;

public class Wolf implements creatureInterface {
   
   public Integer damage = 8;
   public String creatureName = "Wolf";
   public Integer exp = 4;
   public Integer healthPoints = 20;
   public String monsterType = "Melee";

   @Override
   public void creature() {
      System.out.println("Creating Wolf");
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