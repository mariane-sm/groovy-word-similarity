package wordSimilarityChecker

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

class Main {

	static main(args) {
		def ctx = new AnnotationConfigApplicationContext(ContextConfiguration)
		ctx.getBean(Xisto.class).checkerFacebook('tomato', 'tomate')
	}
}