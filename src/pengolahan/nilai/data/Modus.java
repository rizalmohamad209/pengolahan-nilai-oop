package pengolahan.nilai.data;

public class Modus extends Nilai{
    public int modus(int min, int max){
        int count = 0;
        for (int i = 0; i < getNilai().size(); i++) {
            if (getNilai().get(i) >= min && getNilai().get(i) <= max) {
                count++;
            }
        }
        return count;

    }
}
