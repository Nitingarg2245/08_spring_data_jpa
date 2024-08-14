package com.nitin.spring_data_jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.nitin.spring_data_jpa.entity.Product;
import com.nitin.spring_data_jpa.repo.ProductRepo;
import com.nitin.spring_data_jpa.repo.Studentrepo;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		Studentrepo studentrepo=context.getBean(Studentrepo.class);

		// 1) <S extends T> S save(S entity);
		// Student s1=new Student();
		// s1.setMarks(95);
		// s1.setName("nitin");
		// Student s2=new Student();
		// s2.setMarks(90);
		// s2.setName("ashok");
		// studentrepo.save(s1);
		// studentrepo.save(s2);

		// 2)<S extends T> Iterable<S> saveAll(Iterable<S> entities);
		// Student s1=new Student();
		// s1.setMarks(91);
		// s1.setName("nikita");
		// Student s2=new Student();
		// s2.setMarks(92);
		// s2.setName("ankit");
		// List<Student> list = Arrays.asList(s1,s2);
		// studentrepo.saveAll(list);

		// update using save method
		// Student s1=new Student();
		// s1.setId(1);
		// s1.setMarks(195);
		// s1.setName("nitin garg");
		// studentrepo.save(s1);

		// 3)Optional<T> findById(ID id);
		// System.out.println(studentrepo.findById(4).get());//.get is liye use kiya yha pe ek opetional object return hua hai

		// 4)Iterable<T> findAllById(Iterable<ID> ids);
		// Iterable<Student> allById = studentrepo.findAllById(Arrays.asList(1,2,3));
		// allById.forEach(System.out::println);
		
		// 5)Iterable<T> findAll();
		// Iterable<Student> all= studentrepo.findAll();
		// System.out.println(all.getClass().getName());//for finiding the implemting class for an interface
		// all.forEach(System.out::println);
        // deletebyID
        // studentrepo.deleteById(1);

		// 6) boolean existsById(ID id);
		// System.out.println(studentrepo.existsById(3));

		// 7)long count();
		// System.out.println(studentrepo.count());

		// 8) void deleteById(ID id);
		// studentrepo.deleteById(4);

		// baki sare bhi isi tarah kam karte hai
		// 9)void delete(T entity);

     	// 10)void deleteAllById(Iterable<? extends ID> ids);

    	// 11)void deleteAll(Iterable<? extends T> entities);

   	    // 12) void deleteAll();


// ###############################find by methods for retreival process for non id based fields 

		//ye 4 findBy### methods user deined hai in repo interface u can see their and use here 
		// System.out.println(studentrepo.findByName("ashok"));

		// System.out.println(studentrepo.findByMarks(195));

		// System.out.println(studentrepo.findByNameAndMarksGreaterThanEqual("nikita",85));

		// List<Student>list=studentrepo.findByMarksLessThanEqual(500);
		// list.forEach(System.out::println);


	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$custom queries$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	
		// List<Student>list=studentrepo.getAllStudents();
		// list.forEach(System.out::println);


		// List<Student>list=studentrepo.getStudents();
		// list.forEach(System.out::println);


		// List<String>list=studentrepo.getStudentNamesWithMarks(91);
		// list.forEach(System.out::println);


		// List<Student>list=studentrepo.getStudentsWithMarksGreaterThan100();
		// list.forEach(System.out::println);

		//###################################understanding  pagination &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		ProductRepo pr = context.getBean(ProductRepo.class);
		// List<Product>list=new ArrayList<>();
		// list.add(new Product(1,"105x",15000,"samsung"));
		// list.add(new Product(2,"108x",18000,"apple"));
		// list.add(new Product(3,"215x",25250,"moto"));
		// list.add(new Product(4,"105xhi",19000,"xiaomi"));
		// list.add(new Product(5,"105xpok",150000,"samsung"));
		// list.add(new Product(6,"1dw5x",55000,"nokia"));
		
		// pr.saveAll(list);
		
		// PageRequest pageRequest = PageRequest.of(1, 4);
		// Page<Product> page = pr.findAll(pageRequest);
		// List<Product>list1=page.getContent();
		// list1.forEach(System.out::println);
		
		//###################################understanding  sorting  &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
			List<Product>list=pr.findAll(Sort.by("brand").descending());
			list.forEach(System.out::println);

		}

}
