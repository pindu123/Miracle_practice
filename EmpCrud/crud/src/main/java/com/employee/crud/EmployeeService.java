package com.employee.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    JdbcTemplate jd ;

    public int insertData(Employee e)
    {

     String fn=e.getFname();
     String ln=e.getLname();
   
      
     String wm=fn.substring(0,1)+ln +"@miraclesoft.com";
     String pswd=fn.substring(fn.length()-2,fn.length()-1).toUpperCase()+fn.substring(fn.length()-1)+"#"+ln.substring(ln.length()-2);   
     String s="insert into Employee(Fname,Lname,Department,Phno,gmail,Workmail,pswd,Work_loc,pincode,salary) values(?,?,?,?,?,?,concat(?,DATE_FORMAT(CURRENT_TIMESTAMP, '%H.%i')),?,?,?)";
    
    int i=jd.update(s,fn,ln,e.getDpt(),e.getPhno(),e.getGmail(),wm,pswd,e.getWorklocation(),e.getPincode(),e.getSalary());

    return i;
     
    }

    public List RetriveData(Employee e)
    {
        int id=e.getId();
        String fn=e.getFname();
        String ln=e.getLname();
        String dpt=e.getDpt();
        String wl=e.getWorklocation();

        String s="select * from Employee where 1=1 ";

        if(id!=0)
        {
            s=s+"and Eid="+id;
        }

        if(fn!=null)
        {
           s=s+"and Fname= '"+fn+"'";
        }
        if(ln!=null)
        {
            s=s+"and Lname='"+ln+"'";
        }
        if(dpt!=null)
        {
            s=s+"and Department='"+dpt+"'";
        }

       if(wl!=null)
       {
        s=s+"and Work_loc='"+wl+"'";
       }

       return jd.queryForList(s);
    }



    public int update(int id, String name)
    {
        String s="update Employee set Department=? where EID=? ";
        return jd.update(s,name,id);
    }

    public int Del(int id)
    {
        String s="delete from Employee where EID=?";
        return jd.update(s,id);
    }



}

 