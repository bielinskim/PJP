/**
 *
 *  @author Bieliński Mateusz S26752
 *
 */

package zad2

import javax.swing.JOptionPane

def formatMap(items) {
  def result = items.collect { key, value -> "$key = $value" }.join(',\n')

  return result;
}

def addItem(items, input) {
  (position, cost) = input.tokenize(' = ')

  if (items[position] == null) {
    items[position] = cost as Double
  } else {
    items[position] += cost as Double
  }
}

def init() {
  items = [:]

  while (true) {
    def input = JOptionPane.showInputDialog(formatMap(items) + '\n Wprowadz napis w formie: pozycja = koszt:')

    if (input == null || input.isEmpty()) {
      break;
    }

    addItem(items, input)
  }

  JOptionPane.showMessageDialog(null, formatMap(items))

}

init()


 