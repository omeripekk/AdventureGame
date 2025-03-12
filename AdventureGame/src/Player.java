import java.util.Scanner;

public class Player {
    private int damage, healthy, money, block;
    private String name, cName;
    private Inventory inv;
    private int health;
    private int originalHealth;
    Scanner scann = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();

    }

    public void selectCha() {
        switch (chaMenu()) {
            case 1:
                initPlayer("Samuray", 5, 22, 15);
                break;
            case 2:
                initPlayer("Okçu", 7,19, 20);
                break;
            case 3:
                initPlayer("Şovalye", 8, 20, 10);
                break;
            default:
                initPlayer("Samuray", 5, 22, 15);
                break;
        }
        System.out.println("Karakter : " + getcName() + "     Hasar : " + getDamage() + "   Sağlık : " + getHealthy() + "   Para : " + getMoney () + "   Engellenen Hasar : " + getBlock());
    }

    public int chaMenu() {
        System.out.println("Lütfen bir karakter seçiniz : ");
        System.out.println("1- Samuray \t Hasar : 5 \t Sağlık : 22 \t Para : 15");
        System.out.println("2- Okçu \t Hasar : 7 \t Sağlık : 19 \t Para : 20");
        System.out.println("3- Şovalye \t Hasar : 8 \t Sağlık : 20 \t Para : 10");
        System.out.print("Karakter Seçiminiz : ");
        int chaID = scann.nextInt();

        while (chaID < 1 || chaID > 3) {
            System.out.print("Lütfen geçerli bir karakter seçiniz : ");
            chaID = scann.nextInt();
        }

        return chaID;
    }

    public int getTotalDamage() {
        return this.getDamage() + this.getInv().getDamage();
    }

    public void initPlayer(String cName, int dmg, int hlty, int mny) {
        setcName(cName);
        setDamage(dmg);
        setHealthy(hlty);
        setMoney(mny);
        setBlock(0);
    }

    public Inventory getInv() {

        return inv;
    }

    public void setInv(Inventory inv) {

        this.inv = inv;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHealthy() {
        return healthy;
    }


    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }


    public int getHealth() {
        return health;
    }


    public void setHealth(int health) {
        this.health = health;
    }


    public int getOriginalHealth() {
        return originalHealth;
    }
    public void setOriginalHealth(int originalHealth){
        this.originalHealth = originalHealth;
    }
}
