import spock.lang.Specification;

class WordSimilarityCheckerTest extends Specification { 

	def checker = new WordSimilarityChecker()
	def str1, str2

	def "same word should be similar"() { 
		expect:
			checker.check(str1, str2) == true
			checker.check(str2, str1) == true
		where: 
			str1 = 'tomato'
			str2 = 'tomato'
	}
	
	def "same word should be similar"() { 
		expect: 
			checker.check(str1, str2) == true
			checker.check(str2, str1) == true
		where: 
			str1 = 'tomato'
			str2 = 'tomato'
	}

	def "one different letters should be similar"() { 
		expect: 
			checker.check(str1, str2) == true
			checker.check(str2, str1) == true
		where: 
			str1 = 'toXato'
			str2 = 'tomato'
	}	

	def "one letters missing should be similar"() { 
		expect: 
			checker.check(str1, str2) == true
			checker.check(str2, str1) == true
		where: 
			str1 = 'tomat'
			str2 = 'tomato'
	}	

	def "one extra letters should be similar"() { 
		expect: 
			checker.check(str1, str2) == true
			checker.check(str2, str1) == true
		where: 
			str1 = 'tomatoX'
			str2 = 'tomato'
	}


	def "two different letters should NOT be similar"() { 
		expect: 
			checker.check(str1, str2) == false
			checker.check(str2, str1) == false
		where: 
			str1 = 'toXXto'
			str2 = 'tomato'
	}	

	def "two letters missing should NOT be similar"() { 
		expect: 
			checker.check(str1, str2) == false
			checker.check(str2, str1) == false
		where: 
			str1 = 'toma'
			str2 = 'tomato'
	}	

	def "two extra letters should NOT be similar"() { 
		expect: 
			checker.check(str1, str2) == false
			checker.check(str2, str1) == false
		where: 
			str1 = 'tomatoXX'
			str2 = 'tomato'
	}
}