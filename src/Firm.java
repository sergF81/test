import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.function.ToDoubleFunction;

import static java.lang.System.*;

public abstract class Firm {
    public String d = "";
    public double zp = 0;
    public int interns;
    //  public abstract class Emp {



    public void setZP(double zp) {
        this.zp = zp;
    }

    public double getZP() {
        return zp;
    }

    public static class Intern extends Firm {

    }

    public static class ManagerJun extends Firm {

        @Override
        public void setZP(double zp) {
            this.zp = zp + zp * 0.10;
        }

        }
    public static class ManagerMid extends ManagerJun {

        @Override
        public void setZP(double zp) {
            this.zp = zp + zp * 0.20;
        }


    }

    public static class ManagerSin extends ManagerMid {


        //   private int interns;

        //@Override
        public void setZP(double zp, int interns) {

            this.interns = interns;

            if (interns > 0) {
                zp = zp + zp * 0.30;
                this.zp = zp + zp*0.05 * interns;

            } else {

                System.out.println("Этот сотрудник не имеет интернов, его оклад будет как у Мэнеджера Middle.");
                this.zp = zp + zp * 0.20;


            }
        }



    }

    public static class DevJun extends Firm {

        @Override
        public void setZP(double zp) {
            this.zp = zp + zp * 0.10;
        }


    }

    public static class DevMid extends DevJun {

        @Override
        public void setZP(double zp) {
            this.zp = zp + zp * 0.20;
        }


    }

    public static class DevrSin extends DevMid {



        public void setZP(double zp, int interns) {

            this.interns = interns;

            if (interns > 0) {
                zp = zp + zp * 0.30;
                this.zp = zp + zp*0.05 * interns;

            } else {

                System.out.println("Этот сотрудник не имеет интернов, его оклад будет как у Мэнеджера Middle.");
                this.zp = zp + zp * 0.20;


            }
        }

      }


    public static void main(String[] args) throws IOException {
        //int i;

        System.out.println("Укажите какого сотрудника вы нанимаете. Введите i, если это интерн");
        System.out.println("mj - если младший менеджер, mm - если средний менеджер, ms - если старший менеджер");
        System.out.println("dj - если младший разработчик, dm - если средний разработчик, ds - если старший разработчик");
        System.out.println("При выборе ситаршего менеджера или разработчика уважите количество интерном, которые будут в подчинении.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String d = reader.readLine();

        if (d.equals("i")) {
            System.out.println("Вы оперируете с сотрудником - Интерн");
            System.out.println("Введите базовую ставку сотрудника:");
            BufferedReader zpr = new BufferedReader(new InputStreamReader(System.in));
            String d1 = zpr.readLine();
            double zp = Double.parseDouble(d1);
            Intern s = new Intern();
            s.setZP(zp);

            System.out.println("Оклад сотрудника: " + s.getZP());
        }
        if (d.equals("mj")) {
            System.out.println("Вы оперируете с сотрудником - Младший Менеджер");
            System.out.println("Введите базовую ставку сотрудника:");
            BufferedReader zpr = new BufferedReader(new InputStreamReader(System.in));
            String d1 = zpr.readLine();
            double zp = Double.parseDouble(d1);
            ManagerJun s = new ManagerJun();
            s.setZP(zp);

            System.out.println("Оклад сотрудника: " + s.getZP());

        }
        if (d.equals("mm")) {
            System.out.println("Вы оперируете с сотрудником - Средний Менеджер");
            System.out.println("Введите базовую ставку сотрудника:");
            BufferedReader zpr = new BufferedReader(new InputStreamReader(System.in));
            String d1 = zpr.readLine();
            double zp = Double.parseDouble(d1);
            ManagerMid s = new ManagerMid();
            s.setZP(zp);

            System.out.println("Оклад сотрудника: " + s.getZP());

        }
        if (d.equals("ms")) {
            System.out.println("Вы оперируете с сотрудником - Старший Менеджер");

            System.out.println("Введите количество интернов у данного сотруника: ");

            BufferedReader kol = new BufferedReader(new InputStreamReader(System.in));
            d = kol.readLine();
            int interns = Integer.parseInt(d);

            System.out.println("Введите базовую ставку сотрудника:");
            BufferedReader zpr = new BufferedReader(new InputStreamReader(System.in));
            String d1 = zpr.readLine();
            double zp = Double.parseDouble(d1);
            ManagerSin s = new ManagerSin();
            s.setZP(zp, interns);

            System.out.println("Оклад сотрудника: " + s.getZP());

        }
        if (d.equals("dj")) {
            System.out.println("Вы оперируете с сотрудником - Младший Разработчик");
            System.out.println("Введите базовую ставку сотрудника:");
            BufferedReader zpr = new BufferedReader(new InputStreamReader(System.in));
            String d1 = zpr.readLine();
            double zp = Double.parseDouble(d1);
            ManagerJun s = new ManagerJun();
            s.setZP(zp);

            System.out.println("Оклад сотрудника: " + s.getZP());

        }
        if (d.equals("dm")) {
            System.out.println("Вы оперируете с сотрудником - Средний Разработчик");
            System.out.println("Введите базовую ставку сотрудника: ");
            BufferedReader zpr = new BufferedReader(new InputStreamReader(System.in));
            String d1 = zpr.readLine();
            double zp = Double.parseDouble(d1);
            ManagerMid s = new ManagerMid();
            s.setZP(zp);

            System.out.println("Оклад сотрудника: " + s.getZP());

        }
        if (d.equals("ds")) {
            System.out.println("Вы оперируете с сотрудником - Старший Разработчик");

            System.out.println("Введите количество интернов у данного сотруника: ");

            BufferedReader kol = new BufferedReader(new InputStreamReader(System.in));
            d = kol.readLine();
            int interns = Integer.parseInt(d);

            System.out.println("Введите базовую ставку сотрудника:");
            BufferedReader zpr = new BufferedReader(new InputStreamReader(System.in));
            String d1 = zpr.readLine();
            double zp = Double.parseDouble(d1);
            ManagerSin s = new ManagerSin();
            s.setZP(zp, interns);

            System.out.println("Оклад сотрудника: " + s.getZP());

        }

    }

}