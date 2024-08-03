/**
 *
 *  @author Bieliński Mateusz S26752
 *
 */

package zad2;

import javax.swing.JOptionPane

def List getData(type = String, validator = {
  true
}, inputMessage = 'Podaj szereg liczb i slow', initialValue = '') {
  def input = JOptionPane.showInputDialog(inputMessage, initialValue)

  try {
    def tokens = input.split("\\s+")
    def list = []

    tokens.each {
      def isValid = validator(it)

      if (!isValid) {
        throw new IllegalArgumentException()
      }

      list += type.valueOf(it)

    }

    return list
  } catch (e) {
    getData(type, validator, 'Niepoprawne dane. Podaj poprawny szereg liczb i slow', input)
  }

}

print(getData(Integer) {
  it > 0
})