package com.esercizio4spring.esercizio4_srping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.esercizio4spring.esercizio4_srping.data.IOrdineDAO;
import com.esercizio4spring.esercizio4_srping.model.Ordine;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class Esercizio4SrpingApplicationTests {

	@Autowired
	private IOrdineDAO oDao;

	@Test
	void contextLoads() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				Esercizio4SrpingApplication.class);

		Ordine o1 = ctx.getBean(Ordine.class);
		if (!oDao.present(o1)) {
			oDao.save(o1);

		}
		log.info("Nuovo ordine : " + o1.toString());
		ctx.close();
	}

}
