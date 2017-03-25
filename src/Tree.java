import java.util.ArrayList;

/**
 * Created by Ramazan on 20.03.2017.
 */
public class Tree {

    public Node buildTree(Node root) {
        LearningSet examples = root.getExamples();
        root.setEntropy(Entropy.calculateEntropy(examples));

        if(root.getEntropy() == 0) {
            int lastIndex = examples.atributeMap.size()-1;
            ArrayList<String> items = (ArrayList<String>) examples.atributeMap.values().toArray()[lastIndex];
            root.getAtribute().setName(items.get(0));
            return root;
        }
        int bestAttributeIndex = getBestAtribute(root);
        if(bestAttributeIndex != -1) {

            String atributeName = (String) examples.atributeMap.keySet().toArray()[bestAttributeIndex];
            int setSize = examples.atributeMap.get(atributeName).size();
            if(root.getAtribute().getName().isEmpty()){
                root.setAtribute(new Atribute(atributeName,atributeName));
            } else {
                root.getAtribute().setName(atributeName);
            }
            root.children = new Node[setSize];
            root.setUsed(true);
            HelloWorld.usedAttributes.add(bestAttributeIndex);
            for (int j = 0; j< setSize; j++) {
                root.children[j] = new Node(subset(root.getExamples(), bestAttributeIndex,j));
                root.children[j].setParent(root);
                String key = (String) examples.atributeMap.keySet().toArray()[bestAttributeIndex];
                root.children[j].getAtribute().setName(examples.atributeMap.get(key).get(j));//possibleValues of beast attribute == leaf names
                root.children[j].getAtribute().setValue(examples.atributeMap.get(key).get(j));//possibleValues of beast attribute == leaf names
            }
            for (int j = 0; j < setSize; j++) {
                buildTree(root.children[j]);
            }
            root.getExamples().setRecords(null);
        }
        else {
            return root;
        }

        return root;
    }

    public int getBestAtribute(Node root){
        int bestAttribute = -1;
        double bestGain = 0;
        LearningSet examples = root.getExamples();
        ArrayList<Record> records = examples.getRecords();

        for(int i = 0; i < examples.atributeMap.size()-1; i++) {
            if(!HelloWorld.isAttributeUsed(i)) {
                double entropy = 0;
                ArrayList<Double> entropies = new ArrayList<Double>();
                ArrayList<Integer> setSizes = new ArrayList<Integer>();
                String key = (String) examples.atributeMap.keySet().toArray()[i];
                int count = examples.atributeMap.get(key).size();
                for(int j = 0; j < count; j++) {
                    LearningSet subset = subset(examples, i, j);
                    setSizes.add(subset.getRecords().size());
                    if(subset.getRecords().size() != 0) {
                        entropy = Entropy.calculateEntropy(subset);
                        entropies.add(entropy);
                    }
                }
                double gain = Entropy.calculateGain(root.getEntropy(), entropies, setSizes, examples.getRecords().size());
                if(gain > bestGain) {
                    bestAttribute = i;
                    bestGain = gain;
                }
            }
        }

        return bestAttribute;
    }

    public LearningSet subset(LearningSet examples, int attr, int valueIndex) {
        LearningSet subset = new LearningSet();
        ArrayList<Record> records = examples.getRecords();
        for(int i = 0; i < records.size(); i++) {
            Record record = records.get(i);
            String key = (String) examples.atributeMap.keySet().toArray()[attr];
            String value1 = record.getAtributes().get(attr).getValue().trim();
            String value2 = examples.atributeMap.get(key).get(valueIndex).trim();
            if(value1.equals(value2)) {
                subset.getRecords().add(record);
            }
        }
        subset.performAtributeMapping();
        return subset;
    }
}
