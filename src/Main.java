public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\SheCanCode\\Desktop\\AverageAgeAssignment\\src\\people.csv";
        try {
            double avg = CSVStreamProcessor.calculateAverageAge(path);
            System.out.printf("Average Age: %.2f%n", avg);
        }catch (Exception e){
            System.out.println("Error reading or processing file:");
            e.printStackTrace();
        }
    }
}