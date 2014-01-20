package wordSimilarityChecker

import org.springframework.stereotype.Component;
import javax.inject.Inject;   
import groovy.util.logging.Slf4j

@Slf4j
@Component 
class Query {
	
	@Inject
	private WordSimilarityChecker checker

	def checkQueriesSimilarity(String str1, String str2) {
		println checker.check(str1, str2)
		log.info('Finishing log.');
	}
}