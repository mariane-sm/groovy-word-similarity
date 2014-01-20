package wordSimilarityChecker

import org.springframework.stereotype.Component;
import javax.inject.*;
import wordSimilarityChecker.annotations.PermissiveChecker;
import groovy.transform.*;

@Component
//@Named
@PermissiveChecker
@Immutable // Immutable here is kind of redundant since @Component already tell us this is immutable
final class PermissiveWordSimilarityChecker implements WordSimilarityChecker {

	private final MAX_DIFFERENT_CHARS_ALLOWED = 3

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
		if (str1.contains(str2))
			if (str1.size() - str2.size() <= MAX_DIFFERENT_CHARS_ALLOWED)
				return true
		if (str2.contains(str1))
			if (str2.size() - str1.size() <= MAX_DIFFERENT_CHARS_ALLOWED)
				return true	
		return false
	}	
}