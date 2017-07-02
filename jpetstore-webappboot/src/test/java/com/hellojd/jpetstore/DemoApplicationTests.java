package com.hellojd.jpetstore;
import com.hellojd.jpetstore.domain.repository.account.AccountRepository;
import com.hellojd.jpetstore.domain.service.account.AccountService;
import com.hellojd.jpetstore.domain.service.catalog.CatalogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpetStoreApplication.class)
public class DemoApplicationTests {
	@Autowired
	AccountService accountService;
	@Test
	public void contextLoads() {
//		List<Category> categoryList = catalogService.getCategoryList();
//		for(Category cat:categoryList){
//			System.out.println(cat);
//		}
	}

}
