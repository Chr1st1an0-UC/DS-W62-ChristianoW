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
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] names = sc.nextLine().split(" ");
        String[] chancesInput = sc.nextLine().split(" ");

        Queue<Student> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int chance = Integer.parseInt(chancesInput[i]);
            queue.add(new Student(names[i], chance));
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

        sc.close();
    }
}