package wordSimilarityChecker

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
class Xisto {
	
	@Autowired
	private WordSimilarityChecker checker

	def checkerFacebook(String str1, String str2) {
		println checker.check(str1,str2)
	}
}