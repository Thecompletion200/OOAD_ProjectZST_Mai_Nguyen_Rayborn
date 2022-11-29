package src;

import java.io.Serializable;

public class Maps implements Serializable{
    public boolean hasHero;
    public Monster currMonster;
    public boolean hasShop;
    public void fight(FightStrategy fightMethod){
 
    }
}

// Town
class Elden extends Maps {
    public boolean hasShop = true;
    // Heals hero when entering map
    public void healHero(Heroes currHero){
        currHero.healHero();
    }
}

// First Map
class Fiji extends Maps {
    public boolean hasShop = false;
}

// Second Map
class RedSea extends Maps {
    public boolean hasShop = false;
}

// Third map
class FireLinkShrine extends Maps {
    public boolean hasShop = false;
}

// Fourth Map
class Indicapower extends Maps {
    public boolean hasShop = false;
}


// Final Map
class Sativatoff extends Maps {
    public boolean hasShop = false;
}
