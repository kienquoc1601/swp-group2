package com.group2.swpgroup2;

// import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// import com.group2.swpgroup2.models.Course;
// import com.group2.swpgroup2.models.Module;
// import com.group2.swpgroup2.repositories.CourseRepository;
// import com.group2.swpgroup2.repositories.ModuleRepository;

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


		// CourseRepository cRepo = context.getBean(CourseRepository.class);
		// List<Course> clist = cRepo.findByCategoryName(null);
		// for(Course c : clist){
		// 	System.out.println(c.getCourseName());
		// }
	}

}
