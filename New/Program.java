public class Program {
    public static void main(String[] args) {
        // IParkinController
        IGarageController c = new GarageController();
        GarageUI gi = c.getUI();
        gi.menu();
    }
}