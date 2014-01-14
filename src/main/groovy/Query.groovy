package wordSimilarityChecker

import org.springframework.stereotype.Component;
import javax.inject.Inject;   
//import org.springframework.beans.factory.annotation.Autowired;

@Component
class Query {
	
	@Inject
	private WordSimilarityChecker checker

	def checkQueriesSimilarity(String str1, String str2) {
		println checker.check(str1,str2)
	}
}