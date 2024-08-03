/**
 *
 *  @author Bieliński Mateusz S26752
 *
 */

package zad3;

def directoryPath = './'

htmlFiles = []

def fileCount = 1

 def collectHtmlFiles(File directory) {
	 directory.eachFile { file ->
		 if (file.isDirectory()) {
			 collectHtmlFiles(file)
		 } else if (file.name.endsWith('.html')) {
			  htmlFiles << file.absolutePath
		 }
	 }
	 
 }
 
 collectHtmlFiles(new File(directoryPath))
 
 htmlFiles.each { file ->
	 println("${fileCount++} $file")
 }