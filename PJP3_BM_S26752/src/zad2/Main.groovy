/**
 *
 *  @author Bieliński Mateusz S26752
 *
 */

package zad2;


 def processFile() {
	 def projectsTxt = new File("Projekty.txt").text
	 def projects = projectsTxt.split('\n')
	 
	 def bigProjects = []
	 def programmersMap = [:]
	 
	 projects.each { project ->
		 def items  = project.split('\t') as List
		 def projectName = items.remove(0)
		 
		 if(items.size() > 3) {
			 bigProjects << projectName
		 }
		 
		
		 items.each { person ->
			 if (programmersMap[person] == null) {
				 programmersMap[person] = []
			 }
			 
			 programmersMap[person] << projectName
		 }
	 }
	 
	 new File("ProjektyDuze.txt").text = bigProjects.join('\n')
	 
	 def programmersTxt = programmersMap.collect { person, personProjects ->
		 "$person\t${personProjects.join('\t')}"
	 }.join('\n')
	 
	 new File("Programisci.txt").text = programmersTxt
	 
 }
 
 processFile()