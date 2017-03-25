import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Ramazan on 20.03.2017.
 */
@XmlRootElement
public class Record { // represents each row of the table
    @XmlElement
    ArrayList<Atribute> atributes;

    public Record() {
        this.atributes = new ArrayList<>();
    }

    public ArrayList<Atribute> getAtributes() {
        return atributes;
    }

    public void setAtributes(ArrayList<Atribute> atributes) {
        this.atributes = atributes;
    }


}
