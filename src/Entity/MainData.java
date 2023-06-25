package Entity;

import javax.swing.JTable;

/**
 *
 * @author Ahmed
 */
public interface MainData {

    public void add();

    public void update();

    public void delete();

    public String getAutoNumber();

    public void getAllRows(JTable Table);

    public void getOneRow(JTable Table);
    
    public void filter(String Query,JTable Table);
    
    public String getValue(String name);
    
    public String getName(String value);
    
    

}
