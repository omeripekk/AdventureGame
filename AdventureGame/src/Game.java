import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);

    public void login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("MACERA OYUNUNA HOŞGELDİNİZ !");
        System.out.println("Oyuna başlamadan önce isminizi giriniz : ");
        String playerName = scan.nextLine();
        player = new Player("");
        player.selectCha();
        start();
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("================");
            System.out.println();
            System.out.println("1. Güvenli Ev --> Size ait güvenli bir mekan, düşman yok !");
            System.out.println("2. Mağara --> Karşınıza zombi çıkabilir !");
            System.out.println("3. Orman --> Karşınıza vampir çıkabilir !");
            System.out.println("4. Nehir --> Karşınıza ayı çıkabilir !");
            System.out.println("5. Mağaza --> Silah veya Zırh alabilirsiniz !");
            System.out.println("Düşmanları yenin, ödülleri kazanın ve Güvenli Eve dönün, ZAFER SİZİN! ");
            System.out.println("Gitmek istediğiniz yer : ");
            int selLoc = scan.nextInt();
            while (selLoc < 0 || selLoc > 5) {
                System.out.println("Lütfen geçerli bir yer seçiniz : ");
                selLoc = scan.nextInt();
            }

            switch (selLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;

                case 2:
                    location = new Cave(player);
                    break;

                case 3:
                    location = new Forest(player);
                    break;

                case 4:
                    location = new River(player);
                    break;

                case 5:
                    location = new ToolStore(player, "Mağaza");
                    break;

            }

            if (location.getClass().getName().equals("SafeHouse")) {
                if(player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
                    System.out.println("Tebrikler Oyunu Kazandınız !");
                    break;

                }
            }

                if (!location.getLocation()) {
                System.out.println("Oyun Bitti !");
                break;
            }
        }
    }
}
