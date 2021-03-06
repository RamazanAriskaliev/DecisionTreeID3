import java.io.Serializable;
import java.util.Map;

/**
 * Created by Ramazan on 20.03.2017.
 */
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Node{
    @XmlElement
    public Node parent;

    @XmlElement
    public Map<String, Node> children;

    @XmlElement
    public LearningSet examples;

    public double entropy;
    public boolean isUsed;
    private Atribute atribute;

    public Node() {
        setExamples(null);
        setEntropy(0.0);
        setParent(null);
        setChildren(null);
        setUsed(false);
        atribute = new Atribute("","");
    }

    public Node(LearningSet learningSet) {
        this.examples = learningSet;
        setEntropy(0.0);
        setParent(null);
        setChildren(null);
        setUsed(false);
        atribute = new Atribute("","");
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Map<String, Node> getChildren() {
        return children;
    }

    public void setChildren(Map<String, Node> children) {
        this.children = children;
    }

    public LearningSet getExamples() {
        return examples;
    }

    public void setExamples(LearningSet examples) {
        this.examples = examples;
    }

    public double getEntropy() {
        return entropy;
    }

    public void setEntropy(double entropy) {
        this.entropy = entropy;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public Atribute getAtribute() {
        return atribute;
    }

    public void setAtribute(Atribute atribute) {
        this.atribute = atribute;
    }


    public void print(int level, String edgeName) {
        for (int i = 1; i < level; i++) {
            System.out.print("\t");
        }

        System.out.println((edgeName.equals("")?"":edgeName+":")+atribute.getName()+ (atribute.getValue()==null? "" :(":"+ atribute.getValue())));
        if(children != null){
            for (String edge : children.keySet()) {
                children.get(edge).print(level + 1, edge);
            }
        }

    }

}
