public class SafeHouse extends NormalLoc {
    SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean getLocation() {
        System.out.println("Şu an 'Güvenli Ev' adlı yerdesiniz. Burada güvendesiniz!");
        System.out.println("Mevcut Canınız: " + player.getHealthy());
        return true;
    }
}