public class Table extends Furniture implements Oak {
    @Override
    public  void whoAmI() {
        System.out.println("Table");
    }

    public void oak() {
        System.out.println("I am made from oak");
    }

    public void tree() {
        System.out.println("I am made from tree");
    }
}
