import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CoffeeMachine defaulCoffeeMachine = new CoffeeMachine(400, 540, 120, 9, 50000);

        boolean exit = false;
        String inputValue = "";
        while(!exit){
            System.out.println("옵션을 선택하세요( 1. 구매 2. 채우기 3. 가져가기 4. 남은 재료와 돈상태 5. 종료 )");
            inputValue = scanner.nextLine();

            if(inputValue.equals("1")){
                CoffeeMachine.buy(defaulCoffeeMachine);
            }else if(inputValue.equals("2")){
                CoffeeMachine.fill(defaulCoffeeMachine);
            }else if(inputValue.equals("3")){
                CoffeeMachine.take(defaulCoffeeMachine);
            }else if(inputValue.equals("4")){
                CoffeeMachine.CoffeeMachineStatus(defaulCoffeeMachine);
            }else if(inputValue.equals("5")){
                exit = true;
                System.out.println("커피머신이 종료되었습니다.");
            }
        }
    }
}