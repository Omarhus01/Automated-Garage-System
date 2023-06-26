interface IParkoutController{
    public void parkout(IGarageController garageController, String id);
    public int calculateFee(IGarageController garageController, Vehicle v);
}