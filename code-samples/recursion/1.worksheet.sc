val someNumbers = (1 to 10).toList

var total = 0

for (number <- someNumbers) {
  total = total + number
}

println(s"The total is $total")