/**
 *
 *  @author Bieliński Mateusz S26752
 *
 */

package zad1;

def isValidDate(year, month, day) {
	def daysInMonth = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

	if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
		daysInMonth[2] = 29
	}

	return day <= daysInMonth[month]
}

def getDates(text) {
	def dateRegex = /(\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])/
	
	def validDates = []
	
	text.eachMatch(dateRegex) {
		def year = it[1] as int
		def month = it[2] as int
		def day = it[3] as int
	
		if (isValidDate(year, month, day)) {
			validDates.add(it[0])
		}
	}
	
	return validDates

}

print(getDates("Tekst z datami 2023-01-15, 2024-02-29, 2023-04-31, 2023-12-25 i inne."))
 