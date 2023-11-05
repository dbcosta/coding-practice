package practice.cloning;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person implements Cloneable{
    String name;
    int age;
    int height;
    Address address;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        /*Person personClone = (Person) super.clone();
        personClone.setAddress((Address) personClone.getAddress().clone());
        return personClone;*/
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", address=" + address +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person temp = new Person("Sheela",20,5,new Address("302","XYZ","Pune"));
        Person clone = (Person) temp.clone();
        System.out.println(temp.equals(clone));

        Address personalAddress = new Address("C-101","Maple Street","New York");
        Person person = new Person("Roy",10,160,personalAddress);
        System.out.println("Original Person: "+person);

        Person personClone = (Person) person.clone();
        System.out.println("Cloned Person: "+personClone);

        personClone.getAddress().setCity("New Jersey");
        System.out.println("After modifying the city - Original Person: "+person);
        System.out.println("After modifying the city - Cloned Person: "+personClone);
    }
}
