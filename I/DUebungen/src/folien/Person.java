/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folien;

/**
 *
 * @author jerem
 */
public class Person {
    String firstName;
    String lastName;
    String pathToPicture;

    public Person(String firstName, String lasString, String pathToPicture) {
        this.firstName = firstName;
        this.lastName = lasString;
        this.pathToPicture = pathToPicture;
    }

    @Override
    public String toString() {
        return "{" + firstName + "," + lastName + '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPathToPicture() {
        return pathToPicture;
    }

    public void setPathToPicture(String pathToPicture) {
        this.pathToPicture = pathToPicture;
    }
    
    
    
}
