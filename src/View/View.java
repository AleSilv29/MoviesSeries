package View;

import Controller.ItemController;
import Controller.OrderController;
import Controller.UserController;
import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View implements ViewInterface{
    private ItemController itemController;
    private OrderController orderController;
    private UserController userController;

    public View(ItemController itemController, OrderController orderController, UserController userController) {
        this.itemController = itemController;
        this.orderController = orderController;
        this.userController = userController;
    }

    public void printAllUsers()
    {
        for (User u : userController.getUsers())
        {
            System.out.print("Firstname: ");
            System.out.println(u.getFirstName());
            System.out.print("Lastname: ");
            System.out.println(u.getLastName());
            System.out.println();
            //printOrderList(u.getOrders());
        }
    }

    public static void printOrderList(List<Order> orderList)
    {
        for (Order o : orderList)
        {
            System.out.print("Date: ");
            System.out.println(o.getDate());
            printItemList(o.getItems());
        }
    }

    public static void printItemList(List<Item> itemList)
    {
        for (Item i : itemList)
        {
            System.out.print("Title: ");
            System.out.println(i.getTitle());
            System.out.print("Rating: ");
            System.out.println(i.getRating());
            System.out.print("Year: ");
            System.out.println(i.getJahr());
        }
    }

    public void printAllOrders()
    {
        for (Order o : orderController.getOrders())
        {
            System.out.print("Date: ");
            System.out.println(o.getDate());
            printItemList(o.getItems());
            System.out.println();
        }
    }
    public void printAllItems()
    {
        printItemList(itemController.getItems());
    }
    public void printAllMovies()
    {
        for (Movies m : itemController.getMovies())
        {
            System.out.print("Title: ");
            System.out.println(m.getTitle());
            System.out.print("Rating: ");
            System.out.println(m.getRating());
            System.out.print("Year: ");
            System.out.println(m.getJahr());
            System.out.print("Duration: ");
            System.out.println(m.getDuration());
            System.out.print("Budget: ");
            System.out.println(m.getBudget());
            System.out.println();
        }

    }
    public void printAllSeries()
    {
        for (Series s : itemController.getSeries())
        {
            System.out.print("Title: ");
            System.out.println(s.getTitle());
            System.out.print("Rating: ");
            System.out.println(s.getRating());
            System.out.print("Year: ");
            System.out.println(s.getJahr());
            System.out.print("Number of episodes:");
            System.out.println(s.getNumberOfEpisodes());
            System.out.println();
        }
    }

    public void addOrder()
    {
        Scanner in = new Scanner(System.in);
        String firstName;
        String lastName;
        Integer n;
        System.out.print("Firstname: ");
        firstName = in.nextLine().strip();
        System.out.print("Lastname: ");
        lastName = in.nextLine().strip();
        //lastName = " ";
        System.out.print("Number of items: ");
        try {
            n = Integer.parseInt(in.nextLine());
        }
        catch (NumberFormatException ignored)
        {
            System.out.println("Invalid number of items!");
            return;
        }
        System.out.println("Titles: ");
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < n; ++i)
        {
            titles.add(in.nextLine());
        }
        try {
            orderController.addOrder(firstName, lastName, titles);
        }
        catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void printMoviesSortedByRating()
    {
        List<Movies> mov = itemController.getMoviesSortedByRating();
        for (Movies m : mov)
        {
            System.out.print("Title: ");
            System.out.println(m.getTitle());
            System.out.print("Rating: ");
            System.out.println(m.getRating());
            System.out.print("Year: ");
            System.out.println(m.getJahr());
            System.out.print("Duration: ");
            System.out.println(m.getDuration());
            System.out.print("Budget: ");
            System.out.println(m.getBudget());
            System.out.println();
        }
    }
    public void printLongestSeries()
    {
        Series s = itemController.getLongestSeries();
        System.out.print("Title: ");
        System.out.println(s.getTitle());
        System.out.print("Rating: ");
        System.out.println(s.getRating());
        System.out.print("Year: ");
        System.out.println(s.getJahr());
        System.out.print("Number of episodes:");
        System.out.println(s.getNumberOfEpisodes());
    }
    public void printHighestBudgetMovie()
    {
        Movies m = itemController.getHighestBudgetMovie();
        System.out.print("Title: ");
        System.out.println(m.getTitle());
        System.out.print("Rating: ");
        System.out.println(m.getRating());
        System.out.print("Year: ");
        System.out.println(m.getJahr());
        System.out.print("Duration: ");
        System.out.println(m.getDuration());
        System.out.print("Budget: ");
        System.out.println(m.getBudget());
    }

    public void printMenu()
    {
            String ANSI_YELLOW = "\u001B[33m";
            String ANSI_RESET = "\u001B[0m";
            System.out.println(ANSI_YELLOW +
                    "____    __    ____  _______  __        ______   ______   .___  ___.  _______    .___________.  ______   \n" +
                    "\\   \\  /  \\  /   / |   ____||  |      /      | /  __  \\  |   \\/   | |   ____|   |           | /  __  \\  \n" +
                    " \\   \\/    \\/   /  |  |__   |  |     |  ,----'|  |  |  | |  \\  /  | |  |__      `---|  |----`|  |  |  | \n" +
                    "  \\            /   |   __|  |  |     |  |     |  |  |  | |  |\\/|  | |   __|         |  |     |  |  |  | \n" +
                    "   \\    /    /    |  |____ |  `----.|  `----.|  `--'  | |  |  |  | |  |____          |  |     |  `--'  | \n" +
                    "    \\__/  \\__/     |_______||_______| \\______| \\______/  |__|  |__| |_______|       |__|      \\______/  \n" +
                    "                     .___  ___.   ______   ____    ____  __   _______      _______.                     \n" +
                    "                     |   \\/   |  /  __  \\  \\   \\  /   / |  | |   ____|    /       |                     \n" +
                    "                     |  \\  /  | |  |  |  |  \\   \\/   /  |  | |  |__      |   (----`                     \n" +
                    "                     |  |\\/|  | |  |  |  |   \\      /   |  | |   __|      \\   \\                         \n" +
                    "                     |  |  |  | |  `--'  |    \\    /    |  | |  |____ .----)   |                        \n" +
                    "                     |__|  |__|  \\______/      \\__/     |__| |_______||_______/                         \n" +
                    "                             ___      .__   __.  _______                                                \n" +
                    "                            /   \\     |  \\ |  | |       \\                                               \n" +
                    "                           /  ^  \\    |   \\|  | |  .--.  |                                              \n" +
                    "                          /  /_\\  \\   |  . `  | |  |  |  |                                              \n" +
                    "                         /  _____  \\  |  |\\   | |  '--'  |                                              \n" +
                    "                        /__/     \\__\\ |__| \\__| |_______/                                               \n" +
                    "                    _______. _______ .______       __   _______      _______.                           \n" +
                    "                   /       ||   ____||   _  \\     |  | |   ____|    /       |                           \n" +
                    "                  |   (----`|  |__   |  |_)  |    |  | |  |__      |   (----`                           \n" +
                    "                   \\   \\    |   __|  |      /     |  | |   __|      \\   \\                               \n" +
                    "               .----)   |   |  |____ |  |\\  \\----.|  | |  |____ .----)   |                              \n" +
                    "               |_______/    |_______|| _| `._____||__| |_______||_______/  " +
                    ANSI_RESET);

        System.out.println();
        System.out.println("1)Print all users\n2) Print all orders!\n3) Print all items!\n4) Print all movies!\n5) Print all series!\n6) Print movies (by rating)\n7) Print longest series!\n8) Print highest budget movie!\n9) Add order!\n10)Exit");
    }
    public void printMenu2(){
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_YELLOW +
                "____    __    ____  _______  __        ______   ______   .___  ___.  _______    .___________.  ______   \n" +
                "\\   \\  /  \\  /   / |   ____||  |      /      | /  __  \\  |   \\/   | |   ____|   |           | /  __  \\  \n" +
                " \\   \\/    \\/   /  |  |__   |  |     |  ,----'|  |  |  | |  \\  /  | |  |__      `---|  |----`|  |  |  | \n" +
                "  \\            /   |   __|  |  |     |  |     |  |  |  | |  |\\/|  | |   __|         |  |     |  |  |  | \n" +
                "   \\    /    /    |  |____ |  `----.|  `----.|  `--'  | |  |  |  | |  |____          |  |     |  `--'  | \n" +
                "    \\__/  \\__/     |_______||_______| \\______| \\______/  |__|  |__| |_______|       |__|      \\______/  \n" +
                "                     .___  ___.   ______   ____    ____  __   _______      _______.                     \n" +
                "                     |   \\/   |  /  __  \\  \\   \\  /   / |  | |   ____|    /       |                     \n" +
                "                     |  \\  /  | |  |  |  |  \\   \\/   /  |  | |  |__      |   (----`                     \n" +
                "                     |  |\\/|  | |  |  |  |   \\      /   |  | |   __|      \\   \\                         \n" +
                "                     |  |  |  | |  `--'  |    \\    /    |  | |  |____ .----)   |                        \n" +
                "                     |__|  |__|  \\______/      \\__/     |__| |_______||_______/                         \n" +
                "                             ___      .__   __.  _______                                                \n" +
                "                            /   \\     |  \\ |  | |       \\                                               \n" +
                "                           /  ^  \\    |   \\|  | |  .--.  |                                              \n" +
                "                          /  /_\\  \\   |  . `  | |  |  |  |                                              \n" +
                "                         /  _____  \\  |  |\\   | |  '--'  |                                              \n" +
                "                        /__/     \\__\\ |__| \\__| |_______/                                               \n" +
                "                    _______. _______ .______       __   _______      _______.                           \n" +
                "                   /       ||   ____||   _  \\     |  | |   ____|    /       |                           \n" +
                "                  |   (----`|  |__   |  |_)  |    |  | |  |__      |   (----`                           \n" +
                "                   \\   \\    |   __|  |      /     |  | |   __|      \\   \\                               \n" +
                "               .----)   |   |  |____ |  |\\  \\----.|  | |  |____ .----)   |                              \n" +
                "               |_______/    |_______|| _| `._____||__| |_______||_______/  " +
                ANSI_RESET);

        System.out.println();
        System.out.println("1) Print all items!\n2) Print all movies!\n3) Print all series!\n4) Print movies (by rating)\n5) Print longest series!\n6) Print highest budget movie!\n7) Add order!\n8)Exit");
    }
    public int login(){
        Scanner in = new Scanner(System.in);
        Integer option;
        System.out.print("Choose an option: ");
        System.out.println();
        System.out.print("1.Adimn, 2.User: ");
        option = in.nextInt();
        if (option == 1){
            String id;
            String pass;
            Scanner username = new Scanner(System.in);
            Scanner password = new Scanner(System.in);
            System.out.print("Username: ");
            id = username.nextLine();
            System.out.print("Password: ");
            pass = password.nextLine();
            if (userController.FindUserByIDAndPassword(String.valueOf(id), pass) != null){
                printMenu();
                return 1;
            }
            else{
                System.out.println("Invalid username or password!");
                System.out.println();
                String ANSI_YELLOW = "\u001B[32m";
                String ANSI_RESET = "\u001B[0m";
                System.out.println(ANSI_YELLOW +
                        "        .--'''''''''--.\n" +
                        "     .'      .---.      '.\n" +
                        "    /    .-----------.    \\\n" +
                        "   /        .-----.        \\\n" +
                        "   |       .-.   .-.       |\n" +
                        "   |      /   \\ /   \\      |\n" +
                        "    \\    | .-. | .-. |    /\n" +
                        "     '-._| | | | | | |_.-'\n" +
                        "         | '-' | '-' |\n" +
                        "          \\___/ \\___/\n" +
                        "       _.-'  /   \\  `-._\n" +
                        "     .' _.--|     |--._ '.\n" +
                        "     ' _...-|     |-..._ '\n" +
                        "            |     |\n" +
                        "            '.___.'\n" +
                        "              | |\n" +
                        "             _| |_\n" +
                        "            /\\( )/\\\n" +
                        "           /  ` '  \\" + ANSI_RESET);
                return 0;
            }
        }
        else
        if (option == 2){
            String id;
            String pass;
            Scanner username = new Scanner(System.in);
            Scanner password = new Scanner(System.in);
            System.out.print("Username: ");
            id = username.nextLine();
            System.out.print("Password: ");
            pass = password.nextLine();
            if (userController.FindUserByIDAndPassword(String.valueOf(id), pass) != null){
                printMenu2();
                return 2;
            }
            else{
                System.out.println("Invalid username or password!");
                return 0;
            }
        }
        else{
            System.out.println("Invalid option!");
            return 0;
        }
    }
    public void console() {
       int x = login();
       if (x == 0)
           return;
       if(x == 1){
        while (true)
        {
            Scanner in = new Scanner(System.in);
            System.out.print("Option: ");
            Integer option;
            try
            {
                option = Integer.parseInt(in.nextLine());
            }
            catch (NumberFormatException ignored)
            {
                System.out.println("Unknown option!");
                continue;
            }
            switch (option) {
                case 1: {
                    printAllUsers();
                    break;
                }
                case 2: {
                    printAllOrders();
                    break;
                }
                case 3: {
                    printAllItems();
                    break;
                }
                case 4: {
                    printAllMovies();
                    break;
                }
                case 5: {
                    printAllSeries();
                    break;
                }
                case 6: {
                    printMoviesSortedByRating();
                    break;
                }
                case 7: {
                    printLongestSeries();
                    break;
                }
                case 8: {
                    printHighestBudgetMovie();
                    break;
                }
                case 9: {
                    addOrder();
                    break;
                }
                case 10: {
                    return;
                }
                default: {
                    System.out.println("Unknown option!");
                    break;
                    }
                }
            }
        }
       else
       {
       while (true)
       {
           if (x == 2) {
               Scanner in = new Scanner(System.in);
               System.out.print("Option: ");
               Integer option;
               try {
                   option = Integer.parseInt(in.nextLine());
               } catch (NumberFormatException ignored) {
                   System.out.println("Unknown option!");
                   continue;
               }
               switch (option) {
                   case 1: {
                       printAllItems();
                       break;
                   }
                   case 2: {
                       printAllMovies();
                       break;
                   }
                   case 3: {
                       printAllSeries();
                       break;
                   }
                   case 4: {
                       printMoviesSortedByRating();
                       break;
                   }
                   case 5: {
                       printLongestSeries();
                       break;
                   }
                   case 6: {
                       printHighestBudgetMovie();
                       break;
                   }
                   case 7: {
                       addOrder();
                       break;
                   }
                   case 8: {
                       return;
                   }
                   default: {
                       System.out.println("Unknown option!");
                       break;
                   }
               }
           }
       }
   }
}
}
