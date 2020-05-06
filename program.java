import java.util.*;

public class program {
    public static void main(String[] args) {
        List<Float> varPav = new ArrayList<Float>();
        List<Float> varVar = new ArrayList<Float>();
        float mesX, mesY;
        List<Float> xKat = new ArrayList<Float>();
        List<Float> YKat = new ArrayList<Float>();
        List<Float> xy = new ArrayList<Float>();

        System.out.println("ne fillim variablat e varura - pavarura");

        Scanner in = new Scanner(System.in);
        while (in.hasNextFloat()) {
            float elem = in.nextFloat();
            varPav.add(elem);
            float elem2 = in.nextFloat();
            varVar.add(elem2);
        }
        float sumX = 0;
        for (float i : varPav) {
            sumX += i;
            System.out.print(i + "|");
            float elem = (float) Math.pow(i, 2);
            xKat.add(elem);
        }

        System.out.println("--------------------------------");

        float sumY = 0;
        for (float i : varVar) {
            sumY += i;
            System.out.print(i + "|");
            float elem = (float) Math.pow(i, 2);
            YKat.add(elem);
        }

        System.out.println("--------------------------------");
        float sumxKat = 0;
        for (float i : xKat) {
            sumxKat += i;
            System.out.print(i + "|");

        }

        System.out.println("--------------------------------");
        float sumyKat = 0;
        for (float i : YKat) {
            sumyKat += i;
            System.out.print(i + "|");

        }

        System.out.println("--------------------------------");
        float sumxy = 0;
        for (int i = 0; i < varPav.size(); i++) {
            xy.add(varPav.get(i) * varVar.get(i));
            sumxy += xy.get(i);
            System.out.print(xy.get(i) + "|");
        }
        System.out.println();
        in.close();

        // ================================//
        mesX = sumX / varPav.size();
        mesY = sumY / varPav.size();
        System.out.println("Shuma e x: " + sumX);
        System.out.println("Shuma e Y: " + sumY);
        System.out.println("Mes e x: " + mesX);
        System.out.println("Mes e y: " + mesY);
        System.out.println("Shuma e x^2: " + sumxKat);
        System.out.println("Shuma e y^2: " + sumyKat);
        System.out.println("Shuma e xy: " + sumxy);
        // ================================//

        float b1 = (sumxy - (sumX * sumY) / varPav.size()) / (sumxKat - (float) Math.pow(sumX, 2) / varPav.size());
        System.out.println("b1: " + b1);

        float b0 = mesY - b1 * mesX;
        System.out.println("b0: " + b0);

        System.out.println("Ekuacion i regresit: " + b0 + " " + b1 + "xi");

        // ================================//
        float sst = 0;
        for (float i : varVar) {
            sst += Math.pow(i - mesY, 2);
        }

        float ssr = 0;
        for (float i : varVar) {
            ssr += ((b0 + b1 * i) - mesY) * ((b0 + b1 * i) - mesY);
        }
        System.out.println("SST: " + sst);
        System.out.println("SSR: " + ssr);

        System.out.println("Koeficenti i percaktueshmerise: " + ssr / sst);
    }
}