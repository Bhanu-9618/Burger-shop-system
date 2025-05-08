import java.util.*;
class Example {
	public final static void clearConsole() { 
         try { 
         final String os = 
         System.getProperty("os.name"); if 
         (os.contains("Windows")) { 
         new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
         } else { 
         System.out.print("\033[H\033[2J"); 
         System.out.flush(); 
         } 
         } catch (final Exception e) { 
         e.printStackTrace(); 

         } 
         }
         
	public static void exit(){ 
    clearConsole(); 
    System.out.println("\n\t\tYou left the program...\n"); 
    System.exit(0); 
    } 
    
    final static double BURGERPRICE = 500;
    public static final int PREPARING = 0;
    public static final int DELIVERED = 1;
    public static final int CANCEL = 2;

    public static void main(String args[]) {
		
        Scanner input = new Scanner(System.in);
        
        String[] phoneNumbers = new String[100];
        String[] names = new String[100];       
        String[] orderIDs = new String[100];
        String[] orderPhones = new String[100];
        int[] orderQuantities = new int[100];
        double[] orderValues = new double[100];
        int[] orderStatuses = new int[100];
        double[] totals = new double[100];       
        
        int count = 0;
        int orderCount = 0;
        int j = 1;
        int i = 0;
        boolean run = true;

        while (run) {
            System.out.println("---------------------------------------------------");
            System.out.println("|                 iHungry Burger                  |");
            System.out.println("---------------------------------------------------");
            System.out.println("\t");
            System.out.print("[01] Place Order");
            System.out.println("\t [02] Search Best Customer");
            System.out.print("[03] Search Order");
            System.out.println("\t [04] Search Customer");
            System.out.print("[05] View Orders");
            System.out.println("\t [06] Update Order Details");
            System.out.println("[07] Exit");
            System.out.println("\t");

            System.out.print("Enter an option to continue > ");
            int Option = input.nextInt();
            input.nextLine();
            clearConsole();
            if (Option == 1) {
    System.out.println("---------------------------------------------------");
    System.out.println("|                   PLACE ORDER                   |");
    System.out.println("---------------------------------------------------");
    System.out.println("\t");

    boolean a = true;
    while (a) {
       
        String orderId = "B";
        if (j < 10) {
            orderId += "000" + j;
        } else if (j < 100) {
            orderId += "00" + j;
        } else if (j < 1000) {
            orderId += "0" + j;
        }
        
        
        System.out.printf("ORDER ID - %s\n", orderId);
  

        System.out.println("================");
        System.out.println("\t");

        String phone;
        while (true) {
            System.out.print("Enter Customer ID (phone no.): ");
            phone = input.nextLine();

            if (phone.length() == 10 && phone.charAt(0) == '0') {
                break;
            } else {
                System.out.println("Invalid phone number!\n");
            }
        }
        
        boolean found = false;

        for (i = 0; i < count; i++) {
            if (phoneNumbers[i].equals(phone)) {
                System.out.println("Customer Name: " + names[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.print("Customer Name: ");
            String name = input.nextLine();

            phoneNumbers[count] = phone;
            names[count] = name;
            count++;
        }

        System.out.print("Enter Burger Quantity - ");
        int quantity = input.nextInt();

        double total = BURGERPRICE * quantity;

        System.out.println("Total Value - " + total);
        int index = i;

        System.out.print("\tAre you confirm order - ");
        char conf = input.next().charAt(0);
        input.nextLine();
        System.out.println("\t");

        if (conf == 'y' || conf == 'Y') {
            System.out.println("\tYour order is entered into the system successfully...\n");
            totals[index] += total;
            j++;

            orderIDs[orderCount] = orderId;
            orderPhones[orderCount] = phone;
            orderQuantities[orderCount] = quantity;
            orderValues[orderCount] = total;
            orderStatuses[orderCount] = PREPARING;
            orderCount++;
        } else {
            System.out.println("\tYou cancelled your order...\n");
            
        }

        System.out.print("Do you want to place another order (Y/N): ");
        char another = input.next().charAt(0);
        input.nextLine();
        clearConsole();
        System.out.println("\t");

        if (another == 'n' || another == 'N') {
            a = false;
            run = true;
            
        }
    }
}

if (Option == 2) {
    int a = 0;

   
    for ( i = 0; i < count; i++) {
        for ( j = i + 1; j < count; j++) {
            if (totals[i] < totals[j]) {
                
                double tempTotal = totals[i];
                totals[i] = totals[j];
                totals[j] = tempTotal;

                
                String tempPhone = phoneNumbers[i];
                phoneNumbers[i] = phoneNumbers[j];
                phoneNumbers[j] = tempPhone;

               
                String tempName = names[i];
                names[i] = names[j];
                names[j] = tempName;
            }
        }
    }

    System.out.println("---------------------------------------------------");
    System.out.println("|                 BEST CUSTOMER                   |");
    System.out.println("---------------------------------------------------");
    System.out.println();
   
    System.out.println("---------------------------------------------------");
    System.out.printf("%-15s %-15s %-15s\n", "CustomerID", "Name", "Total");
    System.out.println("---------------------------------------------------");

    for (a = 0; a < count; a++) {
        System.out.printf("%-15s %-15s Rs.%-12.2f\n", phoneNumbers[a], names[a], totals[a]);
        System.out.println("---------------------------------------------------");
    }
    System.out.println();
    System.out.print("\tDo you want to go back to main menu? (Y/N)> ");
    char again3 = input.next().charAt(0);
    
    if (again3 == 'n' || again3 == 'N') { 
		        clearConsole();      
                run = false;
                exit();
                
            } else { 
				clearConsole();             
                run = true;
                
            }
   }


    if (Option == 3) {
    System.out.println("---------------------------------------------------");
    System.out.println("|              SEARCH ORDER DETAILS               |");
    System.out.println("---------------------------------------------------");
    System.out.println();

    boolean a = true;
    while (a) {
        System.out.print("Enter Order ID - ");
        String searchId = input.nextLine();
        boolean orderFound = false;
        System.out.println();

        for (int x = 0; x < orderCount; x++) {
            if (orderIDs[x].equals(searchId)) {
                String k = orderPhones[x];
                String customerName = "";

                for (int z = 0; z < count; z++) {
                    if (phoneNumbers[z].equals(k)) {
                        customerName = names[z];
                        break;
                    }
                }

                System.out.println("------------------------------------------------------------------------------------");
                System.out.printf("%-12s %-15s %-15s %-10s %-15s %-15s\n",
                        "OrderID", "CustomerID", "Name", "Quantity", "Order Value", "Order Status");
                System.out.println("------------------------------------------------------------------------------------");

                String orderStatus = "";
                switch (orderStatuses[x]) {
                    case PREPARING:
                        orderStatus = "Preparing";
                        break;
                    case DELIVERED:
                        orderStatus = "Delivered";
                        break;
                    case CANCEL:
                        orderStatus = "Cancelled";
                        break;
                }

                System.out.printf("%-12s %-15s %-15s %-10d Rs.%-12.2f %-15s\n",
                        orderIDs[x], orderPhones[x], customerName, orderQuantities[x], orderValues[x], orderStatus);

                orderFound = true;
                break;
            }
        }

        System.out.println("\t");
        System.out.println("\t");

        if (!orderFound) {
            System.out.print("Invalid order ID. Do you want to enter again? (Y/N): ");
            char again2 = input.next().charAt(0);
            input.nextLine();
            clearConsole();
            System.out.println("\t");
            if (again2 == 'n' || again2 == 'N') {
                a = false;
                run = true;
            } else {
                a = true;
                run = false;
            }
        } else {
            System.out.print("Do you want to search another order details? (Y/N): ");
            char another2 = input.next().charAt(0);
            input.nextLine();
            System.out.println();
            clearConsole();
            if (another2 == 'n' || another2 == 'N') {
                a = false;
                run = true;
            } else {
                a = true;
                run = false;
            }
        }
    }
}
if (Option == 4) {
    boolean c = true;
    while (c) {
        System.out.println("---------------------------------------------------");
        System.out.println("|             SEARCH CUSTOMER DETAILS             |");
        System.out.println("---------------------------------------------------");
        System.out.println("\t");

        System.out.print("Enter customer Id - ");
        String id = input.nextLine();

        boolean foundCustomer = false;

        for (i = 0; i < count; i++) {
            if (id.equals(phoneNumbers[i])) {
                System.out.println();
                System.out.println("CustomerID - " + phoneNumbers[i]);
                System.out.println("Name       - " + names[i]);
                System.out.println();
                foundCustomer = true;
                break;
            }
        }

        if (!foundCustomer) {
            System.out.println();
            System.out.println("\tThis customer ID is not added yet....");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Customer Order Details");
            System.out.println("=======================");
            System.out.println();
            System.out.println("------------------------------------------------------");
            System.out.printf("%-15s %-15s %-15s\n", "Order_ID", "Order_Quantity", "Total_Value");
            System.out.println("------------------------------------------------------");

            

            for (int k = 0; k < orderCount; k++) {
                if (orderPhones[k].equals(id)) {
                    System.out.printf("%-15s %-15d %-15.2f\n", orderIDs[k], orderQuantities[k], orderValues[k]);
                }
            }                       

            System.out.println("------------------------------------------------------");
            System.out.println();
        }

        System.out.print("Do you want to search another customer details (Y/N): ");
        char another = input.next().charAt(0);
        input.nextLine(); 
        
        if (another == 'n' || another == 'N') {
            c = false;
            run = true;
        } else {
            c = true;
        }
    }
}


            if (Option == 5) {
                System.out.println("---------------------------------------------------");
                System.out.println("|                    VIEW ORDERS                  |");
                System.out.println("---------------------------------------------------");
                System.out.println("\t");
                System.out.println("[1] Delivered Orders");
                System.out.println("[2] Preparing Orders");
                System.out.println("[3] Canceled Orders");
                System.out.println("\t");
                System.out.print("Enter an option to continue > ");
                int viewOption = input.nextInt();
                input.nextLine();
                System.out.println("\t");
                clearConsole();

                int targetStatus = -1;
                String statusLabel = "";

                switch (viewOption) {
                    case 1:
                        targetStatus = DELIVERED;
                        statusLabel = "DELIVERED ORDERS";
                        break;
                    case 2:
                        targetStatus = PREPARING;
                        statusLabel = "PREPARING ORDERS";
                        break;
                    case 3:
                        targetStatus = CANCEL;
                        statusLabel = "CANCELLED ORDERS";
                        break;
                }

                System.out.println("---------------------------------------------------");
                System.out.printf("|%35s%14s|\n", statusLabel, "");
                System.out.println("---------------------------------------------------");
                System.out.println("\t");
                System.out.println("--------------------------------------------------------------------");
                System.out.printf("%-12s %-15s %-15s %-10s %-15s\n", "OrderID", "CustomerID", "Name", "Quantity", "Order Value");
                System.out.println("--------------------------------------------------------------------");
                boolean foundAny = false;

                for (int x = 0; x < orderCount; x++) {
                    if (orderStatuses[x] == targetStatus) {
                        String phone = orderPhones[x];
                        String name = "";
                        for (int z = 0; z < count; z++) {
                            if (phoneNumbers[z].equals(phone)) {
                                name = names[z];
                                break;
                            }
                        }

                        System.out.printf("%-12s %-15s %-15s %-10d Rs.%-12.2f\n",
                                orderIDs[x], orderPhones[x], name, orderQuantities[x], orderValues[x]);
                                System.out.println("--------------------------------------------------------------------");
                        foundAny = true;
                    }
                }

                if (!foundAny) {
                    System.out.println("No orders.");
                }

                System.out.println("\t");
                System.out.print("Do you want to go homepage (Y/N): ");
                char back = input.next().charAt(0);
                input.nextLine();
                clearConsole();
                if (back == 'n' || back == 'N') {
                    run = false;
                    exit();
                }else{
					run = true;
				}
            }
    if (Option == 6) {
    System.out.println("---------------------------------------------------");
    System.out.println("|               UPDATE ORDER DETAILS               |");
    System.out.println("---------------------------------------------------");

    boolean b = true;
    while (b) {
        System.out.print("Enter Order ID - ");
        String orderIdToUpdate = input.nextLine();
        boolean orderFound = false;
        System.out.println();

        for (int x = 0; x < orderCount; x++) {
            if (orderIDs[x].equals(orderIdToUpdate)) {
                orderFound = true;

                if (orderStatuses[x] == DELIVERED) {
                    System.out.println("This order is already delivered ... You cannot update this order...");
                } else if (orderStatuses[x] == CANCEL) {
                    System.out.println("This order is already cancelled ... You cannot update this order...");
                } else {
                    String phone = orderPhones[x];
                    String customerName = "";

                    for (int z = 0; z < count; z++) {
                        if (phoneNumbers[z].equals(phone)) {
                            customerName = names[z];
                            break;
                        }
                    }

                    String orderStatus = "";
                    switch (orderStatuses[x]) {
                        case PREPARING: 
                        orderStatus = "Preparing";
                        break;
                        case DELIVERED: 
                        orderStatus = "Delivered"; 
                        break;
                        case CANCEL:    
                        orderStatus = "Cancelled"; 
                        break;
                    }

                    System.out.println("OrderID       - " + orderIDs[x]);
                    System.out.println("CustomerID    - " + orderPhones[x]);
                    System.out.println("Name          - " + customerName);
                    System.out.println("Quantity      - " + orderQuantities[x]);
                    System.out.println("Order Value   - " + orderValues[x]);
                    System.out.println("Order Status  - " + orderStatus);
                    System.out.println();

                    System.out.println("What do you want to update?");
                    System.out.println("\t[1] Quantity");
                    System.out.println("\t[2] Status");
                    System.out.println();
                    
                    System.out.print("Enter your option - ");
                    int updateChoice = input.nextInt();
                    input.nextLine();
                    clearConsole();
                    if (updateChoice == 1) {
                        System.out.println("\nQuantity Update");
                        System.out.println("================");
                        System.out.print("Enter your quantity update value - ");
                        int newQuantity = input.nextInt();
                        input.nextLine();

                        
                            orderQuantities[x] = newQuantity;
                            orderValues[x] = newQuantity * BURGERPRICE;

                            System.out.println("\n\tUpdate order quantity successfully...");
                            System.out.printf("\tNew order quantity - %d\n", orderQuantities[x]);
                            System.out.printf("\tNew Order Value    - Rs.%.2f\n", orderValues[x]);
                         
                    } else if (updateChoice == 2) {
                        System.out.println("Enter new Order Status: ");
                        System.out.println("\t[0] Cancel");
                        System.out.println("\t[1] Preparing");
                        System.out.println("\t[2] Delivered");
                        System.out.print("Enter new order status - ");
                        int newStatus = input.nextInt();
                        input.nextLine();
                        
                        if (newStatus == 0) {
                            orderStatuses[x] = CANCEL;
                            System.out.println("\n\tUpdate order status successfully...");
                            System.out.println("\tNew order status - Cancelled");
                        } else if (newStatus == 1) {
                            orderStatuses[x] = PREPARING;
                            System.out.println("\n\tUpdate order status successfully...");
                            System.out.println("\tNew order status - Preparing");
                        } else if (newStatus == 2) {
                            orderStatuses[x] = DELIVERED;
                            System.out.println("\n\tUpdate order status successfully...");
                            System.out.println("\tNew order status - Delivered");
                        }
                    } 
                }
                
               
                System.out.println();
                System.out.print("Do you want to update another order details (Y/N): ");
                char anotherOrder = input.next().charAt(0);
                input.nextLine();
                System.out.println();
                
                if (anotherOrder == 'n' || anotherOrder == 'N') {
					
                    b = false;
                    run = true;
                    clearConsole();
                    break;
                    
                }
                
            }
        }

        if (!orderFound) {
            System.out.println("Invalid Order ID");
            System.out.print("Do you want to update another order details (Y/N): ");
            char anotherOrder = input.next().charAt(0);
            input.nextLine();
            System.out.println("\t");
            clearConsole();
            if (anotherOrder == 'n' || anotherOrder == 'N') {
                b = false;
                run = true;
            }
        }
    }
}
if(Option==7){
	exit();
}

}
}
}
