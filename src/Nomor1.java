import java.util.*;

public class Nomor1 {

    static class Letter {
        String name;
        int duration;
        int priority;
        int finishTime;

        Letter(String name, int duration, int priority) {
            this.name = name;
            this.duration = duration;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int n = sc.nextInt();
            sc.nextLine();

            List<Letter> pending = new ArrayList<>();
            List<Letter> queued = new ArrayList<>();
            List<Letter> sent = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String name = sc.next();
                int duration = sc.nextInt();
                int priority = sc.nextInt();

                pending.add(new Letter(name, duration, priority));
            }

            // sort berdasarkan priority (ascending)
            pending.sort(Comparator.comparingInt(a -> a.priority));

            int time = 0;

            while (!pending.isEmpty() || !queued.isEmpty()) {

                // pindahkan dari pending ke queue
                if (!pending.isEmpty()) {
                    Letter l = pending.remove(0);
                    l.finishTime = time + l.duration;
                    queued.add(l);
                }

                // cek apakah ada yang selesai
                Iterator<Letter> it = queued.iterator();
                while (it.hasNext()) {
                    Letter l = it.next();
                    if (l.finishTime <= time) {
                        sent.add(l);
                        it.remove();
                    }
                }

                // print state
                System.out.print(time + " ");

                printNames(pending);
                System.out.print("| ");
                printNames(queued);
                System.out.print("| ");
                printNames(sent);

                System.out.println();

                time++;
            }
        }
    }

    static void printNames(List<Letter> list) {
        for (Letter l : list) {
            System.out.print(l.name + " ");
        }
    }
}