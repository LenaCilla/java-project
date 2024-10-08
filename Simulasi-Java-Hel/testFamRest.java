package PerbaikanSimulasiUTS;
import java.util.ArrayList;
import java.util.Scanner;

public class testFamRest {
    public static void main(String[] args) {
        ArrayList<Menu> menuList = new ArrayList<Menu>();
        Scanner sc = new Scanner(System.in); 

        while (true) {
            System.out.println("Family Restaurant");
            System.out.println("==========");
            System.out.println("1. Add Regular Menu");
            System.out.println("2. Add Special Menu");
            System.out.println("3. Show All Menu");
            System.out.println("4. Delete Regular Menu");
            System.out.println("5. Delete Special Menu");
            System.out.println("6. Exit");
            System.out.print("Choice [1-6]: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addRegularMenu(menuList);
                    break;
                case 2:
                    addSpecialMenu(menuList);
                    break;
                case 3:
                    showAllMenu(menuList);
                    break;
                case 4:
                    deleteRegularMenu(menuList);
                    break;
                case 5:
                    deleteSpecialMenu(menuList);
                    break;
                case 6:
                    System.out.println("Program End.");
                    System.exit(0);
                default:
                    System.out.println("Choice [1-6]: ");
                    break;
            }
        }

    }

    private static void addRegularMenu(ArrayList<Menu> menuList) {
        Scanner sc = new Scanner(System.in); 
        System.out.println("Add Reguler Menu");
        System.out.println("==========");
        
        System.out.print("Input Menu Code [R...]: ");
        String kodeMenu = sc.next();
        System.out.print("Input Menu Name [5-20]: ");
        String namaMenu = sc.next();
        System.out.print("Input Menu Price [10000 - 100000]: ");
        int harga = sc.nextInt();

        // Validasi kode menu, nama menu, dan harga
        if (kodeMenu.matches("R\\d{4}") && isNamaMenuValid(namaMenu) && harga >= 10000 && harga <= 100000) {
            boolean kodeMenuExist = false;
            for (Menu menu : menuList) {
                if (menu.getKodeMenu().equals(kodeMenu)) {
                    kodeMenuExist = true;
                    break;
                }
            }

            if (!kodeMenuExist) {
                menuList.add(new RegularMenu(kodeMenu, namaMenu, harga));
                System.out.println("Add Success.");
            } else {
                System.out.println("Menu has been inputed.");
            }
        } else {
            System.out.println("Input is not valid.");
        }
    }

    private static void addSpecialMenu(ArrayList<Menu> menuList) {
        Scanner sc = new Scanner(System.in); 
        System.out.println("Add Special Menu");
        System.out.println("==========");
        
        System.out.print("Input Menu Code [S...]: ");
        String kodeMenu = sc.next();
        System.out.print("Input Menu Name [5-20]: ");
        String namaMenu = sc.next();
        System.out.print("Input Menu Price [10000 - 100000]: ");
        int harga = sc.nextInt();
        System.out.print("Input Menu Discount [ 10% | 25% | 50% ]: ");
        int diskon = sc.nextInt();

        // Validasi kode menu, nama menu, harga, dan diskon
        if (kodeMenu.matches("S\\d{4}") && isNamaMenuValid(namaMenu) && harga >= 10000 && harga <= 100000
                && (diskon == 10 || diskon == 25 || diskon == 50)) {
            boolean kodeMenuExist = false;
            for (Menu menu : menuList) {
                if (menu.getKodeMenu().equals(kodeMenu)) {
                    kodeMenuExist = true;
                    break;
                }
            }

            if (!kodeMenuExist) {
                menuList.add(new SpecialMenu(kodeMenu, namaMenu, harga, diskon));
                System.out.println("Add Success.");
            } else {
                System.out.println("Menu has been inputed.");
            }
        } else {
            System.out.println("Input is not valid.");
        }
    }

    private static void showAllMenu(ArrayList<Menu> menuList) {
        for (Menu menu : menuList) {
            if (menu instanceof RegularMenu) {
            	System.out.println("Reguler Menu");
            	System.out.println("==========");
                System.out.println("Kode: " + menu.getKodeMenu() + " | Nama: " + menu.getNamaMenu() + " | Harga: " + menu.getHarga());
            } else if (menu instanceof SpecialMenu) {
                SpecialMenu specialMenu = (SpecialMenu) menu;
                System.out.println("Special Menu");
                System.out.println("==========");
                System.out.println("Kode: " + specialMenu.getKodeMenu() + " | Nama: " + specialMenu.getNamaMenu() + " | Harga: " + specialMenu.getHarga() + " | Diskon: " + specialMenu.getDiskon() + "%");
            }
        }
    }

    private static void deleteRegularMenu(ArrayList<Menu> menuList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Delete Reguler Menu");
        System.out.println("==========");
        System.out.print("Input Menu Code [Rxxxx]: ");
        String kodeMenu = sc.next();
        int indexToRemove = -1;

        for (int i = 0; i < menuList.size(); i++) {
            if (menuList.get(i) instanceof RegularMenu && menuList.get(i).getKodeMenu().equals(kodeMenu)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            menuList.remove(indexToRemove);
            System.out.println("Delete Success.");
        } else {
            System.out.println("Code is Wrong.");
        }
    }

    private static void deleteSpecialMenu(ArrayList<Menu> menuList) {
        Scanner sc = new Scanner(System.in); 
        System.out.println("Delete Special Menu");
        System.out.println("==========");
        System.out.print("Input Menu Code [Sxxxx]: ");
        String kodeMenu = sc.next();
        int indexToRemove = -1;

        for (int i = 0; i < menuList.size(); i++) {
            if (menuList.get(i) instanceof SpecialMenu && menuList.get(i).getKodeMenu().equals(kodeMenu)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            menuList.remove(indexToRemove);
            System.out.println("Delete Success.");
        } else {
            System.out.println("Code is Wrong.");
        }
    }

    private static boolean isNamaMenuValid(String namaMenu) {
        return namaMenu.length() >= 5 && namaMenu.length() <= 20;
    }
}
