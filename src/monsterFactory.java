package src;


public class monsterFactory {
	 
   public Monster spawnBandit(){
      return new Bandit();
   }
   public Monster spawnDiseasedCow(){
      return new DiseasedCow();
   }
   public Monster spawnDragon(){
      return new InfernalDragon();
   }
   public Monster spawnGiant(){
      return new Giant();
   }
   public Monster spawnSkeletonArcher(){
      return new SkeletonArcher();
   }
   public Monster spawnTroll(){
      return new Troll();
   }
   public Monster spawnVampire(){
      return new Vampire();
   }
   public Monster spawnWitch(){
      return new Witch();
   }
   public Monster spawnZombie(){
      return new Zombie();
   }
}