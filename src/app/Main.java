package app;

import abstractfactory.GUIFactory;
import abstractfactory.MacOSFactory;
import abstractfactory.WindowsFactory;
import factorymethod.Logistics;
import factorymethod.RoadLogistics;
import factorymethod.SeaLogistics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter delivery mode (Road or sea?): ");
        String deliveryInput = scanner.nextLine();

        System.out.print("Enter UI platform (Windows or Macos?): ");
        String uiInput = scanner.nextLine();

        try {
            DeliveryMode deliveryMode = ChoiceParser.parseDeliveryMode(deliveryInput);
            UiPlatform uiPlatform = ChoiceParser.parseUiPlatform(uiInput);

            Logistics logistics = deliveryMode == DeliveryMode.ROAD ? new RoadLogistics() : new SeaLogistics();
            GUIFactory guiFactory = uiPlatform == UiPlatform.WINDOWS ? new WindowsFactory() : new MacOSFactory();

            DeliveryApplication app = new DeliveryApplication(logistics, guiFactory);
            app.run("laboratory equipment", "Almaty");

        } catch (InvalidChoiceException e) {
            System.out.println(e.getMessage());
        }
    }
}
