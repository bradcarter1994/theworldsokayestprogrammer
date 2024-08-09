val inventoryServiceReponse: Either[String, Boolean] = {
  Right(true)
  // Right(false)
  // Left("400 BAD REQUEST")
}

val paymentsServiceResponse: Either[String, Boolean] = {
  Right(true)
  // Right(false)
  // Left("500 INTERNAL SERVER ERROR")
}

val complianceServiceResponse: Either[String, Boolean] = {
  Right(true)
  // Right(false)
  // Left("EXCEEDED TIMEOUT LIMIT")
}

val orderPlacementServiceResponse: Either[String, Boolean] = for {
  weHaveInventory <- inventoryServiceReponse
  customerHasMoney <- paymentsServiceResponse
  laywersSayOk <- complianceServiceResponse
} yield weHaveInventory && customerHasMoney && laywersSayOk

println(orderPlacementServiceResponse)

println(s"${inventoryServiceReponse.isRight} X ${paymentsServiceResponse.isRight} X ${complianceServiceResponse.isRight} = ${orderPlacementServiceResponse.isRight}")