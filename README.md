# Kiosk

## 개요
이 프로젝트는 간단한 키오스크 애플리케이션을 구현한 코드입니다. 사용자는 카테고리를 선택하고, 메뉴를 추가하거나 장바구니를 확인 및 주문할 수 있습니다. 또한 할인 기능과 장바구니 수정 기능도 포함되어 있습니다.

---

## 주요 기능

### 1. **카테고리 및 메뉴 관리**
- 카테고리는 `FoodType` 열거형을 통해 정의됩니다. (`DRINK`, `BURGER`, `DESSERT`)
- 각 카테고리는 ID와 레이블로 구분됩니다.
- `Menu` 클래스는 메뉴 아이템을 저장하고 관리합니다.

### 2. **장바구니 관리**
- `Cart` 클래스는 메뉴 아이템과 수량을 관리합니다.
- 주요 메서드:
  - `addItem(MenuItem item)`: 장바구니에 아이템 추가
  - `removeItem(int i)`: 특정 아이템을 장바구니에서 제거
  - `showCart()`: 현재 장바구니 상태 출력
  - `getTotalPrice()`: 장바구니 총 가격 계산
  - `clear()`: 장바구니 초기화

### 3. **할인 기능**
- `DiscountType` 열거형을 통해 다양한 할인 타입이 정의됩니다. (`GENERAL`, `STUDENT`, `ARMY`, `PATRIOT`)
- 각 할인 타입은 할인율과 레이블을 가지고 있으며, `applyDiscount(double price)` 메서드를 통해 총 가격에 할인을 적용할 수 있습니다.

### 4. **주문 및 주문 취소**
- `Kiosk` 클래스는 애플리케이션의 핵심 로직을 포함하며, 사용자 입력을 처리하고 주문을 수행합니다.
- 주요 메서드:
  - `order()`: 장바구니를 확인하고 할인 적용 후 주문 완료
  - `orderCancel()`: 진행 중인 주문 취소
  - `removeCart()`: 장바구니에서 아이템 제거

---

## 클래스 및 구조

### 1. **`MenuItem`**
- 메뉴 아이템의 정보를 저장합니다.
- 속성:
  - `FoodType category`: 카테고리
  - `String name`: 메뉴 이름
  - `double price`: 가격
  - `String description`: 설명
- 사용 예시:
```java
MenuItem item = new MenuItem(FoodType.BURGER, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
System.out.println("카테고리: " + item.getCategory() + ", 이름: " + item.getName() + ", 가격: " + item.getPrice());
```

### 2. **`Cart`**
- 사용자 장바구니를 관리하는 클래스입니다.
- 주요 메서드:
  - `addItem(MenuItem item)`: 장바구니에 아이템 추가
  - `removeItem(int i)`: 아이템 제거
  - `showCart()`: 장바구니 상태 출력
  - `getTotalPrice()`: 총 가격 계산

### 3. **`Kiosk`**
- 프로그램의 핵심 로직을 담당하는 클래스입니다.
- 사용자 입력을 처리하고, 메뉴를 선택하거나 장바구니를 수정 및 주문합니다.

### 4. **`Menu`**
- 메뉴 데이터를 저장하고, 카테고리별 메뉴를 관리합니다.
- `loadData()` 메서드를 통해 초기 데이터를 로드합니다.

### 5. **열거형**
- `FoodType`: 음식 카테고리 관리
- `DiscountType`: 할인 유형 관리
- `OrderMenu`: 주문 메뉴 옵션 관리

---

## 데이터 구조

### 예시 메뉴 데이터
`Menu` 클래스의 `loadData()` 메서드에서 초기화됩니다.
```java
addMenu(FoodType.BURGER, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
addMenu(FoodType.DRINK, "콜라", 3.0, "시원한 콜라");
addMenu(FoodType.DESSERT, "아이스크림", 3.0, "시원한 아이스크림");
```

---

## 코드 구조
- **`MenuItem`**: 메뉴 아이템의 정보 클래스
- **`Cart`**: 장바구니 관리 클래스
- **`Menu`**: 메뉴 데이터 관리 클래스
- **`Kiosk`**: 메인 애플리케이션 로직
- **열거형**:
  - `FoodType`: 음식 카테고리 관리
  - `DiscountType`: 할인 정책 관리
  - `OrderMenu`: 주문 메뉴 옵션

