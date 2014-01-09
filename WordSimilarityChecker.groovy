/*
String similarity: at most 1 character is different
*/
class WordSimilarityChecker {

	def final MAXIMUM_DIFFERENT_CHARS_ALLOWED = 1

	def Boolean check(String str1, String str2) {
		if (str1.size() == str2.size())
			return areSameSizeWordsSimilar(str1, str2)
		return wordsHaveAtMostOneExtraLetter(str1, str2)

	}

	def Boolean wordsHaveAtMostOneExtraLetter(String str1, String str2) {
		if (str1.contains(str2)) {
			if (str1.size() - str2.size() <= MAXIMUM_DIFFERENT_CHARS_ALLOWED)
				return true
		}
		if (str2.contains(str1)) {
			if (str2.size() - str1.size() <= MAXIMUM_DIFFERENT_CHARS_ALLOWED)
				return true
		}
		return false
	}

	def Boolean areSameSizeWordsSimilar(String str1, String str2) {
		def differentCharsCounter = 0
		for (i in 0..(str1.size() - 1)) {
			if (str1[i] != str2[i])
				differentCharsCounter++
		}
		if (differentCharsCounter > MAXIMUM_DIFFERENT_CHARS_ALLOWED)
			return false
		return true
	}
}