package MapsLambdaAndStreamAPI.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        LinkedHashMap<String, Double> quantityList = new LinkedHashMap<>();
        LinkedHashMap<String, Double> priceList = new LinkedHashMap<>();

        while (!command.equals("buy")) {
            String[] commandArr = command.split(" ");
            String item = commandArr[0];
            double price = Double.parseDouble(commandArr[1]);
            double quantity = Double.parseDouble(commandArr[2]);

            if (!quantityList.containsKey(item)) {
                quantityList.put(item, quantity);
                priceList.put(item, price);
            } else {
                double oldQuantity = quantityList.get(item);
                quantityList.put(item, oldQuantity + quantity);
                priceList.put(item, price);
            }
            command = scanner.nextLine();
        }
        for (Map.Entry<String, Double> quantity : quantityList.entrySet()) {
            for (Map.Entry<String, Double> price : priceList.entrySet()) {
                if (quantity.getKey().equals(price.getKey())) {
                    System.out.printf("%s -> %.2f\n", price.getKey(), quantity.getValue() * price.getValue());
                    break;
                }
            }
        }
    }
}