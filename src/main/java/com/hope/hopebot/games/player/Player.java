package com.hope.hopebot.games.player;

public class Player implements PlayerInterface {

    private final String playerUUID;

    public Player(String playerID){
        this.playerUUID = playerID;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public void setLevel(int amount) {

    }

    @Override
    public void addLevel(int amount) {

    }

    @Override
    public int getEXP() {

        return 0;
    }

    @Override
    public void setEXP(int amount) {

    }

    @Override
    public void addEXP(int amount) {

    }

    @Override
    public int getHP() {

        return 0;
    }

    @Override
    public void setMaxHP(int maxHP) {

    }

    @Override
    public void addHP(int HP) {

    }

    @Override
    public int getSTR() {

        return 0;
    }

    @Override
    public void setSTR(int amount) {

    }

    @Override
    public void addSTR(int amount) {

    }

    @Override
    public int getDEF() {

        return 0;
    }

    @Override
    public void setDEF(int amount) {

    }

    @Override
    public void addDEF(int amount) {

    }

    @Override
    public int getMoney() {

        return 0;
    }

    @Override
    public void addMoneyUp(int amount) {

    }

    @Override
    public void addMoneyDown(int amount) {

    }

    @Override
    public void setMoney(int amount) {

    }

    @Override
    public String getItem(int line) {
        return null;
    }

    @Override
    public void setItem(int line, String itemID) {

    }

    @Override
    public void setItem(String itemID) {

    }

    @Override
    public String getWeapon() {
        return null;
    }

    @Override
    public void setWeapon(String itemID) {

    }

    @Override
    public String getArmor() {
        return null;
    }

    @Override
    public void setArmor(String itemID) {

    }

    @Override
    public String getTotem() {
        return null;
    }

    @Override
    public void setTotem(String itemID) {

    }

    @Override
    public String getLocation() {
        return null;
    }

    @Override
    public void setLocation(String location) {

    }
}
