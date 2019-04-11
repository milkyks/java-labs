import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*if (args.length == 0) {
            System.out.println("You haven't written any number!");
            return;
        }

        char[] symbols = args[0].toCharArray();*/
        if (args.length > 1) {
            System.out.println("You are allowed to write only one parameter!");
            return;
        }
        /*else {
            for (int i = 0; i < args[0].length(); i++) {
                if (!(symbols[i] >= '0' && symbols[i] <= '9')) {
                    System.out.println("You should write only numbers!");
                    return;
                }
            }
        }*/

        try {
            int num = Integer.parseInt(args[0]);
            Tree[] trees = new Tree[num];

            int random_value;
            for (int i = 0; i < num; i++) {
                Random random = new Random();
                random_value = random.nextInt(2);
                if (random_value == 0) {
                    trees[i] = new Chair();
                } else {
                    trees[i] = new Table();
                }
            }

            for (int i = 0; i < num; i++) {
                if (trees[i] instanceof Oak) {
                    Table table = (Table)trees[i];
                    System.out.println("Name of the class is Table!");
                    System.out.print("Name of its first method is oak: ");
                    table.oak();
                    System.out.print("Name of its second method is whoAmI: ");
                    table.whoAmI();
                    System.out.print("Name of its third method is tree: ");
                    table.tree();
                    System.out.println("__________________________________");
                } else {
                    Chair chair = (Chair)trees[i];
                    System.out.println("Name of the class is Chair!");
                    System.out.print("Name of its first method is whoAmI: ");
                    chair.whoAmI();
                    System.out.print("Name of its second method is tree: ");
                    chair.tree();
                    System.out.println("__________________________________");
                }
            }
        }

        catch(Exception ex) {
            System.out.println("Your parameter isn't correct!");
        }
    }
}
