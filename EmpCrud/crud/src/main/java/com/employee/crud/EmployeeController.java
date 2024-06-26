package com.employee.crud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService es;

    @PostMapping("/insert")
    public Map insertData(@RequestBody Employee e)
    {
    
        HashMap<String,String> hm=new HashMap<String,String>();
        int x=es.insertData(e);
        if(x>0)
        {
            hm.put("Success","Data inserted Successfully");
        }
        else
        {
            hm.put("Failure","Data is not inserted Successfully");
        }
       return hm;
    }


    @PostMapping("/retrive")

    public List RetiveData(@RequestBody Employee e)
    {
       return es.RetriveData(e);
    }


    
    @PutMapping("/up")

    public Map updatedata(@RequestParam int id, @RequestParam String dname)
    {
        HashMap<String,String> hm=new HashMap<String,String>();
        int i=es.update(id,dname);

        if(i>0)
        {
            hm.put("Success","Data updated Successfully");
        }
        else{
            hm.put("Failure","Data Not updated");
        
        }

        return hm;

    }


    @DeleteMapping("/d/{id}")

    public Map DeleteData(@PathVariable int id)
    {

        HashMap<String,String> hm=new HashMap<String,String>();
        int i=es.Del(id);

        if(i>0)
        {
            hm.put("Success","Data deleted Successfully");
        }
        else{
            hm.put("Failure","Data Not deleted");
        
        }

        return hm;
    }
     

}
