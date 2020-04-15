package mz.co.computinglabs.modellib.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import mz.co.computinglabs.modellib.ConfigurationTest;
import mz.co.computinglabs.modellib.dao.IGenericDAO;
import mz.co.computinglabs.modellib.entity.DummyEntity;


@RunWith(SpringRunner.class)
@ContextConfiguration( classes = ConfigurationTest.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
   TransactionalTestExecutionListener.class,DbUnitTestExecutionListener.class
  })
@DatabaseSetup("classpath:dataset/dummy-dataset.xml")
public class GenericDAOTest {
	
	@Autowired
	private IGenericDAO<DummyEntity> genericDAO;
	
	@Test
	public void testFindById_shouldSucced() {
		DummyEntity dummyEntity = genericDAO.findById(DummyEntity.class, 1, true);
		Assert.assertNotNull(dummyEntity);
		Assert.assertTrue(dummyEntity.getPropertyValue().equals("some value"));
	}

}
