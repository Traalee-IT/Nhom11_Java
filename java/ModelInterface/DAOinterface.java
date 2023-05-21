package ModelInterface;

import java.util.ArrayList;

import Model.Thisinh;

public interface DAOinterface<T> {
    public int insert(T t);
    public int upDATE(T t);
    public int delete(T t);
    public ArrayList<T> selectAll();	
    public T slectByid(String t);
    // tuc la sau cai T laf sinh viên thi cái Arralist có kiẻu dữ liệu laf sinh viên 
    // Và bản cháta .. DAOinterface<T>.=Araylist<T>
    public ArrayList<T> selectByCondition(String condition);

}
