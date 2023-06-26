import java.util.Scanner;

public class GarageUI {
    private Scanner sc;
    private IGarageController garageController;

    public GarageUI(IGarageController gc) {
        sc = new Scanner(System.in);
        garageController = gc;
    }

    public void checkSpace() {
        if (garageController.isFull()) {
            System.out.println("Garage is full");
        } else {
            System.out.println("Garage is not full");
        }
    }

    public void showGarageFull() {
        System.out.println("Garage is full");
    }

    public void parkin() {
        garageController.getParkinController().parkin(garageController);
    }

    public boolean showVehicleForm() {
        String name, id;
        int modelYear;
        float length, width;
        System.out.println("Enter the vehicle's model name: ");
        name = sc.nextLine();
        System.out.println("Enter the vehicle's ID: ");
        id = sc.nextLine();
        System.out.println("Enter the vehicle's model year: ");
        modelYear = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the vehicle's length: ");
        length = sc.nextFloat();
        sc.nextLine();
        System.out.println("Enter the vehicle's width: ");
        width = sc.nextFloat();
        sc.nextLine();
        return garageController.addVehicle(name, id, modelYear, length, width);
    }

    public void ShowInvalidInput() {
        System.out.println("Input is invalid");
    }

    public void parkout() {
        System.out.println("Enter the vehicle's ID: ");
        String id;
        id = sc.nextLine();
        garageController.getParkoutController().parkout(garageController,id);
    }

    public void showSlot(int num) {
        System.out.println("Slot " + num + " is your Assigned Slot Number");
    }

    public void ownerForm() {
        String pw;
        System.out.println("Enter Owner Password: ");
        pw = sc.nextLine();
        garageController.getAdminController().authorize(pw, garageController);
    }

    public void garageSetupForm() {
        if (garageController.getAdminController().isAuthorized()) {
            System.out.println("Enter the number of slots: ");
            int nslots;
            nslots = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the configuration method: ");
            System.out.println("0) First come first served");
            System.out.println("1) Best-fit");
            int ct = sc.nextInt();
            sc.nextLine();
            Slot slots[] = new Slot[nslots];
            System.out.println("Garage Slots size setup:");
            for (int i = 0; i < nslots; i++) {
                System.out.println("Enter the size of slot " + (i + 1));
                float l = sc.nextFloat();
                float w = sc.nextFloat();
                slots[i] = new Slot();
                slots[i].setDimention(l, w);
            }
            garageController.getGarage().setUpGarage(nslots, ct, slots);
            sc.nextLine();
        } else {
            unauthorized();
        }
    }

    public void menu() {
        int choice;
        do {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("1) Garage setup");
            System.out.println("2) Park in");
            System.out.println("3) Park out");
            System.out.println("4) Owner Form");
            System.out.println("5) log out");
            System.out.println("6) total registered vehicles");
            System.out.println("7) total revenue");
            System.out.println("8) show Slots");
            System.out.println("9) Exit");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    garageSetupForm();
                    break;
                case 2:
                    parkin();
                    break;
                case 3:
                    parkout();
                    break;
                case 4:
                    ownerForm();
                    break;
                case 5:
                    logout();
                    break;
                case 6:
                    garageController.getAdminController().calcTotalRegistered(garageController);
                    break;
                case 7:
                    garageController.getAdminController().calcTotalRevenue(garageController);
                    break;
                case 8:
                    garageController.ShowSlot();
                    break;
                case 9:
                    garageController.getAdminController().shutdown(garageController);
                    break;

                default:
                    choice = -1;
                    break;
            }
        } while (choice != -1);
        sc.close();
    }

    public void showFee(float fee) {
        System.out.println("Fee: " + fee);
    }

    public void logout() {
        garageController.getAdminController().adminLogout();
        System.out.println("Logged out");
    }

    public void wrongPassword() {
        System.out.println("Wrong Password");
    }

    public void correctPassword() {
        System.out.println("Correct Password.. Logged In");
    }

    public void unauthorized() {
        System.out.println("you are not authorized todo this action, please login first");
    }

    public void showTotalRevenue(int rev) {
        System.out.println("Total Revenue: " + rev);
    }
    public void showTotalRegistered(int n){
        System.out.println("Numer of Registered Cars : " + n);
    }
    public void showSlotsInfo(String report){
        System.out.println(report);
    }
    public void closeInterface(){
        sc.close();
    }

}
