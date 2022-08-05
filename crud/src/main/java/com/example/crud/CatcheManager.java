package com.example.crud;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CatcheManager {
	@Autowired
	private EmployeeRepository emprep;
	public static HashMap<Integer,Employee> cache=new HashMap<>();
	@Scheduled(cron="* * * * * *")
	public void loadCache() {
		System.out.println("Cache load started");
		List<Employee> list=emprep.findAll();
		list.forEach(employee->cache.put(employee.getId(), employee));
		System.out.println("Cache load ended");
	}

}
