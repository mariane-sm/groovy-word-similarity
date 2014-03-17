package wordSimilarityChecker

import org.springframework.stereotype.Component

@Component
//@Named
@StrictChecker
class StrictWordSimilarityChecker implements WordSimilarityChecker {

	private final MAX_DIFFERENT_CHARS_ALLOWED = 1

	Boolean check(String str1, String str2) {
		if (str1 == null || str2 == null)
			return false
		if (str1.size() == str2.size())
			return areSameSizeWordsSimilar(str1, str2)
		return haveAllowedQuantityOfExtraLetters(str1, str2)
	}

	private def areSameSizeWordsSimilar(String str1, String str2) {
		def differentCharsCounter = 0
		for (i in 0..(str1.size() - 1))
			if (str1[i] != str2[i])
				differentCharsCounter++
		
		if (differentCharsCounter > MAX_DIFFERENT_CHARS_ALLOWED)
			return false
		return true
	}

	private def haveAllowedQuantityOfExtraLetters(String str1, String str2) {
        if (str1.contains(str2)) return haveAcceptableSize(str1, str2)
		if (str2.contains(str1)) return haveAcceptableSize(str2, str1)
		return haveAcceptableSize(str2, str1) && nonSubstringHasAllowedQuanityOfMissingLetters(str1,str2)
	}

    private boolean haveAcceptableSize(String str1, String str2) {
        if (str1.size() > str2.size())
            return str1.size() - str2.size() <= MAX_DIFFERENT_CHARS_ALLOWED
        return str2.size() - str1.size() <= MAX_DIFFERENT_CHARS_ALLOWED
    }

    private boolean nonSubstringHasAllowedQuanityOfMissingLetters(String str1, String str2) {
        String longStr = str1.size() > str2.size() ? str1 : str2
        String shortStr = str1.size() > str2.size() ? str2 : str1
        int missingLetters = 0;

        for (int i = 0; i < longStr.size(); i++) {
            if (longStr[i] != shortStr[i - missingLetters]) {
                missingLetters++
            }
        }

        return missingLetters <= MAX_DIFFERENT_CHARS_ALLOWED
    }
}