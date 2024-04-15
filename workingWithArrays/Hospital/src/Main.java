import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        float[] patientsTemperatures = generatePatientsTemperatures(20);
        System.out.println(getReport(patientsTemperatures));

    }

    static float min = 32;
    static float max = 40;
    int countPatient = 0;

    static float minTempHealthyPatient = 36.2F;
    static float maxTempHealthyPatient = 36.9F;

    public static float[] generatePatientsTemperatures(int countPatient) {
        float[] patientsTemperatures = new float[countPatient];
        for (int i = 0; i < patientsTemperatures.length; i++) {
            patientsTemperatures[i] = (float) ((Math.random() * ((max - min) - 1) + min));  //случайные числа в заданном диапазоне

//            System.out.println(array[i]); // проверка
        }
        return patientsTemperatures;
    }

    public static String getReport(float[] temp) {
        String patientTemp = Arrays.toString(temp); // список температур пациентов
        float averageTemp = 0; // средняя арифмитическая температура
        int countHealthy = 0; // количество здоровых пациентов


        if (temp.length > 0) {
            float sum = 0;
            for (int i = 0; i < temp.length; i++) {
                sum += temp[i];
            }
            averageTemp = sum / temp.length;
        }

        for (int j = 0; j < temp.length; j++) {
            if (temp[j] > minTempHealthyPatient && temp[j] < maxTempHealthyPatient) {
                countHealthy++;
            }
        }
        return  "Список температур пациентов: " + patientTemp + '\n' +
                "Средняя арифмитическая температура: " + averageTemp + '\n' +
                "Количество здоровых пациентов: " + countHealthy;
    }
}