import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Ramazan on 20.03.2017.
 */
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LearningSet{

    @XmlElement
    ArrayList<Record> records;
    Map<String, ArrayList<String>> atributeMap; /*atributeName{value1,value2,value3,...}*/

    public LearningSet() {
        this.records = new ArrayList<>();
        this.atributeMap = new LinkedHashMap();
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Record> records) {
        this.records = records;
    }

    public void display(){
        String result = String.join(",", atributeMap.keySet());
        System.out.println(result);
    }

    public void performAtributeMapping() {

        for(int j =0; j < records.get(0).atributes.size(); j++){
            ArrayList<String> possibleAtributes = new ArrayList<>();
            String key ="";
            for (int i = 0; i < records.size(); i++) {
                ArrayList<Atribute> atributes = records.get(i).getAtributes();
                Atribute atribute = atributes.get(j);
                key = atribute.getName();
                if (!possibleAtributes.contains(atribute.getValue())){
                    possibleAtributes.add(atribute.getValue());
                }
            }
            atributeMap.put(key, possibleAtributes);
        }
    }
}
