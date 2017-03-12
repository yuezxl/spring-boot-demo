package person.zxl.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import person.zxl.boot.StartUp;
import person.zxl.model.PersonModel;
import person.zxl.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { StartUp.class })
public class PersonTest {
	@Resource
	private PersonService personService;
	
	@Test
	public void getPersons() {
		List<PersonModel> persons = personService.getPersons();
		System.out.println(JSON.toJSON(persons));
	}
}
