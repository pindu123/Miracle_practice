 
package com.roles.demopro;

import java.sql.Date;
import java.util.ArrayList;
 
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    JdbcTemplate jd;

    public int InsertData(Employee e) {
        int roleId = 0;

        String Admin_user = e.getAdm_mail();
        String Admin_pass = e.getAdm_passwd();
         
       

        String s = "select roleId from Employee where Workmail=? and pswd=?";

        List<Map<String, Object>> lm = new ArrayList<>();

        try {
             lm = jd.queryForList(s, Admin_user, Admin_pass);

            for (Map<String, Object> m : lm) {
                if (m.containsKey("roleId")) {
                    
                    roleId = ((Number) m.get("roleId")).intValue();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
             return 3;
        }

        int i = 0;
        System.out.print(roleId);

        if (roleId == 1) {
            String fn = e.getFname();
            String ln = e.getLname();

            String wm = fn.substring(0, 1) + ln + "@miraclesoft.com";
            String pswd = fn.substring(fn.length() - 2, fn.length() - 1).toUpperCase() + fn.substring(fn.length() - 1) + "#" + ln.substring(ln.length() - 2);
            String st = "insert into Employee(Fname,Lname,Department,Phno,gmail,Workmail,pswd,Work_loc,pincode,salary,roleId,AssignedBy) " +
                        "values(?,?,?,?,?,?,concat(?,DATE_FORMAT(CURRENT_TIMESTAMP, '%H.%i')),?,?,?,?,?)";

            i = jd.update(st, fn, ln, e.getDpt(), e.getPhno(), e.getGmail(), wm, pswd, e.getWorklocation(), e.getPincode(), e.getSalary(), e.getRoleId(), Admin_user);
        } else {
            i = 2;
        }

        return i;
    }


   public int InsertProd(Project p)
   {
    int r = 0;

    String Admin_user = p.getAdmail();
    String Admin_pass = p.getAdpass();

    

    String s = "select roleId from Employee where Workmail=? and pswd=?";

    List<Map<String, Object>> lm = new ArrayList<>();

    try {
         lm = jd.queryForList(s, Admin_user, Admin_pass);

        for (Map<String, Object> m : lm) {
            if (m.containsKey("roleId")) {
                
                r  = ((Number) m.get("roleId")).intValue();
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
         return 3;
    }

   
   if(r==1  )
   {
     
    // Date d2=p.getEndDate();

    String str="Insert into Project(pname,clientInfo,assignedBy,startdate,end_date,duration,hr,pm,no_of_emp) values(?,?,?,current_date,?,DATEDIFF(?,date(now())),?,?,?)";
    
    return jd.update(str,p.getPname(),p.getClientInfo(),Admin_user,p.getEndDate(),p.getEndDate(),p.getHr(),p.getPm(),p.getNoOfemp());

   }
   else if( r==3 )
   {
    String str="Insert into Project(pname,clientInfo,assignedBy,startdate,end_date,duration,hr,pm,no_of_emp) values(?,?,?,current_date,?,DATEDIFF(?,date(now())),?,?,?)";
    
    return jd.update(str,p.getPname(),p.getClientInfo(),Admin_user,p.getEndDate(),p.getEndDate(),p.getHr(),p.getPm(),p.getNoOfemp());
   }
   else
   {
     return 2;
   }

  }

 public int insert_to_projectemp(ProjectEmpDetails p1)
 {
    int r=0;
    String user = p1.getUsername();
    String pass = p1.getPassword();
    try
    {
    
    
    String s = "select roleId from Employee where Workmail=? and pswd=?";

    List<Map<String, Object>> lm = new ArrayList<>();

    
         lm = jd.queryForList(s, user, pass);

        for (Map<String, Object> m : lm) {
            if (m.containsKey("roleId")) {
                
                r  = (int) m.get("roleId");
            }
        }
     System.out.println(r);
    
     if(r==2 || r==3)
     {
        System.out.println("s");
        String as=" ";
        if(r==2)
        {
            String str1="select pm from Project where pid=?";
            List<Map<String,Object>> lm1=jd.queryForList(str1,p1.getPid());
             
            for(Map<String, Object> mp1:lm1)
            {
                as=(String)mp1.get("pm");
            }
        }
        
        if(r==3)
        {
            String str2="select hr from Project where pid=?";
            List<Map<String,Object>> lm1=jd.queryForList(str2,p1.getPid());
             
            for(Map<String, Object>  mp1:lm1)
            {
                as=(String)mp1.get("hr");
            } 
        }
          System.out.println(as);
       if(as.equals(user))
       {
        int emp_id=p1.getEid(); 
        System.out.println(emp_id);

        String s1="select Eid from Employee";
    
        
        List<Map<String,Object>> l=jd.queryForList(s1);
        
        boolean c=false;

        for(Map<String, Object>  m:l)
        {
            if(m.containsValue(emp_id))
            {
              c=true;
            }
        }
           System.out.println(c);
         if(c)
         {
            String s2="select eid from ProjectEmpDetails";
            List<Map<String,Object>> l1=jd.queryForList(s2);
             boolean ck=true;
            for(Map<String, Object>  m1: l1)
            {
                if(m1.containsValue(emp_id))
                {
                    ck=false;
                    return 8;
                }
            }
            System.out.println(ck);

            int p_id=p1.getPid();
            String s3="select pid from Project";
            boolean pk=false;
            List<Map<String,Object>> l2=jd.queryForList(s3);
            for(Map<String, Object>  m2:l2)
            {
                if(m2.containsValue(p_id))
                {
                   pk=true;
                }
            }
            System.out.println(pk);
            // int ctr=0;
            // System.out.println(ctr);
            // String s12="select pid from ProjectEmpDetails";
            // List<Map<String,Object>> ls1=jd.queryForList(s12);
             
            // for(Map ms:ls1)
            // {
            //     int st4=(int)ms.get("pid");
            //     System.out.println(st4);
            //     if(st4==0)
            //     {
            //         ctr=0;
            //     }
            //     else{
            //         ctr=(st4);
            //     }
                
            //     System.out.println(ctr);
            // }
            // System.out.println(ctr);
            // int sum=0;
            // String st1="Select  no_of_emp  as s from Project where pid=?";
            // List<Map<String,Object>> ls2=jd.queryForList(st1,p1.getPid());
            // for(Map m14:ls2)
            // {
            //     sum=(int)m14.get("s");
            // }
            //  System.out.println(sum);
            String s10="select case when ((select count(eid) from ProjectEmpDetails group by pid having pid=?)<(select no_of_emp from Project where pid=?)) then concat('true') else concat('false') end as val from ProjectEmpDetails limit 1";
            List<Map<String,Object>> l10=jd.queryForList(s10,p_id,p_id);
            String a="false";
            for(Map<String, Object>  m10:l10)
            {
                a=(String)m10.get("val");
            }
             System.out.println(a);
            if(a.equals("false")  )
            {
                return 10;
            }
 
            String s4="select roleid from Employee where  Eid=? ";
             System.out.println(s4);
            List<Map<String,Object>> l3=jd.queryForList(s4,emp_id);
              int r_id=0;
            for(Map<String, Object>  m3:l3)
            {
                r_id=(int)m3.get("roleid");
            }
            System.out.println(r_id);
            String lname=" ";
            
            


            if(r_id!=4)
            {
              System.out.println(0);
                String s9="select p1.plead from ProjectEmpDetails p1  join Project p join Employee e on p1.pid=p.pid and p1.eid=e.Eid where p1.pid=?  and e.roleId!=4 limit 1";
                List<Map<String,Object>> l9=jd.queryForList(s9,p_id);
                for(Map<String, Object>  m9:l9)
                {
                    lname=(String)m9.get("plead");
                }
                 System.out.println(lname);


                if(lname.equals(" "))
                {
                String s5="select  Workmail from Employee where roleId=4 and Workmail not in (select plead from ProjectEmpDetails)   order by Eid limit 1";
                List<Map<String,Object>> l5=jd.queryForList(s5);

                for(Map<String, Object>  m4:l5)
                {
                    System.out.println(m4.get("Workmail"));
                    lname=(String)m4.get("Workmail");
                }
                System.out.println(lname);
                 }
            }
            else if(r_id==4)
            {
                String str1="select plead from ProjectEmpDetails where pid=?";
                 List<Map<String,Object>> l12=jd.queryForList(str1,p1.getPid());
                 
                 for(Map<String, Object>  mp:l12)
                 {
                    lname=(String)mp.get("plead");
                 }
                 System.out.println(lname);
                String s11="select Workmail from Employee where eid=?";
                List<Map<String,Object>> l11=jd.queryForList(s11,p1.getEid());
                String m="";
                 
                for(Map<String, Object>  m11:l11)
                {
                    m=(String)m11.get("WorkMail");
                }
                System.out.println(m);
                if(m.equals(lname))
                {

                //String s6="Select Workmail from Employee  where roleid=2 and Workmail not in (select plead from ProjectEmpDetails)";
                String s6="select pm from Project where pid=?";
                List<Map<String,Object>> l6=jd.queryForList(s6,p1.getPid());
                for(Map<String, Object>  m5:l6)
                {
                    lname=(String)m5.get("pm");
                }
                } 
               else
               {
                return 9;
                 }
                

            }


           System.out.println(lname);
            if(ck==true && pk==true)
            { 

           System.out.println(lname);
                String s7="insert into ProjectEmpDetails values(?,?,?,?,?)";
                System.out.println(s7);
                 
                 int i=jd.update(s7,p1.getPid(),p1.getEid(),p1.getAssignedDate(),lname,user);
                System.out.println(i);
                System.out.println(s7);
                 return i;

            }
         }
    }
    else
    {
        return 11;
    }

}
else
{
    return 2;
}

    }
    catch(Exception e)
    {

    }
 return 5;


 }




 public Map displayProjectdetails(int id)
 {
    // ArrayList  al=new ArrayList ();
     String sq="select * from Project where pid=?";

    List<Map<String,Object>> l=jd.queryForList(sq,id);

    String sq1="Select * from Employee";

    List<Map<String,Object>> l1=jd.queryForList(sq1);

    String s2="Select eid from ProjectEmpDetails where pid=?";

    List<Map<String,Object>> l2=jd.queryForList(s2,id);
    int p_id=0;
    int e_id=0;
   
     
    LinkedHashMap  hm=new LinkedHashMap();


    for(Map m: l)
    { 
       hm.put("pid",m.get("pid"));
       hm.put("pname",m.get("pname"));
       hm.put("clientInfo",m.get("clientInfo"));
       hm.put("startdate",m.get("startdate"));
       hm.put("end_date",m.get("end_date"));
       hm.put("duration",m.get("duration"));
       hm.put("Project Manager",m.get("pm"));
       hm.put("HR",m.get("hr"));
    }
    ArrayList a=new ArrayList();
    for(Map m1:l2)
    {
      e_id=(int)m1.get("eid");
      int x=0;
      for(Map m2:l1)
      {
        x=(int)m2.get("eid");
        if(e_id==x)
        {
            a.add(m2);
        }
      }
    }

    hm.put("Employees",a);

    return hm;
     
 }




public int AssignTask(TaskList t)
{
 
    String lname=t.getLuname();
    String pass=t.getLpswd();

    String s="select plead from ProjectEmpDetails";
    int c=0;
    List<Map<String,Object>> l=jd.queryForList(s);
    for(Map m:l)
    {
        if(m.containsValue(lname))
        {
            c=1;
        }
    }
    if(c==1)
    {
         int asgto=t.getAssignedTo();

        String s1="select pid from ProjectEmpDetails where plead=? and eid=?";
        List<Map<String,Object>> l1=jd.queryForList(s1,lname,asgto);
         int p_id=0;
        for(Map m1:l1)
        {
           p_id=(int)m1.get("pid");
        }

        if(p_id!=0)
        {
            int due=t.getDuration()/8;
            String s2="insert into TaskList(Tname,CreatedBy,AssignedTo,AssignedDate,StartDate,Duration,Enddate,tstatus,tdescription) values(?,?,?,current_date(),?,?,date_add(?,interval ? day),?,?)";

          int i=jd.update(s2,t.getTname(),lname,t.getAssignedTo(),t.getStartdate(),t.getDuration(),t.getStartdate(),due,t.getTaskstatus(),t.getDescription());

            return i;
        }
        else{
            return 2;
        }
    }

    return 3;

}

 

}

