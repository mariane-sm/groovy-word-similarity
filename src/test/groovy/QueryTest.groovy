package wordSimilarityChecker.test

import spock.lang.Specification;
import javax.inject.Inject;
import org.springframework.test.context.ContextConfiguration;
import wordSimilarityChecker.WordSimilarityChecker;
import wordSimilarityChecker.Query;

class QueryTest extends Specification { 

	def strictChecker = Mock(WordSimilarityChecker)
	def permissiveChecker = Mock(WordSimilarityChecker)
	def Query queryChecker = new Query(strictChecker, permissiveChecker)
	
	def "Using mocks to test invocations"() {
		given:
			def str1 = 'tomato'
			def str2 = 'tomatos' 
		when:'checkQueriesSimilarity is called'
			queryChecker.checkQueriesSimilarity(str1, str2)
		then: 'it mus call its dependencies once'
			1 * strictChecker.check(str1,str2)
			1 * permissiveChecker.check(_,_)
	}
}