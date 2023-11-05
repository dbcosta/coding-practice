package practice.cloning;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@ToString
public class Address /*implements Cloneable*/{
    String houseNo;
    String street;
    String city;

    /*protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }*/
}
