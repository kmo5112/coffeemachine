import java.util.Scanner;
public class CoffeeMachine {

    static Scanner scanner = new Scanner(System.in);
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;

    public CoffeeMachine(){

    }

    public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public void setDisposableCups(int disposableCups) {
        this.disposableCups = disposableCups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public static void CoffeeMachineStatus(CoffeeMachine coffeeMachine){
        System.out.println("현재 커피머신 상태:");
        System.out.println("남은 재료와 돈 상태");
        System.out.println("물 : " + coffeeMachine.getWater() + "ml");
        System.out.println("우유 : " + coffeeMachine.getMilk() + "ml");
        System.out.println("원두 : " + coffeeMachine.getCoffeeBeans() +"g");
        System.out.println("일회용 컵 : " + coffeeMachine.getDisposableCups() + "개");
        System.out.println("돈 : " + coffeeMachine.getMoney() + "원");
    }

    public static void buy(CoffeeMachine coffeeMachine){
        System.out.println("어떤 커피를 구매하시겠습니까? 1.에스프레소 2.라떼 3.카푸치노");
        String inputValue = scanner.nextLine();

        switch(inputValue){
            case "1" :
                System.out.println(checkWhatIsNotEnough(coffeeMachine, new Espresso()));
                break;
            case "2" :
                System.out.println(checkWhatIsNotEnough(coffeeMachine, new Latte()));
                break;
            case "3" :
                System.out.println(checkWhatIsNotEnough(coffeeMachine, new Cappuccino()));
            case "back":
                break;
        }
    }

    public static String checkWhatIsNotEnough(CoffeeMachine coffeeMachine, Coffee coffee){
        if(coffeeMachine.getWater() < coffee.getWater()){
            return "물이 부족합니다.";
        }else if(coffeeMachine.getMilk() < coffee.getMilk()){
            return "우유가 부족합니다.";
        }else if(coffeeMachine.getCoffeeBeans()<coffee.getCoffeeBeans()){
            return "원두가 부족합니다.";
        }else if(coffeeMachine.getDisposableCups() < 1){
            return "일회용 컵이 부족합니다.,";
        }else {
            coffeeMachine.setWater(coffeeMachine.getWater() - coffee.getWater());
            coffeeMachine.setMilk(coffeeMachine.getMilk() - coffee.getMilk());
            coffeeMachine.setCoffeeBeans(coffeeMachine.getCoffeeBeans() - coffee.getCoffeeBeans());
            coffeeMachine.setDisposableCups(coffeeMachine.getDisposableCups() - 1);
            coffeeMachine.setMoney(coffeeMachine.getMoney() + coffee.getMoney());
            return "재료가 충분합니다. 커피를 만들어 드릴게요!";
        }
    }

    public static void fill(CoffeeMachine coffeeMachine){
        System.out.println("추가할 물의 양을 입력하세요 ");
        coffeeMachine.setWater(scanner.nextInt() + coffeeMachine.getWater());
        System.out.println("추가할 우유의 양을 입력하세요 ");
        coffeeMachine.setMilk(scanner.nextInt() +  coffeeMachine.getMilk());
        System.out.println("추가할 원두의 양을 입력하세요 ");
        coffeeMachine.setCoffeeBeans(scanner.nextInt() + coffeeMachine.getCoffeeBeans());
        System.out.println("추가할 일회용 컵의 양을 입력하세요 ");
        coffeeMachine.setDisposableCups(scanner.nextInt() + coffeeMachine.getDisposableCups());

    }

    public static void take(CoffeeMachine coffeeMachine){
        System.out.println("돈을 꺼내기 : " + coffeeMachine.getMoney());
        coffeeMachine.setMoney(0);
    }


}
