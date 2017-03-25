import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Created by Ramazan on 20.03.2017.
 */
@XmlRootElement
public class Atribute { // represents matrix column
    private String name;
    private String value;

    public Atribute() {
    }

    public Atribute(String columnName, String string) {
        name = columnName;
        value = string;
    }

    public Atribute(String columnName) {
        name = columnName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
