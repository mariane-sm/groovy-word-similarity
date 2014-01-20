package wordSimilarityChecker

import org.springframework.stereotype.Component;
import javax.inject.*;
import javax.annotation.Resource;   
import groovy.util.logging.Slf4j

import org.springframework.beans.factory.annotation.Qualifier;
import wordSimilarityChecker.annotations.StrictChecker;
import wordSimilarityChecker.annotations.PermissiveChecker;

@Slf4j 
@Component 
class Query {
	
	//Injection by constructor, so the dependencies can be mocked.
	@Inject
	def Query(@StrictChecker WordSimilarityChecker strictChecker, @PermissiveChecker WordSimilarityChecker permissiveChecker) {
		this.strictChecker = strictChecker
		this.permissiveChecker = permissiveChecker
	}

	/*
		@Resource, @Inject, @Named are JSRs
		@Qualifier is Spring annotation (do not confuse with javax.inject.Qualifier)
		@Autowired is Spring annotation

		@Autowired === javax @Inject
		@Component === javax @Named

		More on: 
		http://blogs.sourceallies.com/2011/08/spring-injection-with-resource-and-autowired/
		http://docs.spring.io/spring/docs/current/spring-framework-reference/html/beans.html#beans-annotation-config
	*/
	
	//Possible ways of using annotations:
	//@Resource(name='strictWordSimilarityChecker')
	//@Named('strictWordSimilarityChecker')
	//@Inject @Qualifier('strictWordSimilarityChecker')
	//@Inject @StrictChecker
	private final WordSimilarityChecker strictChecker

	//@Inject @PermissiveChecker
	private final WordSimilarityChecker permissiveChecker

	def checkQueriesSimilarity(String str1, String str2) {
		println strictChecker.check(str1, str2)
		println permissiveChecker.check(str1, str2)
		log.info('Finishing log.');
	}
}