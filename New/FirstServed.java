public class FirstServed implements ISlotAssigner
{
    @Override
    public int assignSlot(IVehicle v, IGarage garage){
        for (int i = 0; i < garage.getNumSlots(); i++) {
                if (garage.getSlots()[i].getOccupant() == null &&
                        garage.getSlots()[i].getLength() >= v.getLength() &&
                        garage.getSlots()[i].getWidth() >= v.getWidth()) {
                    return i;
                }
            }
        return -1;
    }
}