package app;

import abstractfactory.GUIFactory;
import factorymethod.Logistics;

public class DeliveryApplication {
    private final Logistics logistics;
    private final GUIFactory guiFactory;

    public DeliveryApplication(Logistics logistics, GUIFactory guiFactory) {
        this.logistics = logistics;
        this.guiFactory = guiFactory;
    }

    public void run(String cargo, String destination) {
        guiFactory.createButton().render();
        guiFactory.createCheckbox().render();
        logistics.planDelivery(cargo, destination);
    }
}
