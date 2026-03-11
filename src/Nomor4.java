import java.util.*;

public class Nomor4 {

    static class Visitor {
        String name;
        int money;

        Visitor(String name, int money) {
            this.name = name;
            this.money = money;
        }
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int n;

            // retry input jumlah visitor
            while (true) {
                n = sc.nextInt();
                sc.nextLine();

                if (n > 1 && n < 1000) break;
                System.out.println("Invalid number of visitors");
            }

            String[] names = sc.nextLine().split(", ");
            String[] moneyInput = sc.nextLine().split(", ");

            List<Visitor> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                String name = names[i];

                // kick Jeff
                if (name.equalsIgnoreCase("Jeff")) continue;

                int money = Integer.parseInt(moneyInput[i]);

                if (money <= 1 || money >= 100) {
                    System.out.println("Invalid money value");
                    return;
                }

                list.add(new Visitor(name, money));
            }

            // sort berdasarkan uang (descending)
            list.sort((a, b) -> b.money - a.money);

            Queue<String> queue = new LinkedList<>();

            for (Visitor v : list) {
                queue.add(v.name);
            }

            System.out.print("[");

            while (!queue.isEmpty()) {
                System.out.print(queue.poll());
                if (!queue.isEmpty()) System.out.print(", ");
            }

            System.out.println("]");
        }
    }
}