public class Program {
    public static void main(String[] args) {
        if (args.length != 1 || !args[0].startsWith("--count=")) {
            System.out.println("Wrong number of arguments");
            System.exit(-1);
        }
        int count = Integer.parseInt(args[0].substring(8));

        Egg egg = new Egg(count);
        Hen hen = new Hen(count);

        hen.start();
        egg.start();


        try {
            hen.join();
            egg.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < count; i++)
            System.out.println("HUMAN");
    }
}
