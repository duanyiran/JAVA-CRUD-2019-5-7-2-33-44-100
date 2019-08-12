package com.employee.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
public class CRUDController {

    private static List<Employee> list = EmployeeData.employeeList();
    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/employees")
    public String getAll() throws JsonProcessingException {
        return objectMapper.writeValueAsString(list);
    }

    @PutMapping("/employees/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee e) throws JsonProcessingException {
        for(Employee employee : list){
            if(employee.getId() == id){
               employee.update(e);
            }
        }
        return objectMapper.writeValueAsString(list);
    }

    @PostMapping("/employees")
    public String insertEmployee(@RequestBody Employee e) throws JsonProcessingException {
        list.add(e);
        return objectMapper.writeValueAsString(list);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) throws JsonProcessingException {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Employee employee = (Employee) iterator.next();
            if(id == employee.getId()){
                System.out.println(1);
                iterator.remove();
            }
        }
        return objectMapper.writeValueAsString(list);
    }
}
