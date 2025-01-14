package com.kiosk.LV2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MenuItem> menus = new ArrayList<>();
        menus.add(new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menus.add(new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menus.add(new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menus.add(new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));

        while(true){
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.printf("%3d.%15s |  %4.1f  |  %20s\n",i+1,menus.get(i).getName(),menus.get(i).getPrice(),menus.get(i).getDescription());
            }
            System.out.printf("%3d.종료\n",menus.size()+1);
            try{
                int choice = sc.nextInt();
                if(choice == menus.size()+1) break;
                MenuItem choiceItem = menus.get(choice-1);
                System.out.println(choiceItem.getName());
                System.out.println(choiceItem.getPrice());
                System.out.println(choiceItem.getDescription());
            }catch (Exception e){
                System.out.println("존재하지 않는 메뉴입니다.");
                sc.nextLine();
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
