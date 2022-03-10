package pengolahan.nilai.data;


import java.util.HashMap;

public class HitungAction extends Nilai implements Hitung {
    @Override
    public float mean() {
        float mean = 0;
        for(int i =0;i< getNilai().size();i++){
            mean += getNilai().get(i);
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

            median = ((double) sumOfMiddleElements) / 2;
        } else {

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

    @Override
    public HashMap<Integer, Integer> modusSoal1() {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < getNilai().size(); i++) {
            if (map.containsKey(getNilai().get(i))) {
                int n = map.get(getNilai().get(i)) + 1;
                map.put(getNilai().get(i), n);
            } else {
                map.put(getNilai().get(i), 1);
            }
        }
        return map;
    }


}
