public class ToolStore extends NormalLoc {

    ToolStore(Player player, String name) {
        super(player, "Mağaza");
    }

    @Override
    public boolean getLocation() {
        System.out.println("Para : " + player.getMoney());
        System.out.println("1. Silahlar");
        System.out.println("2. Zırhlar");
        System.out.println("3. Çıkış");

        String answer = scan.nextLine();
        int selLoc = 0;

        // Geçerli bir seçenek girene kadar tekrar sor
        while (!(answer.equals("1") || answer.equals("2") || answer.equals("3"))) {
            System.out.println("Lütfen geçerli bir seçenek girin (1-3):");
            answer = scan.nextLine();
        }

        selLoc = Integer.parseInt(answer);  // Doğruysa int'e çevir

        // Seçilen yere göre işlem yap
        switch (selLoc) {
            case 1: {
                int selItemID = weaponMenu();  // Silah menüsünü çağır
                buyWeapon(selItemID);
                break;
            }
            case 2: {
                int selItemID = armorMenu();  // Zırh menüsünü çağır
                buyArmor(selItemID);
                break;
            }
            case 3: {
                System.out.println("Mağazadan çıkılıyor...");
                break;
            }
        }
        return true;
    }

    public int armorMenu() {
        int selArmorID = 0;
        // Zırh seçim döngüsü
        while (true) {
            System.out.println("1. Hafif Zırh\t <Para : 15 - Engellenen Hasar : 1>");
            System.out.println("2. Orta Zırh\t <Para : 25 - Engellenen Hasar : 3>");
            System.out.println("3. Ağır Zırh\t <Para : 40 - Engellenen Hasar : 5>");
            System.out.println("4. Çıkış");
            System.out.print("Zırh Seçiniz : ");
            String answer = scan.nextLine();

            // Geçerli bir sayı girene kadar tekrar sor
            while (!(answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4"))) {
                System.out.println("Lütfen geçerli bir seçenek girin (1-4):");
                answer = scan.nextLine();
            }

            selArmorID = Integer.parseInt(answer);  // Doğruysa int'e çevir

            if (selArmorID == 4) {
                System.out.println("Zırh menüsünden çıkılıyor...");
                return -1;
            }
            break;  // Geçerli bir seçim yapıldığında döngüden çık
        }
        return selArmorID;
    }

    public void buyArmor(int selArmorID) {
        if (selArmorID == -1) {
            System.out.println("Satın alma işlemi iptal edildi.");
            return;
        }

        int armorPrice = 0;
        int armorBlock = 0;

        switch (selArmorID) {
            case 1:
                armorPrice = 15;
                armorBlock = 1;
                break;
            case 2:
                armorPrice = 25;
                armorBlock = 3;
                break;
            case 3:
                armorPrice = 40;
                armorBlock = 5;
                break;
        }

        if (player.getMoney() < armorPrice) {
            System.out.println("Para yetersiz! Mevcut para: " + player.getMoney());
        } else {
            int previousBlock = player.getBlock();
            System.out.println("Önceki engellenen hasar: " + previousBlock);

            int newBlock = previousBlock + armorBlock;

            player.setMoney(player.getMoney() - armorPrice);
            player.setBlock(newBlock);
            System.out.println("Zırh satın alındı! Kalan para: " + player.getMoney());
            System.out.println("Yeni engellenen hasar: " + newBlock);
        }
    }

    public int weaponMenu() {
        int selWeaponID = 0;
        while (true) {
            System.out.println("1. Tabanca\t <Para : 25 - Hasar : 2>");
            System.out.println("2. Kılıç\t <Para : 35 - Hasar : 3>");
            System.out.println("3. Tüfek\t <Para : 45 - Hasar : 7>");
            System.out.println("4. Çıkış");
            System.out.print("Silah Seçiniz : ");
            String input = scan.nextLine();

            // Geçerli bir sayı girene kadar tekrar sor
            while (!(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4"))) {
                System.out.println("Lütfen geçerli bir seçenek girin (1-4):");
                input = scan.nextLine();
            }
            selWeaponID = Integer.parseInt(input);  // Doğruysa int'e çevir


            if (selWeaponID == 4) {
                System.out.println("Silah menüsünden çıkılıyor...");
                return -1;
            }
            return selWeaponID;
        }

    }

    public void buyWeapon(int selWeaponID) {
        if (selWeaponID == -1) {
            System.out.println("Satın alma işlemi iptal edildi.");
            return;
        }

        int weaponPrice = 0;
        int weaponDamage = 0;

        switch (selWeaponID) {
            case 1:
                weaponPrice = 25;
                weaponDamage = 2;
                break;
            case 2:
                weaponPrice = 35;
                weaponDamage = 3;
                break;
            case 3:
                weaponPrice = 45;
                weaponDamage = 7;
                break;
        }

        if (player.getMoney() < weaponPrice) {
            System.out.println("Para yetersiz! Mevcut para: " + player.getMoney());
        } else {
            int previousDamage = player.getDamage();
            System.out.println("Önceki hasar: " + previousDamage);

            int newDamage = previousDamage + weaponDamage;

            player.setMoney(player.getMoney() - weaponPrice);
            player.setDamage(newDamage);
            System.out.println("Silah satın alındı! Kalan para: " + player.getMoney());
            System.out.println("Yeni hasar: " + newDamage);
        }
    }
}
