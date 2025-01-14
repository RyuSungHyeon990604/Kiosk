package com.kiosk.LV3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<MenuItem> menus = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);
    public Kiosk(List<MenuItem> menus) {
        //this.menus = menus 사용시 매개변수로 받은 menus에 변동사항 발생시 kiosk의 menus에도 변동발생
        this.menus.addAll(menus);
    }
    public void start(){
        while(true) {
            System.out.println("[ SHAKESHACK MENU ]");
            System.out.printf("%3d.%14s\n", 0,"종료");
            for (int i = 0; i < menus.size(); i++) {
                System.out.printf("%3d.%15s |  %4.1f  |  %20s\n", i + 1, menus.get(i).getName(), menus.get(i).getPrice(), menus.get(i).getDescription());
            }
            try {
                int choice = sc.nextInt();
                if (choice == 0) break;
                MenuItem choiceItem = menus.get(choice - 1);
                System.out.println("-----선택한 메뉴-----");
                System.out.println(choiceItem.getName());
                System.out.println(choiceItem.getPrice()*1000+"원");
                System.out.println(choiceItem.getDescription());
                System.out.println("--------------------");

            } catch (Exception e) {
                System.out.println("존재하지 않는 메뉴입니다.");
                sc.nextLine();
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
