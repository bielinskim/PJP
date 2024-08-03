/**
 *
 *  @author Bieliński Mateusz S26752
 *
 */

package zad1;

def getMaxAnagrams() {
	def wordsList = new URL('http://wiki.puzzlers.org/pub/wordlists/unixdict.txt').text.readLines()
	
	def groupedAnagrams = wordsList.groupBy { it.toList().sort().join() }
	
	def sortedWordsAnagrams = wordsList
	.collectEntries { word ->
		def key = word.toList().sort().join()
		def anagrams = groupedAnagrams[key].findAll { word != it }
		
		[word, anagrams]
	}.sort { a,b ->
		def aSize = a.value.size()
		def bSize = b.value.size()
		aSize == bSize && aSize > 0 && bSize > 0 ? a.value[0] <=> b.value[0] : bSize <=> aSize
	}
	
	return sortedWordsAnagrams
}

getMaxAnagrams().each { word, anagrams ->
    println("$word ${anagrams.join(" ")}")
}