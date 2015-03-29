# A simple parser that parses a haskell archive, searching for compositions
>transforming it into an easy manipulable scala object, providing some... interfaces

####Currently it does:
	1. Parses simple functions
	2. Parses simple function composition

####What it does not do:
	1. It doesn't check types, or semantics, so if you have an error (i.e too many arguments, your function doesn't type,etc..), this doesn't detect it. (So your output *may* be wrong)
	2. This doesn't parse partially applied functions (TODO)
	3. This does not detect if a function is inside a comment (TODO)
