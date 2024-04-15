import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] array = {"a", "b", "c", "d" };
        revers(array);
        }
            public static void revers(String[] newArray) {
               String [] newRevers = new String[newArray.length];
                for (int i = newArray.length - 1; i >= 0; i--) {
                    newRevers[i] = newArray[newArray.length - 1 - i];
                }
                System.out.println(Arrays.toString(newRevers));
            }
    }
