package com.roles.demopro;

import java.util.HashMap;
 
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

 

@RestController
public class EmployeeController {
@Autowired
EmployeeService es;
 
@PostMapping("/InsertData")
public Map<String,String> InsertEmp(@RequestBody Employee e)
{
   HashMap<String,String> hm=new HashMap<String,String>();
   
   int x=es.InsertData(e);
    
    if(x==2)
    { 
        hm.put("Auth Fail","The emoployee is not admin");
     
         
    }
    else if(x==0)
    {
        hm.put("Fail","Data is not inserted into database");
    }
    else 
    {
        hm.put("Success","Data is inserted into database");
    }
    

 
 return hm;

}

@PostMapping("/ProjectData")
public Map<String,String> InsertProject(@RequestBody Project p)
{
   HashMap<String,String> hm=new HashMap<String,String>();
   
   int x=es.InsertProd(p);
   
    if(x==2)
    {
        hm.put("Auth Fail","The emoployee is not an admin or a hr");
    }
    else if(x==0)
    {
        hm.put("Fail","Data is not inserted into database");
    }
    else 
    {
        hm.put("Success","Data is inserted into database");
    }
 
 return hm;

}


@PostMapping("/ProjectEmpData")
public Map<String,String> InsertProjectEmp(@RequestBody ProjectEmpDetails pmd)
{
    HashMap<String,String> hm=new HashMap<String,String>();
    int a=es.insert_to_projectemp(pmd);
    if(a==1)
    {
        hm.put("Success","Data Inserted Successfully");
    }
    else if(a==0)
    {
        hm.put("Fail","Data is not inserted");
    }
    else if(a==8)
    {
        hm.put("Exists","Employee is already assigned with project");
    }
    else if(a==9)
    {
        hm.put("Error","The lead your inserting is not assined to any employee");
    }
    else if(a==10)
    {
        hm.put("overload","All the needed employees are assigned");
    }
    else if(a==11)
    {
        hm.put("Execption","the Lead or Hr does not belongs to the project");
    }
    else
    {
        hm.put("AuthFailed"," The employee is not authenticated");
    }
 
     return hm;
}


@GetMapping("/getData")
public  Map display(@RequestParam int id)
{
    return es.displayProjectdetails(id);
}


@PostMapping("/addTask")

public Map<String,String> addTask(@RequestBody TaskList t)
{
    HashMap<String,String> hm=new HashMap<String,String>();

    int x=es.AssignTask(t);
    if(x==1)
    {
        hm.put("Success","Task assigned Successfully");
    }
    else if(x==0)
    {
        hm.put("Failure","Task is not assigned Successfuly");
    }
    else if(x==2)
    {
        hm.put("Eroor","The Lead does not belong to the employee");
    }
    else
    {
        hm.put("Auth","Lead does not exist");
    }

    return hm;
}

}
