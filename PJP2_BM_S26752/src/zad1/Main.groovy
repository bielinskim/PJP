/**
 *
 *  @author Bieliński Mateusz S26752
 *
 */

package zad1;

import javax.swing.JOptionPane

def List getInts(inputMessage = 'Podaj szereg liczb calkowitych', initialValue = '') {
  def input = JOptionPane.showInputDialog(inputMessage, initialValue)

  try {
    def strings = input.split("\\s+")

    def integers = strings.collect {
      it as Integer
    }

    return integers
  } catch (e) {
    getInts('Niepoprawne dane. Podaj poprawny szereg liczb calkowitych', input)
  }

}

print(getInts())