public class ParkinController implements IParkinController{
    public void parkin(IGarageController garageController ) {
        if (garageController.isFull()) {
            garageController.getUI().showGarageFull();
        } else {
            while (!garageController.getUI().showVehicleForm()) {
                garageController.getUI().ShowInvalidInput();
            }
            Vehicle vinline = garageController.getVehicle(garageController.getVehicleInLine());
            int vinlineSlot = garageController.getGarage().getConfig().assignSlot(vinline, garageController.getGarage());
            if (vinlineSlot == -1) {
                garageController.getUI().showGarageFull();
            } else {
                vinline.setAssignedSlot(vinlineSlot);
                garageController.getGarage().getSlots()[vinlineSlot].setOccupant(vinline);
                garageController.getUI().showSlot(vinline.getAssignedSlot());
                // store current system time
                vinline.setArrivalTime(System.currentTimeMillis());
            }
        }
    }
}