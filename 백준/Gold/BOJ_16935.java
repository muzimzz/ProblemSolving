    package Gold;

    import java.util.*;
    import java.io.*;

    public class BOJ_16935 {

        static int N, M, R, A;
        static int[][] board;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            board = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            for (int r = 0; r < R; r++) {
                A = Integer.parseInt(st.nextToken());
                N = board.length;
                M = board[0].length;

                if (A == 1) {
                    for (int j = 0; j < M; j++) {
                        int top = 0, bottom = N-1;
                        while (top < bottom) {
                            int temp = board[top][j];
                            board[top][j] = board[bottom][j];
                            board[bottom][j] = temp;
                            top++;
                            bottom--;
                        }
                    } //for
                } else if (A == 2) {
                    for (int i = 0; i < N; i++) {
                        int left = 0, right = M-1;
                        while (left < right) {
                            int temp = board[i][left];
                            board[i][left] = board[i][right];
                            board[i][right] = temp;
                            left++;
                            right--;
                        }
                    } // for
                } else if (A == 3) {
                    int[][] new_board = new int[M][N];
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            new_board[j][N - (i + 1)] = board[i][j];
                        }
                    }
                    board = new_board;
                } else if (A == 4) {
                    int[][] new_board = new int[M][N];
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            new_board[M - (j + 1)][i] = board[i][j];
                        }
                    }
                    board = new_board;
                } else if (A == 5) {
                    int[][] new_board = new int[N][M];
//                  for (int i = 0; i < N; i++) {
//                      for (int j = 0; j < M; j++) {
//                          if (i < N/2 && j < M/2) new_board[i][j+M/2] = board[i][j];
//                          else if (i < N/2 && j < M) new_board[i+N/2][j] = board[i][j];
//                          else if (i < N && j < M/2) new_board[i-N/2][j] = board[i][j];
//                          else new_board[i][j-M/2] = board[i][j];
//                      }
//                  }
                    for (int i = 0; i < N / 2; i++) {
                        for (int j = 0; j < M / 2; j++) {
                            new_board[i][j+M/2] = board[i][j];
                        }
                    }
                    for (int i = 0; i < N / 2; i++) {
                        for (int j = M / 2; j < M; j++) {
                            new_board[i+N/2][j] = board[i][j];
                        }
                    }
                    for (int i = N / 2; i < N; i++) {
                        for (int j = M / 2; j < M; j++) {
                            new_board[i][j-M/2] = board[i][j];
                        }
                    }
                    for (int i = N / 2; i < N; i++) {
                        for (int j = 0; j < M / 2; j++) {
                            new_board[i-N/2][j] = board[i][j];
                        }
                    }
                    board = new_board;
                } else {
                    int[][] new_board = new int[N][M];
//                  for (int i = 0; i < N; i++) {
//                      for (int j = 0; j < M; j++) {
//                          if (i < N/2 && j < M/2) new_board[i+N/2][j] = board[i][j];
//                          else if (i < N/2 && j < M) new_board[i][j-M/2] = board[i][j];
//                          else if (i < N && j < M/2) new_board[i][j+M/2] = board[i][j];
//                          else new_board[i-N/2][j] = board[i][j];
//                      }
//                  }
                    for (int i = 0; i < N / 2; i++) {
                        for (int j = 0; j < M / 2; j++) {
                            new_board[i+N/2][j] = board[i][j];
                        }
                    }
                    for (int i = 0; i < N / 2; i++) {
                        for (int j = M / 2; j < M; j++) {
                            new_board[i][j-M/2] = board[i][j];
                        }
                    }
                    for (int i = N / 2; i < N; i++) {
                        for (int j = M / 2; j < M; j++) {
                            new_board[i-N/2][j] = board[i][j];
                        }
                    }
                    for (int i = N / 2; i < N; i++) {
                        for (int j = 0; j < M / 2; j++) {
                            new_board[i][j+M/2] = board[i][j];
                        }
                    }
                    board = new_board;
                }
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    sb.append(board[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
        }
    }
