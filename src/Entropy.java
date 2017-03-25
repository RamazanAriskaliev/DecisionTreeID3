import java.util.ArrayList;

/**
 * Created by Ramazan on 20.03.2017.
 */
public class Entropy {

    public static double calculateEntropy(LearningSet examples) {
        double entropy = 0;

        if(examples.records.size() == 0) {
            // nothing to do
            return 0;
        }
        int lastIndex = examples.atributeMap.size()-1;
        ArrayList<String> items = (ArrayList<String>) examples.atributeMap.values().toArray()[lastIndex]; // Get last item of the list, which is the target
        for(int i = 0; i <= items.size(); i++){ // should be 2
            int count = 0;
            for(int j = 0; j < examples.records.size(); j++) { // should 14
                Record record = examples.records.get(j);
                String targetValue = record.getAtributes().get(record.getAtributes().size()-1).getValue();
                if(Integer.parseInt(targetValue) == i) {
                    count++;
                }
            }

            double probability = count / (double)examples.records.size();/*9/14   5/14*/
            if(count > 0) {
                entropy += -probability * (Math.log(probability) / Math.log(2));
            }

        }
        return entropy;

    }

    public static double calculateGain(double rootEntropy, ArrayList<Double> subEntropies, ArrayList<Integer> setSizes, int data) {
        double gain = rootEntropy;

        for(int i = 0; i < subEntropies.size(); i++) {
            gain += -((setSizes.get(i) / (double)data) * subEntropies.get(i));
        }

        return gain;
    }

}
