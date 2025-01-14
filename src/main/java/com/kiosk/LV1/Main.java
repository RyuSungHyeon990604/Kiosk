package com.kiosk.LV1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit) {
            System.out.println("[ SHAKESHACK MENU ]");
            System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            System.out.println("3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            System.out.println("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
            System.out.println("0. 종료      | 종료");
            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("ShackBurger");
                        System.out.println("W 6.9");
                        System.out.println("토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                        break;
                    case 2:
                        System.out.println("SmokeShack");
                        System.out.println("W 8.9");
                        System.out.println("베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                        break;
                    case 3:
                        System.out.println("Cheeseburger");
                        System.out.println("W 6.9");
                        System.out.println("포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                        break;
                    case 4:
                        System.out.println("Hamburger");
                        System.out.println("W 5.4");
                        System.out.println("비프패티를 기반으로 야채가 들어간 기본버거");
                        break;
                    case 0:
                        isExit = true;
                        break;
                    default:
                        System.out.println("올바른 번호를 입력해주세요");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("올바른 번호를 입력해주세요");
                sc.nextLine();
            }
            System.out.println("프로그램을 종료합니다.");
        }
    }
}
