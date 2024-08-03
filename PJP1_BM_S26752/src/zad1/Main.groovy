/**
 *
 *  @author Bieliński Mateusz S26752
 *
 */

package zad1

import javax.swing.JOptionPane

numbersMap = [
  '0': 'zero',
  '1': 'jeden',
  '2': 'dwa',
  '3': 'trzy',
  '4': 'cztery',
  '5': 'pięć',
  '6': 'sześć',
  '7': 'siedem',
  '8': 'osiem',
  '9': 'dziewięć',
  '-': 'minus'
]

def convertNumberToWords(input) {

  def list = []

  input.each {
    list += numbersMap[it]
  }

  def result = list.join(' - ')

  return result
}

def init() {
  def input = JOptionPane.showInputDialog('Wprowadz liczbe:')

  try {
    def words = convertNumberToWords(input)

    JOptionPane.showMessageDialog(null, words)

  } catch (e) {
    JOptionPane.showMessageDialog(null, 'Niepoprawna liczba')
  }

}

init()


 