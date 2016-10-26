/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.util.Comparator;

/**
 *
 * @author PhamTheQuyen
 */
public class SortRowTable {
    
}
class SortRowTableCustomerGroup implements Comparator<Object[]> {

    public int compare(Object[] o1, Object[] o2) {
        if (!o1[2].equals(o2[2])) {
            return 0;
        }
        String age1 = (String) o1[1];
        
        String age2 = (String) o2[1];
        
        if (age1.compareTo(age2) >= 1) {
            return 1;
        } else if (age1.compareTo(age2) == 0) {
            return 0;
        } else {
            return -1;
        }
       
    }
}