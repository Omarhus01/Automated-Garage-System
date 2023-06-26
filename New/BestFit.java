public class BestFit implements ISlotAssigner {
    @Override
    public int assignSlot(IVehicle v, IGarage garage)
    {
        int assigned = -1;
            for (int i = 0; i < garage.getNumSlots(); i++) {
                if (garage.getSlots()[i].getOccupant() == null) {
                    if (garage.getSlots()[i].getLength() >= v.getLength() &&
                            garage.getSlots()[i].getWidth() >= v.getWidth()) {
                        if (assigned == -1) {
                            assigned = i;
                        } else {
                            if (garage.getSlots()[i].getArea() < garage.getSlots()[assigned].getArea()) {
                                assigned = i;
                            }
                        }
                    }
                }
            }
        return assigned;
    }
}