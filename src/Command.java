package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;

public class Command {

    Scanner sc = new Scanner(System.in);

    public void adminLogin(Heroes admin){
        HELLBRINGER hellbringer = new HELLBRINGER();
        GodsTouch godsTouch = new GodsTouch();
        admin.addToHeroInventory(hellbringer);
        admin.addToHeroInventory(godsTouch);
        admin.equipWeapon(hellbringer);
        admin.equipArmor(godsTouch);
    }

    public void fightCombat(FightStrategy fStrategy, Heroes h, Monster m){
        fStrategy.fight(h, m);
    }

    public boolean login(String userInput) throws FileNotFoundException, IOException{

        try (BufferedReader br = new BufferedReader(new FileReader("src/userData/users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line. If we find that the user has a valid user/pass, grant access
                if(userInput.equals(line)){
                    System.out.println("Login Attempt Successful!\n");
                    return true;
                }
            }
        }
        System.out.println("Login Attempt Unsuccessful!\n");
        return false;
    }

    public boolean createAccount(String userName, String password) throws FileNotFoundException, IOException{
        
        // Does the account already exist?
        try (BufferedReader br = new BufferedReader(new FileReader("src/userData/users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line. If we find that the user has a valid user/pass, the user already has an account
                if(line.contains(userName)){
                    System.out.println("Oops! It looks like a user with this name already exist. Please choose a different username.");
                    return false;
                }
            }
        }

        // If the account doesn't exist, add it to the userList
        try {
            FileWriter fileWriter = new FileWriter("src/userData/users.txt", true);
            fileWriter.write("\n" + userName + password);
            fileWriter.close();
            System.out.print("Congratulations! Your account has been created!");
            return true;
        } catch (IOException e){
            System.out.println("Logger: An error has occured in writing your file");
        }
        
        return false;
    }
    
    public Heroes createCharacter(String characterTypeOption){
        switch(characterTypeOption){
            case "1":
                return new Knight();
            case "2":
                return new Archer();
            case "3":
                return new Rogue();
            case "4":
                return new Mage();
            case "5":
                return new Priest();
            default:
                return null;
        }
    }

    public void viewHeroInventory(Heroes advHero){
        System.out.printf("%-40s %-10s\n", "Hero: " + advHero.getHeroName(), "Inventory:");
        System.out.printf("%-40s %-10s\n", "------------------------------", "------------------------------");
        System.out.printf("%-40s %-10s\n", "Health: " + advHero.getHealthPoints() + "/" +advHero.getMaxHealthPoints(), "Gold: " + advHero.getGold() );
        System.out.printf("%-40s %-10s\n", "Melee Damage: " + advHero.meleeDmg, "Equiped Weapon: " + advHero.getWeapon().getItemName() + " - " + advHero.getWeapon().getDamage() + " dmg");
        System.out.printf("%-40s %-10s\n", "Range Damage: " + advHero.rangedDmg, "Equiped Armor: " + advHero.getArmor().getItemName() + " - " + advHero.getArmor().getArmorRating() + " armor rating");
        System.out.printf("%-40s %-10s\n", "Magic Damage: " + advHero.magicDmg, advHero.getHeroInventory());
        System.out.println("Crit Chance: " + advHero.critChance);
        System.out.println("Crit Multiplier: " + advHero.critMult);
        System.out.println("Loaction: " + advHero.getLocationName());
        System.out.println("Level: " + advHero.getHeroLevel());
        System.out.println("Exp: " + advHero.getExp() + "/" + advHero.getHeroLevel()*10);

    }
    
    public void healHero(Heroes advHero){
        System.out.println("Would you like to heal your hero for " + advHero.getHeroLevel()*15 + " gold?\n1) Yes\n2) No");
        String userChoice;
        userChoice = sc.nextLine();
        if(userChoice.equals("1")){
            boolean p = advHero.purchase(advHero.getHeroLevel()*15);
            if(p){
                advHero.healHero();
            }
        }
        else{
            // do nothing
        }
    }
    
    public void loadShopFresh(Shop s){
        // Add potions

        // Add Weapons
        // Melee
        WoodenSword wSword = new WoodenSword();
        s.addToInventory(wSword);
        SteelSword sSword = new SteelSword();
        s.addToInventory(sSword);
        TitaniumSword tSword = new TitaniumSword();
        s.addToInventory(tSword);
        TungstenSword tungSword = new TungstenSword();
        s.addToInventory(tungSword);
        Knives knives = new Knives();
        s.addToInventory(knives);
        Kyokestu kyokestu = new Kyokestu();
        s.addToInventory(kyokestu);
        DualKatanas dKatanas = new DualKatanas();
        s.addToInventory(dKatanas);
        DragonsBlade dBlade = new DragonsBlade();
        s.addToInventory(dBlade);
        // Range
        WoodenBow wBow = new WoodenBow();
        s.addToInventory(wBow);
        LongBow lBow = new LongBow();
        s.addToInventory(lBow);
        JaguarStrike jaguarStrike = new JaguarStrike();
        s.addToInventory(jaguarStrike);
        Yumi yumi = new Yumi();
        s.addToInventory(yumi);
        // Magic
        WoodenStaff wStaff = new WoodenStaff();
        s.addToInventory(wStaff);
        SteelScepter steelScepter = new SteelScepter();
        s.addToInventory(steelScepter);
        GoldenScepter goldenScepter = new GoldenScepter();
        s.addToInventory(goldenScepter);
        BookofOmniscience bO = new BookofOmniscience();
        s.addToInventory(bO);
        // Add Armor
        // Armor
        LeatherArmor lArmor = new LeatherArmor();
        s.addToInventory(lArmor);
        IronArmor iArmor = new IronArmor();
        s.addToInventory(iArmor);
        DragonArmor dArmor = new DragonArmor();
        s.addToInventory(dArmor);
        ZSTArmor zstArmor = new ZSTArmor();
        s.addToInventory(zstArmor);
        RastArmor rastArmor = new RastArmor();
        s.addToInventory(rastArmor);
    }

    public void enterShop(Heroes advHero, Shop shop){
        String userChoice;
        boolean stay = true;
        System.out.println("Welcome to " + shop.getStoreName());
        while(stay){
            System.out.println("\n1) View Store Inventory\n2) Purchase Items\n3) Exit Shop");
            userChoice = sc.nextLine();
            switch(userChoice){
                case "1":
                    // Print the store inventory
                    shop.getStoreInventory();
                    break;
                case "2":
                    System.out.println("What item would you like to purchase?");
                    userChoice = sc.nextLine();
                    // Create a new item to take from the shelf
                    Items bought = shop.getItemFromShelf(userChoice);
                    // If the item isn't found
                    if(bought == null){
                        System.out.println("Sorry that item is out of stock or does not exist.");
                        break;
                    }
                    else{
                        Boolean p = advHero.purchase(bought.getItemCost());
                        // If the adv has enough money
                        if(p){
                            // Remove item from store
                            shop.removeFromInventory(bought);
                            // Add to hero inventory
                            advHero.addToHeroInventory(bought);
                            System.out.println("Item Bought Successfully!");
                        }
                        //advHeroes.purchase(null)
                    }
                    break;
                case "3":
                    // Leave The Shop
                    System.out.println("Leaving...");
                    stay = false;
                    break;
                default:
                    // Invalid Input
                    System.out.println("Sorry that was an invalid option.");
                    break;
            }
        }
        return;

    }

    public Monster spawnMonster(Maps map){
        // Create a temp monster to return later
        Monster returnMonster = null;
        // Create a random number between 0 and 3
        Random rand = new Random();
        int randIndex = rand.nextInt(4);

        switch(map.getLocationName()){
            case "Fiji":
                // Create new creatures
                switch(randIndex){
                    // Spawn random creature
                    case 0:
                        Bandit b = new Bandit();
                        returnMonster = b;
                        break;
                    case 1:
                        DiseasedCow dc = new DiseasedCow();
                        returnMonster = dc;
                        break;
                    case 2:
                        Snake s = new Snake();
                        returnMonster = s;
                        break;
                    case 3:
                        EvilApprentice eA = new EvilApprentice();
                        returnMonster = eA;
                        break;
                    default:
                        break;
                }
                break;
            case "Rea Sea":
                // Create new creatures
                switch(randIndex){
                    // Spawn random creature
                    case 0:
                        SkeletonArcher sa = new SkeletonArcher();
                        returnMonster = sa;
                        break;
                    case 1:
                        Troll t = new Troll();
                        returnMonster = t;
                        break;
                    case 2:
                        Zombie z = new Zombie();
                        returnMonster = z;
                        break;
                    case 3:
                        Vampire v = new Vampire();
                        returnMonster = v;
                        break;
                    default:
                        break;
                }
                break;
            case "The Fire Link Shrine":
                // Create new creatures
                switch(randIndex){
                    // Spawn random creature
                    case 0:
                        InfernalDragon iDragon = new InfernalDragon();
                        returnMonster = iDragon;
                        break;
                    case 1:
                        Giant g = new Giant();
                        returnMonster = g;
                        break;
                    case 2:
                        Witch w = new Witch();
                        returnMonster = w;
                        break;
                    case 3:
                        MolotovMan mMan = new MolotovMan();
                        returnMonster = mMan;
                        break;
                    default:
                        break;
                }
                break;
            case "Indicapower":
                // Create new creatures
                switch(randIndex){
                    // Spawn random creature
                    case 0:
                        Parasite p = new Parasite();
                        returnMonster = p;
                        break;
                    case 1:
                        VenusMantrap vMantrap = new VenusMantrap();
                        returnMonster = vMantrap;
                        break;
                    case 2:
                        OldDrunkMan oldDrunkMan = new OldDrunkMan();
                        returnMonster = oldDrunkMan;
                        break;
                    case 3:
                        Regi regi = new Regi();
                        returnMonster = regi;
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }

        return returnMonster;
    }

    public Monster spawnBoss(Maps map) throws InterruptedException{
        // Create a temp monster to return later
        Monster returnMonster = null;
        switch(map.getLocationName()){
            case "Fiji":
                // Create new creatures
                BanditKing bK = new BanditKing();
                returnMonster = bK;
                System.out.println("Heavy footsteps approach...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("A large figure approaches... It looks like...");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("\nYou have encountered " + returnMonster.getMonsterName());
                break;
            case "Rea Sea":
                // Create new creatures
                Dracula d = new Dracula();
                returnMonster = d;
                System.out.println("A Dark mist surrounds you...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Red eyes appear in the mist...");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("\nYou have encountered " + returnMonster.getMonsterName());
                break;
            case "The Fire Link Shrine":
                // Create new creatures
                Rardinos r = new Rardinos();
                returnMonster = r;
                System.out.println("You begin to sweat... The temperature in the room is increasing...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("The sound of fire creeps up on you...");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("\nYou have encountered " + returnMonster.getMonsterName());
                break;
            case "Indicapower":
                Nokira nokira = new Nokira();
                returnMonster = nokira;
                System.out.println("It's quiet...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("The shadows grow");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("\nYou have encountered " + returnMonster.getMonsterName());
                break;
            case "Sativatoff":
                SwordsmanOog swordsmanOog = new SwordsmanOog();
                returnMonster = swordsmanOog;
                System.out.println("You hear nothing...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("The sound of an unsheathing sword passes your ears...");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("It has taken every ounce of your will power to get here");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Swordsman Oog: ADVENTURER! Your journey ends here!");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("\nYou have encountered " + returnMonster.getMonsterName());
                break;
            default:
                break;
        }
        return returnMonster;
        }

    public void fight(Heroes advHero, Monster currMonster){
        FightStrategy melee = new MeleeCombat();
        FightStrategy range = new RangeCombat();
        FightStrategy magic = new MagicCombat();
        Command c = new Command();

        switch(advHero.getHeroType()){
            case "Knight":
                // Melee Combat
                c.fightCombat(melee, advHero, currMonster);
                break;
            case "Rogue":
                // Rogue Combat
                // game.fightCombat(rogue, advHero, currMonster);
                break;
            case "Archer":
                // Range Combat
                c.fightCombat(range, advHero, currMonster);
                break;
            case "Mage":
                // Magic Combat
                c.fightCombat(magic, advHero, currMonster);
                break;
            case "Priest":
                // Priest Combat
                // game.fightCombat(priest, advHero, currMonster);
                break;
            default:
                System.out.println("Oops, there seems to be an error in the fight method!");
                break;
        }
    }
}
