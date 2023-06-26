public class ParkoutControler implements IParkoutController{

    public void parkout(IGarageController garageController,String id) {
        Vehicle v = garageController.getVehicle(id);
        if (v != null) {
            garageController.getGarage().getSlots()[v.getAssignedSlot()].setOccupant(null);
            v.setAssignedSlot(-1);
            garageController.getUI().showFee(calculateFee(garageController, v));
        } else {
            garageController.getUI().ShowInvalidInput();
        }
    }

    public int calculateFee(IGarageController garageController,Vehicle v) {
        int pricePerHour = 5;

        float depTime = System.currentTimeMillis();
        float arrTime = v.getArrivalTime();
        float parkingTime = depTime - arrTime;
        // round up
        int arrivalTimeHours = Math.max((int) Math.ceil(parkingTime / (1000 * 60 * 60)), 1);
        int fee = arrivalTimeHours * pricePerHour;

        garageController.getGarage().setTotalRevenue(garageController.getGarage().getTotalRevenue() + fee);
        return fee;
    }
}