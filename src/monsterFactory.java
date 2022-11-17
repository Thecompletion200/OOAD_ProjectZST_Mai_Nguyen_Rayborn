package src;


public class monsterFactory {

	// Level 1 Monsters 
   public Monster spawnBandit(){
      return new Bandit();
   }
   public Monster spawnDiseasedCow(){
      return new DiseasedCow();
   }
   public Monster spawnSnake(){
      return new Snake();
   }
   public Monster spawnEvilApprentice(){
      return new EvilApprentice();
   }
   // Level 1 Boss
   public Monster spawnBanditKing(){
      return new BanditKing();
   }

   // Level 2 Monsters
   public Monster spawnSkeletonArcher(){
      return new SkeletonArcher();
   }
   public Monster spawnTroll(){
      return new Troll();
   }
   public Monster spawnZombie(){
      return new Zombie();
   }
   public Monster spawnVampire(){
      return new Vampire();
   }
   // Level 2 Boss
   public Monster spawnDracula(){
      return new Dracula();
   }

   // Level 3 Monsters
   public Monster spawnInfernalDragon(){
      return new InfernalDragon();
   }
   public Monster spawnGiant(){
      return new Giant();
   }
   public Monster spawnWitch(){
      return new Witch();
   }
   public Monster spawnMolotovMan(){
      return new MolotovMan();
   }
   // Level 3 Boss
   public Monster spawnRardinos(){
      return new Rardinos();
   }

   // Level 4 Monsters
   public Monster spawnParasite(){
      return new Parasite();
   }
   public Monster spawnVenusManTrap(){
      return new VenusMantrap();
   }
   public Monster spawnOldDrunkMan(){
      return new OldDrunkMan();
   }
   public Monster spawnRegi(){
      return new Regi();
   }
   // Level 4 Boss
   public Monster spawnNokira(){
      return new Nokira();
   }

   // Final Boss
   public Monster spawnOog(){
      return new SwordsmanOog();
   }
}