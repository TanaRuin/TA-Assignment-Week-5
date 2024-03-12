import java.util.Scanner;

public class Main {

    public static void towerOfHanoiRecursive(int n, char source, char target, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + target);
            return;
        }
        towerOfHanoiRecursive(n - 1, source, auxiliary, target);
        System.out.println("Move disk " + n + " from " + source + " to " + target);
        towerOfHanoiRecursive(n - 1, auxiliary, target, source);
    }

    public static void towerOfHanoiIterative(int n, char source, char target, char auxiliary) {
        if (n % 2 == 0) {
            char temp = target;
            target = auxiliary;
            auxiliary = temp;
        }
        int totalMoves = (int) Math.pow(2, n) - 1;
        for (int move = 1; move <= totalMoves; move++) {
            if (move % 3 == 1) {
                System.out.println("Move disk " + moveDisk(move) + " from " + source + " to " + target);
            } else if (move % 3 == 2) {
                System.out.println("Move disk " + moveDisk(move) + " from " + source + " to " + auxiliary);
            } else {
                System.out.println("Move disk " + moveDisk(move) + " from " + auxiliary + " to " + target);
            }
        }
    }

    public static int moveDisk(int move) {
        return ((move & move - 1) % 3) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int n = scanner.nextInt();
        System.out.print("Enter 'R' for recursive or 'I' for iterative algorithm: ");
        char choice = scanner.next().toUpperCase().charAt(0);

        if (choice == 'R') {
            System.out.println("\nUsing Recursive Algorithm:");
            towerOfHanoiRecursive(n, 'A', 'C', 'B');
        } else if (choice == 'I') {
            System.out.println("\nUsing Iterative Algorithm:");
            towerOfHanoiIterative(n, 'A', 'C', 'B');
        } else {
            System.out.println("Invalid choice. Please enter 'R' for recursive or 'I' for iterative algorithm.");
        }

        scanner.close();
    }
}
