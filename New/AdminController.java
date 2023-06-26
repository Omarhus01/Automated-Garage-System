public class AdminController implements IAdminController{
    private String adminPassword = "adminadmin";
    private boolean adminMode = false;

    public void shutdown(IGarageController garageController) {
        if (adminMode) {
            garageController.getUI().closeInterface();
            System.exit(0);
        } else
            garageController.getUI().unauthorized();
    }

    public Boolean setupGarage(int nSlot, int configType, Slot[] s, IGarageController garageController) {
        if (adminMode) {
            garageController.getGarage().setUpGarage(nSlot, configType, s);
            return true;
        } else {
            garageController.getUI().unauthorized();
            return false;
        }
    }

    public void calcTotalRevenue(IGarageController garageController) {
        if (adminMode)
            garageController.getUI().showTotalRevenue(garageController.getGarage().getTotalRevenue());
        else
            garageController.getUI().unauthorized();
    }

    public void calcTotalRegistered(IGarageController garageController) {
        if (adminMode)
            garageController.getUI().showTotalRegistered(garageController.getGarage().getTotalVehicles());
        else
            garageController.getUI().unauthorized();
    }

    public boolean isAuthorized() {
        return adminMode;
    }

    public void adminLogout() {
        adminMode = false;
    }

    public boolean authorize(String pw, IGarageController garageController) {
        if (pw.equals(adminPassword)) {
            adminMode = true;
            garageController.getUI().correctPassword();
            return true;
        } else {
            garageController.getUI().wrongPassword();
            return false;
        }
    }

    // public void ShowSlot(IGarageController garageController) {
    //     var numberofFreeSlots = 0;
    //     String SlotReport = "";
    //     for (int i = 0; i < garageController.getGarage().getNumSlots(); i++) {
    //         var s = garageController.getGarage().getSlots()[i];
    //         if (s.getOccupant() == null) {
    //             SlotReport += "Slot " + i + " is free\n" + " length : " + s.getLength() + " width :  " + s.getWidth() + "\n";
    //             numberofFreeSlots++;
    //         }
    //     }
    //     SlotReport += "\nNumber of Free Slots : " + numberofFreeSlots;
    //     garageController.getUI().showSlotsInfo(SlotReport);
    // }
}