public class Garage implements IGarage
{
    private int numSlots;
    private int currSlot;
    private int occupiedSlots;
    private Slot[] slots;
    private ISlotAssigner SAssigner;

    private int totalRevenue;
    private int totalVehicles;


    public Garage(){
        numSlots = 0;
        occupiedSlots = 0;
        totalRevenue = 0;
        totalVehicles = 0;
        currSlot = 0;
        slots = new Slot[0];
    }
    public boolean setConfig(int config){
        if(config == 0){
            SAssigner = new FirstServed();
            return true;
        }
        if(config == 1){
            SAssigner = new BestFit();
            return true;
        }
        else{
            return false;
        }
    }
    public void addSlot(float len, float wid){
        slots[currSlot++].setDimention(len, wid);
    }

    //getters and setters for attributes
    public int getNumSlots(){
        return numSlots;
    }
    public int getOccupiedSlots(){
        return occupiedSlots;
    }
    public Slot[] getSlots(){
        return slots;
    }
    public ISlotAssigner getConfig(){
        return SAssigner;
    }
    public void setNumSlots(int n){
        numSlots = n;
    }
    public void setUpGarage(int n,int c ,Slot [] s){
        numSlots = n;
        setConfig(c);
        slots = s;
    }
    public void setTotalRevenue(int r){
        totalRevenue = r;
    }
    public void setTotalVehicles(int v){
        totalVehicles = v;
    }
    public int getTotalRevenue(){
        return totalRevenue;
    }
    public int getTotalVehicles(){
        return totalVehicles;
    }
}