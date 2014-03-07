package wordSimilarityChecker

import javax.inject.*;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@interface StrictChecker {
}