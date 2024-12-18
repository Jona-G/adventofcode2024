import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int num1 = Integer.parseInt(data.substring(0, 5));
                list1.add(num1);

                int num2 = Integer.parseInt(data.substring(8, 13));
                list2.add(num2);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Collections.sort(list1);
        Collections.sort(list2);

        int totalDistance = 0;
        for (int i = 0; i < list1.size(); i++) {
            totalDistance += Math.abs(list1.get(i) - list2.get(i));
        }
        System.out.println(totalDistance);

        int similarityScore = 0;
        for (Integer num1 : list1) {
            int sameNums = 0;
            for (Integer num2 : list2) {
                if (num1.equals(num2)) {
                    sameNums++;
                }
            }
            similarityScore += num1 * sameNums;
        }
        System.out.println(similarityScore);
    }
}