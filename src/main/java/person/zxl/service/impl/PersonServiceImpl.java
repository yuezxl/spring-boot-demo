package person.zxl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import person.zxl.dao.PersonDao;
import person.zxl.model.PersonModel;
import person.zxl.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao personDao;

	@Override
	public List<PersonModel> getPersons() {
		PersonModel queryModel = new PersonModel();
		return personDao.select(queryModel);
	}

}
