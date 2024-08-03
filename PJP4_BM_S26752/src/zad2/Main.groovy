/**
 *
 *  @author Bieliński Mateusz S26752
 *
 */

package zad2;

def customers = new File('customers.txt').readLines().collect  {
	properties = it.split(';')
	
	[
	    id: properties[0],
	    name: properties[1],
	    product: properties[2],
	    price: properties[3] as Double,
	    quantity: properties[4] as Integer
	]
	
}
	
println("Nazwiska")
customers.sort { a,b ->
	def aLastName = a.name.split(' ')[0]
	def bLastName = b.name.split(' ')[0]
	
	aLastName == bLastName ? a.id <=> b.id : aLastName <=> bLastName
}
customers.each { println("${it.id};${it.name};${it.product};${it.price};${it.quantity}") }

println("Koszty")
customers.sort { a,b ->
	def aCost = a.price * a.quantity
	def bCost = b.price * b.quantity
	
	aCost == bCost ? a.id <=> b.id : bCost <=> aCost
}
customers.each { println("${it.id};${it.name};${it.product};${it.price};${it.quantity} (koszt: ${it.price * it.quantity})") }

println("Klient c00001")
customers.findAll() { it.id == 'c00001' }.each { println("${it.id};${it.name};${it.product};${it.price};${it.quantity}") }

['c00001', 'c00002'].each {
	println("Klient $it")
	def id = it
	
	customers.findAll() { it.id == id }.each { println("${it.id};${it.name};${it.product};${it.price};${it.quantity}") }
}
