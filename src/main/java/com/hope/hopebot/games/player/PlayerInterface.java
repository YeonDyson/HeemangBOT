package com.hope.hopebot.games.player;

public interface PlayerInterface {

    int getLevel();
    void setLevel(int amount);
    void addLevel(int amount);

    int getEXP();
    void setEXP(int amount);
    void addEXP(int amount);

    int getHP();
    void setMaxHP(int maxHP);
    void addHP(int HP);

    int getSTR();
    void setSTR(int amount);
    void addSTR(int amount);

    int getDEF();
    void setDEF(int amount);
    void addDEF(int amount);

    int getMoney();
    void addMoneyUp(int amount);
    void addMoneyDown(int amount);
    void setMoney(int amount);

    String getItem(int line);
    void setItem(int line, String itemID);
    void setItem(String itemID);

    String getWeapon();
    void setWeapon(String itemID);

    String getArmor();
    void setArmor(String itemID);

    String getTotem();
    void setTotem(String itemID);

    String getLocation();
    void setLocation(String location);
}
