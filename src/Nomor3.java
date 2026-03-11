import java.util.*;

public class Nomor3 {

    static class Student {
        String name;
        int chance;

        Student(String name, int chance) {
            this.name = name;
            this.chance = chance;
        }
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int n = sc.nextInt();
            sc.nextLine();

            // Constraint: 5 < line < 20
            if (n < 5 || n > 20) {
                System.out.println("Invalid queue length (must be between 5 and 20)");
                return;
            }

            String[] names = sc.nextLine().split(" ");
            String[] chanceInput = sc.nextLine().split(" ");

            Queue<Student> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {

                String name = names[i];
                int chance = Integer.parseInt(chanceInput[i]);

                // Constraint: chance 1–10
                if (chance < 1 || chance > 10) {
                    System.out.println("Invalid chance value (must be between 1 and 10)");
                    return;
                }

                queue.add(new Student(name, chance));
            }

            while (!queue.isEmpty()) {

                Student current = queue.poll();
                current.chance--;

                if (current.chance > 0) {
                    System.out.println(current.name + "|Try Again|" + current.chance);
                    queue.add(current);
                } else {
                    System.out.println(current.name + "|Get Out|0");
                }
            }
        }
    }
}