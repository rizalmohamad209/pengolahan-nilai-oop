package pengolahan.nilai.data;

public class HitungAction extends Nilai implements Hitung {
    @Override
    public double mean() {
        double mean = 0;
        for(Integer s :  getNilai()){
            mean += getNilai().get(s);
        }
        return mean / getNilai().size();
    }

    @Override
    public double median() {
        double median;

        int totalElements = getNilai().size();
        if (totalElements % 2 == 0) {
            int sumOfMiddleElements = getNilai().get(totalElements / 2) +
                    getNilai().get(totalElements / 2 - 1);
            // calculate average of middle elements
            median = ((double) sumOfMiddleElements) / 2;
        } else {
            // get the middle element
            median = (double) getNilai().get(getNilai().size() / 2);
        }
        return median;
    }

    @Override
    public int modusSoal2() {
        int maxValue = 0, maxCount = 0;

        for(int i=0; i< getNilai().size(); ++i)
        {
            int count=0;

            for(int j=0; j< getNilai().size(); ++j)
            {
                if(getNilai().get(j) == getNilai().get(i))
                {
                    ++count;
                }

                if(count > maxCount)
                {
                    maxCount = count;
                    maxValue = getNilai().get(i);
                }
            }
        }

        return maxValue;

    }


}
