def verifyNumeric(s: String) = s foreach {
  case x if x.isDigit =>
} 

verifyNumeric("8675309")

verifyNumeric("8675three09")