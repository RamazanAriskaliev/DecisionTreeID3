import com.google.gson.Gson;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Created by Ramazan on 17.03.2017.
 */
public class HelloWorld {

    public static ArrayList<Integer> usedAttributes = new ArrayList<Integer>();
    public static void main(String[] args) {
        LearningSet examples = SQLHelper.getData();
        Node root = new Node(examples);
        Tree tree = new Tree();
        tree.buildTree(root);
        root.print(1,"");

        Gson g = new Gson();
        System.out.println(g.toJson(root));
    }


    public static boolean isAttributeUsed(int attribute) {
        if(usedAttributes.contains(attribute)) {
            return true;
        }
        else {
            return false;
        }
    }
}
