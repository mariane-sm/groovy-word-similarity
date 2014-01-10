class TestMain {
	static main(args) {
		def checker = new WordSimilarityChecker()
		println checker.check("tomato", "tamato")
		println checker.check("Xomato", "tomato")
		println checker.check("tomato", "tomatoX")
		println checker.check("tomato", "Xtomato")
		println checker.check("Xtomato", "tomato")
		println checker.check("tomatoX", "tomato")
		println checker.check("tomat", "tomato")
		println checker.check("tomato", "tomat")

		println("")

		println checker.check("tomatoXX", "tomato")
		println checker.check("tomato", "tomatoXX")
		println checker.check("tomato", "tamata")
		println checker.check("tomato", "toma")
		println checker.check("toma", "tomato")
	}
}
