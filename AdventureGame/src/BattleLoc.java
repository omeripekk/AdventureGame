import java.util.Scanner;

public abstract class BattleLoc extends Location {
    protected Obstacle obstacle;
    protected String award;

    BattleLoc(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.obstacle = obstacle;
        this.name = name;
        this.award = award;
    }

    public boolean getLocation() {
        Scanner scan = new Scanner(System.in);
        int obsCount = obstacle.count();
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikkatli ol! Burada " + obsCount + " tane " + obstacle.getName() + " yaşıyor!");
        System.out.print("<S>avaş veya <K>aç :");
        String selCase = scan.nextLine();
        selCase = selCase.toUpperCase();

        if (selCase.equals("S")) {
            if (combat(obsCount)) {
                System.out.println(this.getName() + " bölgesindeki tüm düşmanları temizlediniz !");
                if (this.award.equals("Food") && !player.getInv().isFood()) {
                    System.out.println(this.award + " Kazandınız!");
                    player.getInv().setFood(true);
                } else if (this.award.equals("Water") && !player.getInv().isWater()) {
                    System.out.println(this.award + " Kazandınız!");
                    player.getInv().setWater(true);
                } else if (this.award.equals("Firewood") && !player.getInv().isFirewood()) {
                    System.out.println(this.award + " Kazandınız!");
                    player.getInv().setFirewood(true);
                }
                return true;
            }else {

            }
            if(player.getHealthy() <= 0) {
                System.out.println("Öldünüz !");
                return false;
            }

        }
        return true;
    }
    public boolean combat(int obsCount) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < obsCount; i++) {
            int defObsHealth = obstacle.getHealth();
            playerStats();
            enemyStats();
            while (player.getHealthy() > 0 && obstacle.getHealth() > 0) {
                System.out.print("<V>ur veya <K>aç :");
                String selCase = scan.next();
                selCase = selCase.toUpperCase();
                if (selCase.equals("V")) {
                    System.out.println("Siz vurdunuz !");
                    obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                    afterHit();
                    if (obstacle.getHealth() > 0) {
                        System.out.println("Canavar size vurdu !");
                        int damageTaken = Math.max(0, obstacle.getDamage() - player.getBlock());
                        player.setHealthy(Math.max(0, player.getHealthy() - damageTaken));
                        System.out.println("Canınız: " + player.getHealthy());
                        afterHit();
                    }
                }else {
                    return false;
                }
            }

            if (obstacle.getHealth() < player.getHealthy()) {
                System.out.println("Düşmanı yendiniz !");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Güncel Paranız :" + player.getMoney());
                obstacle.setHealth(defObsHealth); 
            } else {
                return false;
            }
            System.out.println("--------------------");
        }
        return true;
    }



    public void playerStats() {
        System.out.println("Oyuncu Değerleri\n-------");
        System.out.println("Can: " + player.getHealthy());
        System.out.println("Hasar: " + player.getDamage());
        System.out.println("Para: " + player.getMoney());
        if (player.getInv().getDamage() > 0) {
            System.out.println("Silah: " + player.getInv().getwName());
        }
        if (player.getInv().getArmor() > 0) {
            System.out.println("Zırh: " + player.getInv().getaName());
        }
    }


    public void enemyStats() {
        System.out.println("\n" + obstacle.getName() + " Değerleri\n----------");
        System.out.println("Can: " + obstacle.getHealth());
        System.out.println("Hasar: " + obstacle.getDamage());
        System.out.println("Ödül: " + obstacle.getAward());
    }

    public void afterHit() {
        System.out.println("Oyuncu Canı:" + player.getHealthy());
        System.out.println(obstacle.getName() + " Canı:" + obstacle.getHealth());
        System.out.println();
    }
}
