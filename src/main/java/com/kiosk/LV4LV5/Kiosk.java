package com.kiosk.LV4LV5;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final Menu menu = new Menu();
    private final Scanner sc = new Scanner(System.in);

    public void start() {
        menu.loadData();
        while (true) {
            try {
                displayCategory();
                int categorySeq = sc.nextInt();
                if (categorySeq == 0) break;
                MenuCategory choiceCategory = MenuCategory.getCategory(categorySeq);
                if (choiceCategory == null || choiceCategory == MenuCategory.UNKNOWN) {
                    System.out.println("올바른 카테고리를 선택해주세요");
                    continue;
                }

                displayManuItems(choiceCategory);
                int choice = sc.nextInt();
                List<MenuItem> menus = menu.getMenu(choiceCategory);
                while (choice >= menus.size() || choice < 0) {
                    System.out.println("올바른 메뉴를 선택해주세요");
                    choice = sc.nextInt();
                }
                if (choice == 0) break;
                MenuItem choiceItem = menus.get(choice-1);
                System.out.printf("선택한 메뉴 : %s | %f | %s\n" , choiceItem.getName(),choiceItem.getPrice(),choiceItem.getDescription());

            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    public void displayCategory() {
        System.out.println("[ MAIN MENU ]");
        MenuCategory[] categories = MenuCategory.values();
        for (int i = 0; i < categories.length; i++) {
            if(categories[i] == MenuCategory.UNKNOWN) continue;
            System.out.println(categories[i].getSeq() + ". " + categories[i].getLabel());
        }
        System.out.printf("%d. %s\n", 0, "종료");
    }

    public void displayManuItems(MenuCategory category) {
        if (category == null) {
            System.out.println("존재하지 않는 카테고리입니다.");
            return;
        }
        System.out.println("[ " + category.getLabel() + " MENU ]");
        int n = 0;
        for (MenuItem item : menu.getMenu(category)) {
            System.out.printf("%2d.%15s |  %4.1f  |  %20s\n", ++n, item.getName(), item.getPrice(), item.getDescription());
        }
        System.out.printf("%2d.%14s\n", 0, "종료");
    }



    public void addMenu(MenuCategory category,String name, double price,String description) {
        menu.addMenu(category,name,price,description);
    }
}
