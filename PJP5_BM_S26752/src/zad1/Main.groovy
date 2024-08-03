/**
 *
 *  @author Bieliński Mateusz S26752
 *
 */

package zad1;

import groovy.json.JsonSlurper

def API_KEY = "391cfac9bf28644f32120e459cec6249" 
def CITY = "Warsaw"  

def parser = new JsonSlurper()
def url = new URL("http://api.openweathermap.org/data/2.5/weather?q=${CITY}&appid=${API_KEY}&units=metric")
def connection = url.openConnection()

try {
	connection.setRequestMethod('GET')
	connection.setRequestProperty('Content-Type', 'application/json')

	int responseCode = connection.getResponseCode()

	if (responseCode == 200) {
		def inputStream = connection.getInputStream()
		def reader = new BufferedReader(new InputStreamReader(inputStream))
		def weatherData = parser.parseText(reader.text)
		
		def temperature = weatherData.main.temp
		def description = weatherData.weather[0].description
		
		println "Aktualna temperatura w ${CITY}: ${temperature} stopni Celsjusza"
		println "Warunki pogodowe: ${description}"
	} else {
		println "Błąd podczas pobierania danych pogodowych. Kod odpowiedzi: ${responseCode}"
	}
} catch (Exception e) {
    println "Wystąpił błąd: ${e.message}"
} finally {
	connection.disconnect()
}
