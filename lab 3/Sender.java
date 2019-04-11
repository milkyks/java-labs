public class Sender extends Thread {
    Parcel parcel;

    Sender(Parcel parcel) {
        this.parcel = parcel;
    }

    @Override
    public void run() {
        for (int i = 0; i < parcel.num_of_parcels; i++) {
            parcel.send();
        }
    }
}

