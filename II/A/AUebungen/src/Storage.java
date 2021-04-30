/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jerem
 */
public class Storage {
    Object element;
    
    public synchronized Object speichernUndNehmen(Object e){
        if(element == null && e != null){
            element = e;
        }else if(e == null && element != null){
            Object help = element;
            element = null;
            return help;
        }
        return "nixdrinnen";
    }
    
}
