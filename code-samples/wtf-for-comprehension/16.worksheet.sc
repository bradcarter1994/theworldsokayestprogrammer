import scala.util.{Try, Success, Failure}

case class RawRequestData(customerId: String, orderId: String)
case class RequestData(customerId: Int, orderId: Int)

def validateId(id: String): Try[Int] = Try {
  id.toInt
}

def validateRequestData(raw: RawRequestData): Try[RequestData] = for {
  validatedCustomerId <- validateId(raw.customerId)
  validatedOrderId <- validateId(raw.orderId)
} yield RequestData(validatedCustomerId, validatedOrderId)

val rawRequest = RawRequestData(
  "1234", // "not a valid id",
  "5678"	// "also not a valid id"
)

validateRequestData(rawRequest) match {
  case Success(validatedRequestData) => println(s"We validated the request successfully: $validatedRequestData")
  case Failure(exception) => println(s"There was a problem: $exception")
}