package wordSimilarityChecker

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class Main {

	static main(args) {
		def ctx = new AnnotationConfigApplicationContext(ContextConfiguration)
		ctx.getBean(Query).checkQueriesSimilarity('tomato', 'tomate')
	}
}