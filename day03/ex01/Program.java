public class Program {
    public static boolean isEggPrinted = false;


    public static synchronized void sayHen() {

        if (isEggPrinted == false) {
            try {
                Program.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Hen");
        isEggPrinted = false;

        Program.class.notify();

    }

    public static synchronized void sayEgg() {

        if (isEggPrinted) {
            try {
                Program.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Egg");
        isEggPrinted = true;

        Program.class.notify();
    }

    public static void main(String[] args) {
        int count = 0;
        if (args[0].substring(0, 8).equals("--count="))
            count = Integer.parseInt(args[0].substring(8));
        Thread hen = new Thread(new Hen(count));
        Thread egg = new Thread(new Egg(count));

        hen.start();
        egg.start();


    }
}
