package com.group2.swpgroup2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.group2.swpgroup2.models.Module;
import com.group2.swpgroup2.repositories.ModuleRepository;

// import com.group2.swpgroup2.models.Course;
// import com.group2.swpgroup2.models.Manager;
// import com.group2.swpgroup2.repositories.CourseRepository;
// import com.group2.swpgroup2.repositories.ManagerRepository;

@SpringBootApplication
public class Swpgroup2Application {
	
	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(Swpgroup2Application.class, args);
		// CourseRepository cRepo = context.getBean(CourseRepository.class);
		// ManagerRepository mRepo = context.getBean(ManagerRepository.class);
		// //Course s = Course.builder().ImgSrc("11a").Rating(5.2f).CourseManager(mRepo.getReferenceById(1)).Description("aaaaa").build();
		// //cRepo.save(Course.builder().ImgSrc("11a").Rating(5.2f).CourseManager(mRepo.getReferenceById(1)).Description("aaaaa").CourseName("test").build());
		// for(Course c : cRepo.findAll()){
		// 	System.out.println(c.toString());
			
		// }
		ModuleRepository mpero = context.getBean(ModuleRepository.class);
		System.out.println(mpero.findAll().size());
		
		for(Module m : mpero.findAll()){
			System.out.println(m.toString());
		}
		System.out.println("vvvvv");
	}

}
