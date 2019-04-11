public class Receiver extends Thread {
    Parcel parcel;

    Receiver(Parcel parcel) {
        this.parcel = parcel;
    }

    @Override
    public void run() {
        for (int i = 0; i < parcel.num_of_parcels; i++) {
            parcel.get();
        }
    }
}
