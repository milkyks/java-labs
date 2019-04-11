public class Parcel {
    public int num_of_parcels;
    private int counter_of_parcels = 0;
    private int parcel = 0;

    public synchronized void get() {
        while (parcel < 1) {
            try {
                wait();
            }
            catch (InterruptedException err) {
                System.out.println("Some error has occured with getting a parcel");
            }
        }

        parcel--;

        System.out.println("Name of the thread is Receiver");
        System.out.println("Number of the parcel is " + counter_of_parcels);
        notify();
    }

    public synchronized void send() {
        while (parcel > 0) {
            try {
                wait();
            }
            catch (InterruptedException err) {
                System.out.println("Some error has occured with sending a parcel");
            }
        }
        parcel++;
        System.out.println("Name of the thread is Sender");
        counter_of_parcels++;
        System.out.println("Number of the parcel is " + counter_of_parcels);
        notify();
    }
}
