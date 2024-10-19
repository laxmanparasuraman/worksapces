package round__2_Cpaste.jan2024.svblog.set3;

public class rough_patterxo {
    public static void main(String[] args) {
        int N = 6;
        int M = 7;
        printPattern(N, M);
    }

    public static void printPattern(int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 || i == N - 1 || j == 0 || j == M - 1 || (i == N / 2 && j == M / 2)) {
                    System.out.print("X ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
