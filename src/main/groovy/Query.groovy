package wordSimilarityChecker

import org.springframework.stereotype.Component;
import javax.inject.Inject;   
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
class Query {
	
	@Inject
	private WordSimilarityChecker checker

	final static Logger logger = LoggerFactory.getLogger(Query.class);

	def checkQueriesSimilarity(String str1, String str2) {
		println checker.check(str1, str2)
		logger.info('Finishing log.');
	}
}