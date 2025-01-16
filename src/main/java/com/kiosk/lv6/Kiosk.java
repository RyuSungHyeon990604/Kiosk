package com.kiosk.lv6;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private final Menu menu = new Menu();
    private final Scanner sc = new Scanner(System.in);
    private final Cart cart = new Cart();
    private int foodTypeSize;
    private int orderMenuSize;

    public void start() {
        menu.loadData();
        foodTypeSize = FoodType.values().length;
        orderMenuSize = OrderMenu.values().length;
        while (true) {
            //햄버거, 음료수, 디저트 .. 카테고리 선택
            displayCategory();
            int selected = selectCategoryOrOrderMenu();
            if (selected == 0) break;
            if (isSelectOrderMenu(selected)) {//OrderMenu 를 선택했다면
                if (selected == OrderMenu.Order.getId()) order();
                else if (selected == OrderMenu.Cancel.getId()) orderCancel();
                else if (selected == OrderMenu.Remove.getId()) removeCart();
                continue;
            }
            FoodType selectedFoodType = FoodType.getCategory(selected);

            //카테고리의 세부 메뉴 선택
            List<MenuItem> menus = menu.getMenuList(selectedFoodType);
            if (menus.isEmpty()) {
                System.out.println("메뉴가 없습니다.");
                continue;
            }
            displayMenuItems(menus);
            int selectedMenuItemNumber = selectMenuItemNumber(menus);
            if (selectedMenuItemNumber == 0) break;
            MenuItem selectedMenuItem = menus.get(selectedMenuItemNumber - 1);
            System.out.printf("선택한 메뉴 : %s\n", selectedMenuItem);

            //장바구니
            int confirm = confirm("위 메뉴를 장바구니에 추가하시겠습니까?\n");
            if (confirm == 1) {
                System.out.printf("\n'%s'를 장바구니에 담았습니다\n\n", selectedMenuItem);
                cart.addItem(selectedMenuItem);
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    /**
     * <pre>음식 카테고리 출력함.</pre>
     * <pre>장바구니의 상태에따라 출력범위를 ORDER MENU까지 확장</pre>
     */
    public void displayCategory() {
        System.out.println("=====[ MAIN MENU ]=====");
        FoodType[] categories = FoodType.getAll();
        int i = 0;
        for (; i < categories.length; i++) {
            System.out.println(categories[i].getId() + ". " + categories[i].getLabel());
        }
        if (!cart.isEmpty()) {
            OrderMenu[] orderMenus = OrderMenu.values();
            System.out.println("[ ORDER MENU ]");
            for (i = 0; i < orderMenus.length; i++) {
                System.out.println(orderMenus[i].getId()+". "+orderMenus[i].getName() + "    |" + orderMenus[i].getDescription());
            }
        }
        System.out.printf("%d. %s\n", 0, "종료");
        System.out.println("=======================");
    }

    /**
     * <pre>카테고리번호를 입력받는 함수</pre>
     * <pre>장바구니의 상태에따라 입력받는 정수의 범위를 ORDER MENU까지 확장</pre>
     * @return 카테고리 or ORDERMENU 번호
     */
    public int selectCategoryOrOrderMenu() {
        int id = getInputNumber();
        while ((cart.isEmpty() && (id < 0 || id > foodTypeSize))
                || (!cart.isEmpty() && (id < 0 || id > foodTypeSize + orderMenuSize))
        ) {
            System.out.println("올바른 번호를 선택해주세요");
            id = getInputNumber();
        }
        return id;
    }

    public void displayMenuItems(List<MenuItem> menuItems) {
        System.out.println("==========================[ " + menuItems.get(0).getCategory().getLabel() + " MENU ]==========================");
        int n = 0;
        for (MenuItem item : menuItems) {
            System.out.printf("%2d. %s\n", ++n, item.toString());
        }
        System.out.printf("%2d.%14s\n", 0, "종료");
        System.out.println("====================================================================");
    }

    public int selectMenuItemNumber(List<MenuItem> menuItems) {
        int choice = getInputNumber();
        if (choice == 0) return choice;
        while (choice > menuItems.size() || choice < 0) {
            System.out.println("올바른 메뉴를 선택해주세요");
            choice = getInputNumber();
        }
        return choice;
    }

    /**
     * 숫자입력 받는 함수
     * @return 입력한 숫자
     */
    public int getInputNumber() {
        int res;
        try {
            res = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요");
            sc.nextLine();
            res = getInputNumber();
        }
        return res;
    }

    /**
     * 확인창 함수
     * @param msg
     * @return 1(true) or 2(false)
     */
    public int confirm(String msg) {
        System.out.print(msg);
        System.out.println("1. 확인        2. 취소");
        int num = getInputNumber();
        while (num != 1 && num != 2) {
            System.out.println("1 또는 2번을 선택해주세요");
            num = getInputNumber();
        }
        return num;
    }

    /**
     * OREDER MENU의 선택여부를 판단하는 함수
     * @param selected
     * @return true | false
     */
    public boolean isSelectOrderMenu(int selected) {
        return !cart.isEmpty() && (selected > foodTypeSize && selected <= foodTypeSize+orderMenuSize);
    }

    public void order() {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("[ Orders ]");
        cart.showCart();

        double totalPrice = cart.getTotalPrice();
        System.out.println("[ Total ]");
        System.out.println(totalPrice * 1000);

        int confirm = confirm("");
        if (confirm == 2) {
            return;
        }
        //할인로직
        System.out.println("할인정보를 입력해주세요");
        DiscountType[] discountTypes = DiscountType.values();
        for (int i = 0; i < discountTypes.length; i++) {
            System.out.println(i + 1 + ". " + discountTypes[i].getLabel() + " : " + discountTypes[i].getDiscountRate() + "%");
        }
        int choice = getInputNumber();
        while (choice <= 0 || choice > discountTypes.length) {
            System.out.println("올바른 번호를 입력해주세요");
            choice = getInputNumber();
        }
        DiscountType selectedDiscountType = discountTypes[choice - 1];
        double finalPrice = selectedDiscountType.applyDiscount(totalPrice);

        System.out.println("주문이 완료외었습니다. 금액은 " + finalPrice * 1000 + "입니다.");
    }

    public void removeCart(){
        System.out.println("[ Orders ]");
        cart.showCart();

        System.out.println("삭제할 메뉴를 선택해주세요");
        int remove = getInputNumber();
        while(remove < 1 || remove > cart.getSize()){
            System.out.println("올바른 번호를 입력해주세요");
            remove = getInputNumber();
        }
        MenuItem removedItem = cart.removeItem(remove-1);
        System.out.println(removedItem.getName()+"1개를 장바구니에서 제거했습니다.");
    }

    public void orderCancel() {
        cart.clear();
        System.out.println("주문을 취소합니다");
    }
}
