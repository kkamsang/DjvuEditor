/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sed.text.parts;

import java.util.ArrayList;

/**
 *
 * @author Administrateur
 */
public class Line extends Part {

    public ArrayList<Part> words  = new ArrayList<Part>();

    public Line(Part parent) {
        super(parent);
    }

    public Line() {}

    @Override
    public void addPart(Part word) {
        words.add(word);
        parts = words;
    }

    @Override
    public String start() {
        return "(line ";
    }

    @Override
    public String end() {
        return ")";
    }
    @Override
    public String save(String res){
        return "\n "+start() + pos.get() +""+ res + end();
        
    }
    public Part getPage(){
        Part page = parent;
        if(! ( page instanceof Page))
            page = parent.getPage();
        return page;
    }

}