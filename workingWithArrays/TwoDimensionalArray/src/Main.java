public class Main {
    public static void main(String[] args) {

        char[][] cross = getTwoDimensionalArray(7);
        for (int row = 0; row < cross.length; row++) {
        for (int cell = 0; cell < cross.length; cell++) {
                System.out.print(cross[row][cell]);
            }
            System.out.println();
        }
    }

    public static char[][] getTwoDimensionalArray(int size) {
        char[][] cross = new char[size][size];
        for (int row = 0; row < cross.length; row++) {
            for (int cell = 0; cell < cross.length; cell++) {
                if (cell == row || cell == cross.length - 1 - row) {
                    cross[row][cell] = 'X';
                } else {
                    cross[row][cell] = ' ';
                }
//                cross[row][cell] = (cell == row || cell == cross.length - 1 - row) ? 'X' : ' '; //можно прописать короче
            }
        }
        return cross;
    }
}