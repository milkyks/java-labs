public class Main {
    static public void main(String[] args) {

        if (args.length > 1) {
            System.out.println("You are allowed to write only one parameter!");
            return;
        }

        try {
            Parcel parcel = new Parcel();
            Sender sender = new Sender(parcel);
            Receiver receiver = new Receiver(parcel);

            parcel.num_of_parcels = Integer.parseInt(args[0]);

            sender.start();
            receiver.start();
        }
        catch (Exception err) {
            System.out.println("Your parameter isn't correct!");
        }
    }
}

